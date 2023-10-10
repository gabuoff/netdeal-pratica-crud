// controller.js
app.controller('ColaboradorController', function($scope, ColaboradorService) {
    $scope.colaboradores = [];
    $scope.colaborador = {};

    ColaboradorService.findAll().then(function(response) {
        $scope.colaboradores = response.data;
    });

    $scope.save = function() {
        ColaboradorService.save($scope.colaborador).then(function() {
            $scope.colaborador = {};
            ColaboradorService.findAll().then(function(response) {
                $scope.colaboradores = response.data;
            });
        });
    };
});

app.controller('HierarquiaController', function($scope, HierarquiaService) {
    $scope.hierarquias = [];
    $scope.hierarquia = {};

    HierarquiaService.findAll().then(function(response) {
        $scope.hierarquias = response.data;
    });

    $scope.save = function() {
        HierarquiaService.save($scope.hierarquia).then(function() {
            $scope.hierarquia = {};
            HierarquiaService.findAll().then(function(response) {
                $scope.hierarquias = response.data;
            });
        });
    };
});
