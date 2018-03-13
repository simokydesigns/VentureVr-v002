home.directive('fileModel', ['$parse', function ($parse) {
    return {
       restrict: 'A',
       link: function(scope, element, attrs) {
          var model = $parse(attrs.fileModel);
          var modelSetter = model.assign;
          
          element.bind('change', function(){
             scope.$apply(function(){
                modelSetter(scope, element[0].files[0]);
             });
          });
       }
    };
 }]);

home.controller('ProfileController', ['$scope','AUTH_EVENTS', 'UploadService', 'Authentication',
	function($scope, AUTH_EVENTS, UploadService, Authentication) {
	
  $scope.message = "Success!!!";
  
  $scope.isEditable = {
		    isDisabled: true
  };
  

  Authentication.isProfileExists().then(function(data) {
	    $scope.profile = data;  
	 }, function (error) {
		 console.log(error);
  });
  
  
  $scope.editProfile = function() {
      Authentication.editProfile($scope.profile).then(function(data) {
     	  $scope.message = AUTH_EVENTS.registerSuccess;
          $scope.state = "success";
      }, function () {
	         $scope.message = AUTH_EVENTS.registerFailed;
	         $scope.state = "error";
      });
  }; //register
 

	 $scope.upLoadVideo = function() { 
		 
	    var file = $scope.uploadedVideo;
        
        console.log('file is ' );
        console.dir(file);
	 
	    UploadService.uploadVideo(file);
		 
	 };
 
  
}]);