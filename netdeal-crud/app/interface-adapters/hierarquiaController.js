app.controller('HierarquiaController', function($scope, HierarquiaService, $timeout) {
    $scope.hierarquias = [];
    $scope.hierarquia = {};

    HierarquiaService.findAll().then(function(data) {
        $scope.hierarquias = data;
    });

    $scope.saveHierarquia = function() {
        HierarquiaService.save($scope.hierarquia).then(function() {
            $scope.hierarquia = {};
            HierarquiaService.findAll().then(function(data) {
                $scope.hierarquias = data;
            });

            // Mostra o modal de sucesso
            $('#successModal').modal('show');

            // Fecha o modal depois de 2 segundos (2000ms)
            $timeout(function() {
                $('#successModal').modal('hide');
            }, 2000);

        }).catch(function() {
            $('#errorModal').modal('show');
        });
    };
});
