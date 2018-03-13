home.service('UploadService', ['$location', '$http', function ($location, $http) {
	
    
    this.uploadVideo = function(file){
        var fd = new FormData();
        fd.append('file', file);
        
        uploadUrl='http://localhost:8080/venture-service/api/uploadvideo';
     
        $http.post(uploadUrl, fd, {
           transformRequest: angular.identity,
           headers: {'Content-Type': undefined}
        })
     
        .success(function(){
        })
     
        .error(function(){
        });
     }
	
}]);

