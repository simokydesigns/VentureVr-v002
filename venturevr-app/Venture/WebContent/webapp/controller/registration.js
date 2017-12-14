home.controller('RegistrationController', ['$scope', '$rootScope', '$http', 'AUTH_EVENTS', 'Authentication',
	function($scope, $rootScope, $http, AUTH_EVENTS, Authentication) {
	
	$scope.setCurrentUser = function (user) {
		    $scope.currentUser = user;
	};
	
	$scope.auth = function() {

	        Authentication.requireAuth($scope.user).then(function(data) {
	            $rootScope.$broadcast(AUTH_EVENTS.loginSuccess);
	            $scope.login();
	          }, function () {
	            $rootScope.$broadcast(AUTH_EVENTS.loginFailed);
	          });     
	};
	
    $scope.login = function() {

        Authentication.login($scope.user).then(function(user) {
        	$scope.message =AUTH_EVENTS.loginSuccess;
            $scope.setCurrentUser(user.userName);
            window.location = "#/profile"; 
            
          }, function () {
        	  $scope.message = AUTH_EVENTS.loginFailed;
          });
          
    };

    $scope.logout = function() {
         Authentication.logout().then(function(value){
        	 $rootScope.$broadcast(AUTH_EVENTS.auth-logout-success);
         });
    };

    $scope.register = function() {
         Authentication.register($scope.user).then(function(data) {
        	 $scope.message = AUTH_EVENTS.registerSuccess;
             $scope.state = "success";
         }, function () {
	         $scope.message = AUTH_EVENTS.registerFailed;
	         $scope.state = "error";
         });
    }; //register

}]); //Controller