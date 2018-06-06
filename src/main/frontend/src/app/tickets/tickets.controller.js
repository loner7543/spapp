(function () {
  angular
    .module('frontend')
    .controller('TicketsController', TicketsController)

  /** @ngInject */
  function TicketsController($scope, $http, $state, $location) {
    var vm = this;

    $scope.showBuyerDialog = function() {
      console.log($location);
      $http({
        method: "GET",
        url: "http://localhost:8080/ftest",
        params: {}
      }).then(function (resp) {
          console.log("Покупатель добавлен");
          console.log("Success resp", resp);
        },
        function (result) {
          console.log("Покупатель не добавлен");
          console.error(result, result.data);
        });
    };
  }

})();
// gttp data - тело запроса bodyParam
