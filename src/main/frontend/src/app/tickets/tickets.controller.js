(function () {
  angular
    .module('frontend')
    .controller('TicketsController', TicketsController);

  /** @ngInject */
  function TicketsController($scope, $http, $state, $location, UtilsFunctionsFactory,userTickets) {
    var vm = this;
    console.log(userTickets);
    $scope.tickets = userTickets.data;

    $scope.ticketsParams = {
      userId: 1,// todo брать идентификатов или др инфо о пользовател из SpringSecurity
      ticketId: 0
    };

    $scope.deleteParams = {
      ticketId:0
    };

    $scope.cancelReservation = function (scope) {
      $scope.deleteParams.ticketId = scope.ticket.id;
       var url = $location.protocol()+"://"+$location.host()+":"+$location.port()+"/cancelReservation";
      //var url = $location.protocol() + "://" + $location.host() + ":" + "8080" + "/cancelReservation";
      console.log(url);
      $http({
        method: "POST",
        url: url,
        params: $scope.deleteParams
      }).then(function (resp) {
          UtilsFunctionsFactory.showFlashMessage('success', "Бронь отменена");
          $state.reload();
          console.log("Success resp", resp);
        },
        function (result) {
          UtilsFunctionsFactory.showFlashMessage('danger', "Произошла ошибка при отмене брони");
          console.error(result, result.data);
        });
    };
  }

})();
