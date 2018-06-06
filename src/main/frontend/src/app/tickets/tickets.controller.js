(function () {
  angular
    .module('frontend')
    .controller('TicketsController', TicketsController);

  /** @ngInject */
  function TicketsController($scope, $http, $state, $location, UtilsFunctionsFactory) {
    var vm = this;

    $scope.ticketsParams = {
      userId: 1// todo брать идентификатов или др инфо о пользовател из SpringSecurity
    };

    $scope.showUserTickets = function () {
      // var url = $location.protocol()+"://"+$location.host()+":"+$location.port()+"/search";
      var url = $location.protocol() + "://" + $location.host() + ":" + "8080" + "/load";
      $http({
        method: "GET",
        url: url,
        params: $scope.ticketsParams
      }).then(function (resp) {
          UtilsFunctionsFactory.showFlashMessage('success', "Билеты загружены");
          $scope.tickets = resp.data;
          console.log("Success resp", resp);
        },
        function (result) {
          UtilsFunctionsFactory.showFlashMessage('danger', "Ошибка при загрузке билетов");
          console.error(result, result.data);
        });
    };

    $scope.cancelReservation = function () {

    };
  }

})();
