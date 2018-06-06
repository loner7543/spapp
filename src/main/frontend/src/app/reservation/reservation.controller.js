(function () {
  angular
    .module('frontend')
    .controller('ReservationController', ReservationController);

  /** @ngInject */
  function ReservationController($scope,$http) {
    var vm  =this;

    $scope.addItem = function() {
      console.log("WORK")
      $http({
        method: "GET",
        url: "http://localhost:8080/ftest",
        params: {}
      }).then(function (resp) {
          console.log("Покупатель добавлен");
        },
        function (result) {
          console.log("Покупатель не добавлен");
        });
    }
  }
})();
