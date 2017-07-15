var mainApp = angular.module('phoneDirectory', ['ngRoute', 'ngResource', 'ui.bootstrap']);

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
        .when('/user/edit',
            {
                controller: 'UserController',
                templateUrl: 'views/main/UserFormEdit.html'
            })
        .otherwise({redirectTo: '/'});

    $httpProvider.defaults.headers.common["X-Requested-With"] = 'XMLHttpRequest';
});