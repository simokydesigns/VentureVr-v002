home.controller('RegistrationController', ['$scope', '$rootScope', '$http', 'AUTH_EVENTS', 'Authentication',
	function($scope, $rootScope, $http, AUTH_EVENTS, Authentication) {
	
	$scope.setCurrentUser = function (user) {
		    $scope.currentUser = user;
	};
	
	$scope.auth = function() {

	        Authentication.requireAuth($scope.user).then(function(user) {
	            $rootScope.$broadcast(AUTH_EVENTS.loginSuccess);
	            $scope.login($scope.user);
	          }, function () {
	            $rootScope.$broadcast(AUTH_EVENTS.loginFailed);
	          });     
	};
	
    $scope.login = function() {

        Authentication.login($scope.user).then(function(user) {
            $rootScope.$broadcast(AUTH_EVENTS.loginSuccess);
            $scope.setCurrentUser(user.userName);
            window.location = "#/profile"; 
            
          }, function () {
            $rootScope.$broadcast(AUTH_EVENTS.loginFailed);
          });
          
    };

    $scope.logout = function() {
         Authentication.logout().then(function(value){
        	 $rootScope.$broadcast(AUTH_EVENTS.auth-logout-success);
         });
    };

    $scope.register = function() {
        // Authentication.register($scope.user);

        var dataUser = {
            "userName": this.user.username,
            "password": this.user.password
        };
        
        $http.post('http://localhost:8080/venture-service/api/newuser/', JSON.stringify(dataUser)).then(function(response) {
            //if (response.dataUser)
                $scope.message = "You have registered successfully! Please login to create profile.";
                $scope.state = "success";
                //window.location = "#/login/";
        }, function(response) {
            $scope.message = "The user name already exists!";
            $scope.state = "error";
            $scope.statusval = response.status;
            $scope.statustext = response.statusText;
            $scope.headers = response.headers();
        });

    }; //register

}]); //Controller