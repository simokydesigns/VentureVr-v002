var userControllers = angular.module('usersControllers', ['ngAnimate']);

userControllers.controller('EstController', ['$scope', '$http', function($scope, $http) {
  $http.get('http://user:123@localhost:8080/venture-service/api/est').success(function(est_data) {
    $scope.est = est_data;
    $scope.estOrder = 'estName';
    $scope.locationFilter = est_data.location;
  });
}]);


userControllers.controller('VideoController', ['$scope', '$http','$routeParams', function($scope, $http, $routeParams) {
  $http.get('http://user:123@localhost:8080/venture-service/api/videos/' + $routeParams.estId).success(function(video_data) {
    $scope.videos = video_data;
  });
}]);


userControllers.controller('DetailsController', ['$scope', '$http','$routeParams', function($scope, $http, $routeParams) {
    $http.get('http://user:123@localhost:8080/venture-service/api/est/'+ $routeParams.itemId).success(function(details_data) {
    $scope.details = details_data;  
  });
}]);




