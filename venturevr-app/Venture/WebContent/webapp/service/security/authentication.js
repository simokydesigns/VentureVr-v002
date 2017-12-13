home.factory('Authentication', ['$rootScope', '$location', '$http', 
	function ($rootScope, $location, $http) {
	
	var authService = {};
	  
	  authService.login = function(user) {
		  
		let data = sessionStorage.getItem('userToken');
		
		return $http({
		       url: "http://localhost:8080/venture-service/api/userlogin/" + user.userName + "?access_token=" + sessionStorage.getItem('userToken'),
		       method: "get",
		       headers: {'Content-Type': 'application/x-www-form-urlencoded'},
		   }).then(function(res) {
			  return res.data;
		   }, function(error) {
		       console.log(error)
		   });

	  }; //login
	  
	  authService.requireAuth = function (user) {
			var auth = "http://venture:secret@localhost:8080/venture-service/oauth/token?grant_type=password&" +
			   "username=" + user.userName + "&password=" + user.password;
			  
		return $http({
		       url: auth,
		       method: "post",
		       headers: {'Content-Type': 'application/x-www-form-urlencoded'},
		       }).then(function (res) {
		        let data = res.data.access_token;
		    	sessionStorage.setItem('userToken', data);
		    	return data;
		       }, function(error) {
			       console.log(error)
			});
	         // authService.login(user);
	   };//requireAuth
	   
	   authService.logout = function () {  
		   return sessionStorage.clear();
	   };
	 
	  authService.isAuthenticated = function () {
		  
		  let isLoggedin = sessionStorage.getItem('userToken');
		
		    	return(isLoggedin)? isLoggedin : null;
		
	  };
	 
	/*  authService.isAuthorized = function (authorizedRoles) {
	    if (!angular.isArray(authorizedRoles)) {
	      authorizedRoles = [authorizedRoles];
	    }
	    return (authService.isAuthenticated() &&
	      authorizedRoles.indexOf(Session.userRole) !== -1);
	  };*/
	 
	  return authService;
	  
}]);
	
	
	

  /*var authService = {};
  
  authService.login = function(user) {
	  
	authService.requireAuth(user);
	  
	let data = sessionStorage.getItem('userToken');
	
	return $http({
	       url: "http://localhost:8080/venture-service/api/userlogin/" + user.userName + "?access_token=" + data,
	       method: "get",
	       headers: {'Content-Type': 'application/x-www-form-urlencoded'},
	   }).then(function(res) {
		  return res.data;
	   }, function(error) {
	       console.log(error)
	   });

  }; //login
  
  authService.requireAuth = function (user) {
		var auth = "http://venture:secret@localhost:8080/venture-service/oauth/token?grant_type=password&" +
		   "username=" + user.userName + "&password=" + user.password;
		  
          $http({
	       url: auth,
	       method: "post",
	       headers: {'Content-Type': 'application/x-www-form-urlencoded'},
	       }).then(function (res) {
	    	let data = res.data.access_token;
	    	sessionStorage.setItem('userToken', data);    
	       }, function(error) {
		       console.log(error)
		});
         // authService.login(user);
   };//requireAuth
   
   authService.logout = function () {  
	   return sessionStorage.clear();
   };
 
  authService.isAuthenticated = function () {
	  
	  let isLoggedin = sessionStorage.getItem('userToken');
	
	    	return(isLoggedin)? isLoggedin : null;
	
  };
 
  authService.isAuthorized = function (authorizedRoles) {
    if (!angular.isArray(authorizedRoles)) {
      authorizedRoles = [authorizedRoles];
    }
    return (authService.isAuthenticated() &&
      authorizedRoles.indexOf(Session.userRole) !== -1);
  };
 
  return authService;
}]);
*/
