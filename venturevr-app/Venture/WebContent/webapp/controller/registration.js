home.controller('RegistrationController', ['$scope', '$rootScope', '$http', 'AUTH_EVENTS', 'Authentication',
	function($scope, $rootScope, $http, AUTH_EVENTS, Authentication) {
	
	$scope.setCurrentUser = function (user) {
		// $scope.currentUser = user;
		 $scope.currentUser = sessionStorage.setItem('user', user);
	};
	
	$scope.currentUser = sessionStorage.getItem('user');
	
	/*$scope.getCurrentUser = function () {
	     $scope.currentUser = sessionStorage.getItem('user');
		 return $scope.currentUser;
	};*/
	
	$scope.auth = function() {

	        Authentication.requireAuth($scope.user).then(function(data) {
	        	$scope.message =AUTH_EVENTS.loginSuccess;
	            $scope.login();
	          }, function () {
	        	  $scope.message =AUTH_EVENTS.loginFailed;
	          });     
	};
	
    $scope.login = function() {

        Authentication.login($scope.user).then(function(user) {
        	$scope.message =AUTH_EVENTS.loginSuccess;
            $scope.setCurrentUser(user.username);
            window.location = "#/profile"; 
            
          }, function () {
        	  $scope.message = AUTH_EVENTS.loginFailed;
          });
          
    };

    $scope.logout = function() {
         Authentication.logout();
  		    $scope.message =AUTH_EVENTS.auth-logout-success;  
    };

    $scope.register = function() {
         Authentication.register($scope.user).then(function(data) {
        	 $scope.message = AUTH_EVENTS.registerSuccess;
             $scope.state = "success";
             $scope.auth();
         }, function () {
	         $scope.message = AUTH_EVENTS.registerFailed;
	         $scope.state = "error";
         });
    }; //register

}]); //Controller