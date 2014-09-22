'use strict';


var module = angular.module('proto',['ngRoute','ui.bootstrap','ui.bootstrap.tpls'])
.config(function ($routeProvider, $locationProvider,$httpProvider) {
	$httpProvider.interceptors.push('authInterceptor');
    $routeProvider
      .when('/', {templateUrl: 'public/views/landingpage.html'})
      .otherwise({redirectTo: '/'});
    $locationProvider.html5Mode(false);
  });

module.run(function($rootScope) {
    $rootScope.showLoading = false;
});




