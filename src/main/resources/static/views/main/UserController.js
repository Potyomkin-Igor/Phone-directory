angular.module('phoneDirectory')
    .controller('UserController', function ($scope, User, $location, $rootScope) {
        $scope.getAllUsers = function () {
            var users = User.query({}, function () {
                $scope.users = users;
                console.log($scope.users);
            })
        };

        $scope.types = ["", "MOBILE", "HOME"];

        $scope.regex = '^((\\+\\d)?[\\d]?)?((\\(?\\d){3}\\)?([\\-]|[\\s]))?[\\d\\-]{7,10}$';


        $scope.submit = function(form) {
            if (form.$invalid) {
                angular.forEach(form.$error.required, function(item) {
                    item.$dirty = true;
                });
                form.$submitted = false;
            } else {
                $scope.update($scope.user).$promise.then(function (success) {
                    $location.path('/');
                }, function (error) {
                    $scope.error = error.status + " " + error.statusText;
                });
            }
        };

        $scope.update = function (user) {
            return $scope.user = User.update({id: user.id}, user, function () {
                $scope.user = User.get({id: user.id})
            })
        };

        $scope.getEditPage = function (user) {
            $rootScope.userToEditPage = user;
            $location.path('/user/edit');
        };

        $scope.userForEdit = function () {
            $scope.user = angular.copy($rootScope.userToEditPage);
        };

        $scope.update = function (user) {
            return $scope.user = User.update({id: user.id}, user, function () {
            })
        };
});