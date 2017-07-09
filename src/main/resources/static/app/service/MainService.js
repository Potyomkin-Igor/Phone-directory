angular.module('phoneDirectory')
    .factory('User', ['$resource', function ($resource) {
        return $resource('/api/user/:id', {id: '@id'}, {
            update: {
                method: 'PUT'
            },
            delete: {
                method: 'DELETE'
            }
        })
    }]);