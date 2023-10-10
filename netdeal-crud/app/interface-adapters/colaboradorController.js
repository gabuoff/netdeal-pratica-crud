app.controller('ColaboradorController', function($scope, ColaboradorService, HierarquiaService) {
    $scope.colaboradores = [];
    $scope.hierarquias = [];
    $scope.colaborador = {};

    HierarquiaService.findAll().then(function(data) {
        $scope.hierarquias = data;
    });

    ColaboradorService.findAll().then(function(data) {
        $scope.colaboradores = data;
    });

    $scope.saveColaborador = function() {
        ColaboradorService.save($scope.colaborador).then(function() {
            $scope.colaborador = {};
            ColaboradorService.findAll().then(function(data) {
                $scope.colaboradores = data;
            }).catch(function(error) {
               // Em caso de erro:
            $('#errorModal').modal('show');  // Exibe o modal

            // Oculta o modal após 1,5 segundos
            $timeout(function() {
                $('#errorModal').modal('hide');
            }, 1500);  
            });
        });
    };
});

