(function () {
  'use strict';

  angular
    .module('frontend')
    .config(routerConfig);

  /** @ngInject */
  function routerConfig($stateProvider, $urlRouterProvider) {
     $stateProvider
       .state('broken', {
         url: '/broken',
         views: {
           'index': {
             templateUrl: 'app/item/item.html',
             controller: 'ItemController',
             controllerAs: 'itemCtrl'
           }
         },
         resolve: {
         }
       })
       .state('trip', {
       url: '/trip',
       views: {
         'index': {
           templateUrl: 'app/buyer/buyer.html',
           controller: 'BuyerController',
           controllerAs: 'buyerCtrl'
         }
       },
       resolve: {
       }
     })
       .state('tickets', {
       url: '/tickets',
       views: {
         'index': {
           templateUrl: 'app/discount/discount.html',
           controller: 'DiscountController',
           controllerAs: 'discountCtrl'
         }
       },
       resolve: {}
     })

    $urlRouterProvider.otherwise(function ($injector, $location) {
      console.log($injector, $location);
      return "/";
    });
  }

})();
