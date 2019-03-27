import Vue from 'vue'
import Router from 'vue-router'
import Home from './views/Home.vue'
import singleView from './views/singleView'
import Itenerary from './views/Itenerary'
import TripHistory from './views/TripHistory'
import CurrentPastTrips from './views/CurrentPastTrips'
import Search from './views/Search'

Vue.use(Router);

export default new Router({
  mode: 'history',
  routes: [
    {
      path: '/',
      name: 'home',
      component: Home
    },
    {
      path: '/search',
      name: 'search',
      // route level code-splitting
      // this generates a separate chunk (about.[hash].js) for this route
      // which is lazy-loaded when the route is visited.
      component: Search
    },
    {
      path: '/single',
      name: 'single',
      component: singleView,
      props: true
    },
    {
      path: '/itenerary',
      name: 'itenerary',
      component: Itenerary
    },
    {
      path: '/triphistory',
      name: 'triphistory',
      component: TripHistory
    },
    {
      path: '/current',
      name: 'current',
      component: CurrentPastTrips
    }
  ]
})
