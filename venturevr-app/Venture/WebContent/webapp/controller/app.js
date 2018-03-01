var home = angular.module('home', [ 'ngRoute', 'usersControllers', ]);

home.run([ '$rootScope', '$location', '$timeout', 'AUTH_EVENTS', 'Authentication', 
	function($rootScope, $location, $timeout, AUTH_EVENTS, Authentication) {
	$rootScope.$on('$routeChangeStart', function(event, next) {
		if (next.isRestricted) {
			if(!Authentication.isAuthenticated()){
				$rootScope.message = 'Sorry, you must log in to access that page';
				$rootScope.state = 'error';
				$location.path('/login');
				$timeout(function(){
					$rootScope.message ="";
				}, 5000);
		    }  	
		}// Auth Required
	}); // $routeChangeStart
} ]); // run



home.config([ '$routeProvider', function($routeProvider) {
	$routeProvider.when('/home', {
		templateUrl : 'webapp/view/home.html',
		controller : 'EstController',
		isRestricted: false
	}).when('/details/:itemId', {
		templateUrl : 'webapp/view/details.html',
		controller : 'DetailsController',
		isRestricted: false
	}).when('/est_videos/:estId', {
		templateUrl : 'webapp/view/est_videos.html',
		controller : 'VideoController',
		isRestricted: false
	}).when('/login', {
		templateUrl : 'webapp/view/login.html',
		controller : 'RegistrationController',
		isRestricted: false
	}).when('/register', {
		templateUrl : 'webapp/view/register.html',
		controller : 'RegistrationController',
		isRestricted: false
	}).when('/profile', {
		templateUrl : 'webapp/view/profile.html',
		controller : 'ProfileController',
		isRestricted: true
	}).when('/edit_profile', {
		templateUrl : 'webapp/view/edit_profile.html',
		controller : 'ProfileController',
		isRestricted: true
	}).otherwise({
		redirectTo : '/home'
	})
} ]);
