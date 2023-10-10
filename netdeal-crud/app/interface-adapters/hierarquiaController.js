app.controller('HierarquiaController', function($scope, HierarquiaService) {
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
        });
    };
});
