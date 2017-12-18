home.factory('Authentication', ['$rootScope', '$location', '$http', 
	function ($rootScope, $location, $http) {
	
	var authService = {};
	  
	  authService.login = function(user) {
		  
		let data = sessionStorage.getItem('userToken');
		
		return $http({
		       url: "http://localhost:8080/venture-service/api/userlogin/" + user.username + "?access_token=" + sessionStorage.getItem('userToken'),
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
			   "username=" + user.username + "&password=" + user.password;
			  
		return $http({
		       url: auth,
		       method: "post",
		       headers: {'Content-Type': 'application/x-www-form-urlencoded'},
		       }).then(function (res) {
		    	console.log(res.data.access_token);
		        let data = res.data.access_token;
		    	sessionStorage.setItem('userToken', data);
		    	return data;
		       }, function(error) {
			       console.log(error)
			});
	   };//requireAuth
	   
	   authService.logout = function () {  
		   sessionStorage.clear(); 
		   $location.path('#/login');
	   };//logout
	 
	  authService.isAuthenticated = function () {
		  
		  let isLoggedin = sessionStorage.getItem('userToken');
		
		    	return(isLoggedin)? isLoggedin : null;
		
	  };//isAuthenticated
	 
	/*  authService.isAuthorized = function (authorizedRoles) {
	    if (!angular.isArray(authorizedRoles)) {
	      authorizedRoles = [authorizedRoles];
	    }
	    return (authService.isAuthenticated() &&
	      authorizedRoles.indexOf(Session.userRole) !== -1);
	  };//isAuthorized */
	  
	  
	  authService.register = function (user) {  
	      var dataUser = {
	              "username": user.username,
	              "password": user.password
	          };
	          
	         return $http.post('http://localhost:8080/venture-service/api/newuser/', JSON.stringify(dataUser)
	        		 
	         ).then(function(res) {
	        	
	         });
	  };//register
	 
	  return authService;
	  
}]);
