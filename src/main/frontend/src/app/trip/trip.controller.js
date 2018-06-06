(function () {

  angular
    .module('frontend')
    .controller('TripController', TripController);

  /** @ngInject */
  function TripController($scope,$state, $http,UtilsFunctionsFactory) {
    var vm = this;

    $scope.addDiscount = function () {
      console.log("fine!")
    }
  }
})();
