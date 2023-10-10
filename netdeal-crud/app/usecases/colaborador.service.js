app.factory('ColaboradorService', function(ColaboradorHttpService) {
    return {
        findAll: function() {
            return ColaboradorHttpService.findAll()
                .then(function(response) {
                    return response.data.map(function(item) {
                        return new Colaborador(item);
                    });
                });
        },
        save: function(colaborador) {
            return ColaboradorHttpService.save(colaborador);
        }
    };
});