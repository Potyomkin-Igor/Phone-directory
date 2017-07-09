angular.module('phoneDirectory')
    .factory('Type', ['$resource', function ($resource) {
        return $resource('/api/type/:id', {id: '@id'}, {
            update: {
                method: 'PUT'
            },
            delete: {
                method: 'DELETE'
            }
        })
    }]);
