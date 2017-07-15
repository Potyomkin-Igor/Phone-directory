var App = angular.module('phoneDirectory')
     .controller('UserController', ['$scope', 'User', '$uibModal', '$location', '$rootScope', function ($scope, User, $uibModal, $location, $rootScope) {
         $scope.getAllUsers = function () {
             var users = User.query({}, function () {
                 $scope.users = users;
                 console.log($scope.users);
             })
        };

        //Redirect to user/edit page. Save user(model) in a rootScope.
        $scope.getEditPage = function (user) {
            $rootScope.userToEditPage = user;
            $scope.openPopup();
        };

        $scope.openPopup = function () {
            $rootScope.editForm = $uibModal.open({
                templateUrl: 'views/main/UserFormEdit.html',
                controller: 'ModelController',
                size: 'md',
                backdrop: 'static'
                }).result
                .then(null, function () {
                });
        };
}]);

App.controller('ModelController', function ($rootScope, $scope, $uibModalInstance, User, $route) {
    $scope.close = function () {
        $uibModalInstance.dismiss();
    };

    $scope.submit = function(form) {
        if (form.$invalid) {
            angular.forEach(form.$error.required, function(item) {
                item.$dirty = true;
            });
            form.$submitted = false;
        } else {
            $scope.update($scope.user).$promise.then(function (success) {
                $scope.close();
                $route.reload();
            }, function (error) {
                $scope.error = error.status + " " + error.statusText;
            });
        }
    };

    $scope.types = ["", "MOBILE", "HOME"];

    $scope.regex = '^((\\+\\d)?[\\d]?)?((\\(?\\d){3}\\)?([\\-]|[\\s]))?[\\d\\-]{7,10}$';

    $scope.userForEdit = function () {
        $scope.user = angular.copy($rootScope.userToEditPage);
    };

    $scope.update = function (user) {
        return $scope.user = User.update({id: user.id}, user, function () {
        })
    };

});