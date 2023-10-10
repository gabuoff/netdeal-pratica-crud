app.service('ColaboradorHttpService', function($http) {
    const baseUrl = 'http://localhost:8080/api/colaborador';

    this.findAll = function() {
        return $http.get(`${baseUrl}/findAll`);
    };

    this.save = function(colaborador) {
        return $http.post(baseUrl, colaborador);
    };
});