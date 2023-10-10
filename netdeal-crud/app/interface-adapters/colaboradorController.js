app.controller('ColaboradorController', function($scope, ColaboradorService, HierarquiaService, $timeout) {
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

                // Sucesso ao salvar:
                $('#successModal').modal('show');
                $timeout(function() {
                    $('#successModal').modal('hide');
                }, 1500);

            }).catch(function(error) {
                // Em caso de erro ao listar os colaboradores após salvar:
                $('#errorModal').modal('show');
                $timeout(function() {
                    $('#errorModal').modal('hide');
                }, 1500);  
            });

        }).catch(function(error) {
            // Erro ao salvar o colaborador:
            $('#errorModal').modal('show');
            $timeout(function() {
                $('#errorModal').modal('hide');
            }, 1500);
        });
    };
});
