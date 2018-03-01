home.controller('ProfileController', ['$scope', 'Authentication', function($scope, Authentication) {
  
  $scope.message = "Success!!!";
  
  $scope.isEditable = {
		    isDisabled: true
  };
  

  Authentication.isProfileExists().then(function(data) {
	    $scope.profile = data; 
	  
	 }, function () {
		
  });

  
}]);