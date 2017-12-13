var home = angular.module('home', [ 'ngRoute', 'usersControllers', ]);

home.run([ '$rootScope', '$location', 'AUTH_EVENTS', 'Authentication', 
	function($rootScope, $location, AUTH_EVENTS, Authentication) {
	$rootScope.$on('$routeChangeStart', function(event) {
		if ($location.$$url == '/profile') {
			if(!Authentication.isAuthenticated()){
				$rootScope.message = 'Sorry, you must log in to access that page';
				$location.path('/login');
		    }  	
		}// Auth Required
	}); // $routeChangeStart
} ]); // run


/*app.run(['$rootScope', '$location', 'Auth', function ($rootScope, $location, Auth) {
    $rootScope.$on('$routeChangeStart', function (event) {

        if (!Auth.isLoggedIn()) {
            console.log('DENY');
            event.preventDefault();
            $location.path('/login');
        }
        else {
            console.log('ALLOW');
            $location.path('/home');
        }
    });
}]);*/

home.config([ '$routeProvider', function($routeProvider) {
	$routeProvider.when('/home', {
		templateUrl : 'webapp/view/home.html',
		controller : 'EstController'
	}).when('/details/:itemId', {
		templateUrl : 'webapp/view/details.html',
		controller : 'DetailsController'
	}).when('/est_videos/:estId', {
		templateUrl : 'webapp/view/est_videos.html',
		controller : 'VideoController'
	}).when('/login', {
		templateUrl : 'webapp/view/login.html',
		controller : 'RegistrationController'
	}).when('/register', {
		templateUrl : 'webapp/view/register.html',
		controller : 'RegistrationController'
	}).when('/profile', {
		templateUrl : 'webapp/view/profile.html',
		controller : 'ProfileController'/*,
		resolve : {
			currentAuth : function(Authentication) {
				return Authentication.isAuthenticated();
			}
		}// resolve
*/	}).otherwise({
		redirectTo : '/home'
	})
} ]);
