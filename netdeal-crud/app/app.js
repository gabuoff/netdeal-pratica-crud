var app = angular.module('ColaboradorApp', ['ngRoute']);

app.config(function($routeProvider) {
    $routeProvider
        .when('/', {
            templateUrl: 'components/colaborador/colaborador-list/colaborador-list.component.html',
            controller: 'ColaboradorListController',
            controllerAs: 'colabListCtrl'
        })
        .when('/colaborador/new', {
            templateUrl: 'components/colaborador/colaborador-form/colaborador-form.component.html',
            controller: 'ColaboradorFormController',
            controllerAs: 'colabFormCtrl'
        })
        .when('/colaborador/:id', {
            templateUrl: 'components/colaborador/colaborador-form/colaborador-form.component.html',
            controller: 'ColaboradorFormController',
            controllerAs: 'colabFormCtrl'
        })
        .when('/hierarchy', {
            templateUrl: 'components/colaborador/colaborador-hierarchy/colaborador-hierarchy.component.html',
            controller: 'ColaboradorHierarchyController',
            controllerAs: 'colabHierarchyCtrl'
        })
        .otherwise({
            redirectTo: '/'
        });
});