var home = angular.module('home', [
  'ngRoute',
  'usersControllers',
  'firebase'
]);

home.run(['$rootScope', '$location', function($rootScope, $location) {
	  $rootScope.$on('$routeChangeError', function(event, next, previous, error) {
	    if (error == 'AUTH_REQUIRED') {
	      $rootScope.message = 'Sorry, you must log in to access that page';
	      $location.path('/login');
	    }//Auth Required
	  }); //$routeChangeError
	}]); //run

home.config(['$routeProvider', function($routeProvider) {
  $routeProvider.
  when('/home', {
    templateUrl: 'webapp/view/home.html',
    controller: 'EstController'
  }).
  when('/details/:itemId', {
    templateUrl: 'webapp/view/details.html',
    controller: 'DetailsController'
  }).
  when('/est_videos/:estId', {
	    templateUrl: 'webapp/view/est_videos.html',
	    controller: 'VideoController'
  }).
  when('/login', {
	    templateUrl: 'webapp/view/login.html',
	    controller: 'RegistrationController'
  }).
  when('/register', {
	    templateUrl: 'webapp/view/register.html',
	    controller: 'RegistrationController'
  }).
  when('/success', {
      templateUrl: 'webapp/view/success.html',
      controller: 'SuccessController',
      resolve: {
        currentAuth: function(Authentication) {
          return Authentication.requireAuth();
        } //currentAuth
      }//resolve
    }).
  otherwise({
    redirectTo: '/home'
  })
}]);

