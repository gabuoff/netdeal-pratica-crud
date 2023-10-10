var app = angular.module('ColaboradorApp', ['ngRoute']);

app.config(['$routeProvider', function($routeProvider) {
    $routeProvider
        .when('/colaborador', {
            templateUrl: '/views/colaborador.html',
            controller: 'ColaboradorController'
        })
        .when('/hierarquia', {
            templateUrl: '/views/hierarquia.html',
            controller: 'HierarquiaController'
        })
        .otherwise({
            redirectTo: '/'
        });
}]);