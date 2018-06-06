(function () {
  'use strict';

  angular
    .module('frontend', ['ngAnimate', 'ngCookies', 'ngTouch', 'ngSanitize',
      'ngMessages', 'ngAria', 'ui.router','ui.bootstrap', 'toastr', 'ngMask','ngFlash'])
  .factory("UtilsFunctionsFactory",UtilsFunctionsFactory);

  /** @ngInject */
  function UtilsFunctionsFactory(Flash) {
    return{
      toDate:function (value) {
        moment.locale('ru');
        return moment(value).format('L')
      },

      dateStringToMillis:function(date){
          var time = new Date(date).getTime();
          return isNaN(time) ? null : time;
      },
      showFlashMessage: function (mesType, text) {
        return Flash.create(mesType, text, 30000, {}, true);
      }
  }


}})();

