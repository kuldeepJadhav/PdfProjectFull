'use strict';


angular.module('proto',['ngRoute'])
.config(function ($routeProvider, $locationProvider) {
    $routeProvider
      .when('/', {templateUrl: 'public/views/landingpage.html'})
      .otherwise({redirectTo: '/'});
    $locationProvider.html5Mode(false);
  });


