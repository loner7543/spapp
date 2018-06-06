(function () {
  angular
    .module('frontend')
    .controller('ItemController', ItemController);

  /** @ngInject */
  function ItemController($scope,$http,UtilsFunctionsFactory,ngDialog,$state) {
    var vm  =this;

    $scope.addItem = function() {
      console.log("WORK")
      $http({
        method: "POST",
        url: "http://localhost:8080/ticket/ftest",
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
