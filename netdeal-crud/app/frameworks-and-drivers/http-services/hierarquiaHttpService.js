app.service('HierarquiaHttpService', function($http) {
    const baseUrl = '/api/hierarquia';

    this.findAll = function() {
        return $http.get(`${baseUrl}/findAll`);
    };

    this.save = function(hierarquia) {
        return $http.post(baseUrl, hierarquia);
    };
});
