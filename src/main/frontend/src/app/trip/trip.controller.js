(function () {

  angular
    .module('frontend')
    .controller('TripController', TripController);

  /** @ngInject */
  function TripController($scope,$state, $http,UtilsFunctionsFactory,$location) {
    var vm = this;

    $scope.tripParams = {
      searchString:""
    };

    $scope.searchTrip = function () {
      // var url = $location.protocol()+"://"+$location.host()+":"+$location.port()+"/search";
       var url = $location.protocol()+"://"+$location.host()+":"+"8080"+"/search";
      $http({
        method: "GET",
        url: url,
        params:$scope.tripParams
      }).then(function (resp) {
          UtilsFunctionsFactory.showFlashMessage('success', "Рейсы найдены");
          console.log(resp);
          $scope.trips = resp.data;
          $scope.tripParams.searchString = "";
        },
        function (result) {
          UtilsFunctionsFactory.showFlashMessage('danger', "Ошибка при поиске рейса");
          console.error(result, result.data);
          $scope.tripParams.searchString = "";
        });
    }
  }
})();
