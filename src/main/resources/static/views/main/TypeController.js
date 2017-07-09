angular.module('phoneDirectory')
    .controller('TypeController', function ($scope, Type) {
       $scope.allTypes = function () {
           var types = Type.query({}, function () {
             $scope.types = types;
             console.log($scope.types)
           })
        };
    });
