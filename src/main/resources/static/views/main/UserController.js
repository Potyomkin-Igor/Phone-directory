angular.module('phoneDirectory')
    .controller('UserController', function ($scope, User, $location, $rootScope, $route, $uibModal) {
        $scope.getAllUsers = function () {
            var users = User.query({}, function () {
                $scope.users = users;
                console.log($scope.users);
            })
        };


// /Need to refactor/
    var fieldsAreValid = function () {
        // $scope.validationMessage = '';
        // $scope.pattern = "^((\\+\\d)?[\\d]?)?((\\(?\\d){3}\\)?([\\-]|[\\s]))?[\\d\\-]{7,10}$"
        // if ($scope.user.contact.phoneNumber !== pattern) {
        //     $scope.validationMessage = "Phone number is not valid";
        //     return false;
        // }
        return true;
    };


    $scope.update = function (interest) {
        return $scope.user = User.update({id: user.id}, user, function () {
            $scope.user = User.get({id: user.id})
        })
    };


    $scope.submit = function () {
        if (fieldsAreValid()) {
            $scope.update($scope.user).$promise.then(function (success) {
                $route.reload();
            }, function (error) {
                $scope.error = error.status + " " + error.statusText;
            });
        } else {
            $scope.error = $scope.validationMessage;
        }
    }


    $scope.openUpdateModal = function (user) {
        $scope.userModal = $uibModal.open({
            templateUrl: 'views/main/UpdateUserModal.html',
            controller:  'updateModalController',
            size: 'md',
            resolve: {
                user: $scope.user
            }
        }).result.then(function (user) {
            if (fieldsAreValid()) {
                $scope.update($scope.user).$promise.then(function (success) {
                    $route.reload();
                }, function (error) {
                    $scope.error = error.status + " " + error.statusText;
                });
            } else {
                $scope.error = $scope.validationMessage;
            }
        }, function () {
        });
    };
});


app.controller('updateModalController', function ($scope, $uibModalInstance, user) {
    $scope.user = user;
    // $scope.userEmpty = {};

    $scope.closeUserModal = function () {
        $uibModalInstance.dismiss();
    };

    $scope.updateUser = function () {
        $uibModalInstance.close($scope.user);
    }

});