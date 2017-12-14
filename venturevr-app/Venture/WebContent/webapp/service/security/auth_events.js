home.constant('AUTH_EVENTS', {
	  loginSuccess: 'auth-login-success',
	  loginFailed: 'auth-login-failed',
	  logoutSuccess: 'auth-logout-success',
	  sessionTimeout: 'auth-session-timeout',
	  notAuthenticated: 'auth-not-authenticated',
	  authorized: 'auth-token-authorized',
	  notAuthorized: 'auth-not-authorized',
	  registerFailed: "The user name already exists!",
	  registerSuccess: "You have registered successfully! Please login to create profile."
 });

home.constant('USER_ROLES', {
	  all: '*',
	  admin: 'admin',
	  editor: 'editor',
	  guest: 'guest'
});

