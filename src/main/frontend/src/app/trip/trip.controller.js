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
      var url = $location.protocol()+"://"+$location.host()+":"+$location.port()+"/search";
      // var url = $location.protocol()+"://"+$location.host()+":"+"8080"+"/search";
       console.log(url);
      $http({
        method: "GET",
        url: url,
        params:$scope.tripParams
      }).then(function (resp) {
          console.log(resp);
          if (resp.data.length===0){
            UtilsFunctionsFactory.showFlashMessage('danger', "По вашему запросу ничего не найдено");
          }
          else {
            UtilsFunctionsFactory.showFlashMessage('success', "Рейсы найдены");
          }
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
