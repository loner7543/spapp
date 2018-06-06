(function () {
  'use strict';

  angular
    .module('frontend')
    .config(routerConfig);

  /** @ngInject */
  function routerConfig($stateProvider, $urlRouterProvider) {
     $stateProvider
       .state('reservation', {
         url: '/reservation',
         views: {
           'index': {
             templateUrl: 'app/reservation/reservation.html',
             controller: 'ReservationController',
             controllerAs: 'reservationCtrl'
           }
         },
         resolve: {
         }
       })
       .state('trip', {
       url: '/trip',
       views: {
         'index': {
           templateUrl: 'app/trip/trip.html',
           controller: 'TripController',
           controllerAs: 'tripCtrl'
         }
       },
       resolve: {
       }
     })
       .state('tickets', {
       url: '/tickets',
       views: {
         'index': {
           templateUrl: 'app/tickets/tickets.html',
           controller: 'TicketsController',
           controllerAs: 'ticketsCtrl'
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
