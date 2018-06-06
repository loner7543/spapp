(function () {
  angular
    .module('frontend')
    .controller('ReservationController', ReservationController);

  /** @ngInject */
  function ReservationController($scope,$http, $location,UtilsFunctionsFactory,freeTickets) {
    console.log(freeTickets);
    var vm  = this;

    $scope.createReservation = function() {
      // var url = $location.protocol()+"://"+$location.host()+":"+$location.port()+"/search";
      var url = $location.protocol() + "://" + $location.host() + ":" + "8080" + "/createReservation";
      $http({
        method: "GET",
        url: url,
        params: {}
      }).then(function (resp) {
          UtilsFunctionsFactory.showFlashMessage('success', "Бонь создана");
        },
        function (result) {
          UtilsFunctionsFactory.showFlashMessage('danger', "Бронь не создана");
        });
    }
  }
})();
