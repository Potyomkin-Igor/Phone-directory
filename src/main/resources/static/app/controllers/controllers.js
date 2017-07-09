var mainApp = angular.module('phoneDirectory', ['ngRoute', 'ngResource']);

mainApp.config(function ($routeProvider, $httpProvider) {
    $routeProvider
        .when('/',
            {
                controller: 'UserController',
                templateUrl: 'views/main/Main.html'
            })
        .when('/about',
            {
                controller: 'UserController',
                templateUrl: 'views/main/About.html'
            })
        .when('/api/type',
            {
                controller: 'TypeController',
                templateUrl: 'views/main/TypesShow.html'
            })
        .otherwise({redirectTo: '/'});

    $httpProvider.defaults.headers.common["X-Requested-With"] = 'XMLHttpRequest';

});
