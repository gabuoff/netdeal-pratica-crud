app.factory('HierarquiaService', function(HierarquiaHttpService) {
    return {
        findAll: function() {
            return HierarquiaHttpService.findAll()
                .then(function(response) {
                    return response.data.map(function(item) {
                        return new Hierarquia(item);
                    });
                });
        },
        save: function(hierarquia) {
            return HierarquiaHttpService.save(hierarquia);
        }
    };
});