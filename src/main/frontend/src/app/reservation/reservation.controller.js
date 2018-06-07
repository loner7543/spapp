(function () {
  angular
    .module('frontend')
    .controller('ReservationController', ReservationController);

  /** @ngInject */
  function ReservationController($scope,$http, $location,$state,UtilsFunctionsFactory,freeTickets) {
    console.log(freeTickets);
    $scope.tickets = freeTickets.data;
    var vm  = this;

    $scope.reservationParams={
      ticketId:0,
      userId:1// todo
    };

    $scope.createReservation = function(scope) {
       var url = $location.protocol()+"://"+$location.host()+":"+$location.port()+"/createReservation";
     // var url = $location.protocol() + "://" + $location.host() + ":" + "8080" + "/createReservation";
      console.log(url);
      $scope.reservationParams.ticketId =  scope.ticket.id
      $http({
        method: "POST",
        url: url,
        params: $scope.reservationParams
      }).then(function (resp) {
          UtilsFunctionsFactory.showFlashMessage('success', "Бонь создана");
          $state.reload();
        },
        function (result) {
          UtilsFunctionsFactory.showFlashMessage('danger', "Бронь не создана");
        });
    }
  }
})();
