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
           freeTickets: function ($http,$location) {
              var url = $location.protocol()+"://"+$location.host()+":"+$location.port()+"/getFreeTickets";
             //var url = $location.protocol() + "://" + $location.host() + ":" + "8080" + "/getFreeTickets";
             console.log(url);
             return $http({
               method: "GET",
               url: url,
               params:{}
             });
           }
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
       resolve: {
         userTickets:function ($http,$location) {
           var ticketsParams = {
             userId: 1,// todo
             ticketId: 0
           };
            var url = $location.protocol()+"://"+$location.host()+":"+$location.port()+"/load";
           //var url = $location.protocol() + "://" + $location.host() + ":" + "8080" + "/load";
           console.log(url);
          return $http({
             method: "GET",
             url: url,
             params: ticketsParams
           });
         }
       }
     });

    $urlRouterProvider.otherwise(function ($injector, $location) {
      console.log($injector, $location);
      return "/";
    });
  }

})();
