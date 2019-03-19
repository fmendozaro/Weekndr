import Vue from 'vue'
import Vuex from 'vuex'

Vue.use(Vuex)

export default new Vuex.Store({
  state: {
    location: '',
    dates: {start_date: '', end_date: ''},
    suggestedResults: '',
    hotelResults: '',
    foodResults: '',
    experiencesResults: '',
    singleResult: '',
    user: {
        id: '',
        username: '',
        img_path:'',
        email: '',
        phone_number: ''
    },
    currentViewedTrip: '',
    loggedIn: false
  },

  getters:{
      location: state => {
          return state.location
      },
      dates: state => {
          return state.dates
      },
      hotel: state => {
          return state.hotelResults
      },
      food: state => {
          return state.foodResults
      },
      experiences: state => {
          return state.experiencesResults
      },
      suggested: state => {
          return state.suggestedResults
      },
      singleResult: state => {
          return state.singleResult
      },
      user: state => {
          return state.user
      },
      currentlyViewedTrip: state => {
          return state.currentViewedTrip
      },
      loggedIn: state => {
          return state.loggedIn
      }
  },
  mutations: {
      changeLocation(state, location){
          state.location = location;
      },
      changeStartDate(state, start_date){
          state.dates.start_date = start_date;
      },
      changeEndDate(state, end_date){
          state.dates.end_date = end_date;
      },
      changeDates(state, dates){
          state.dates = dates;
      },
      changeHotelResults(state, hotels){
          state.hotelResults = hotels;
      },
      changeFoodResults(state, food){
          state.foodResults = food;
      },
      changeExperiencesResults(state, experiences){
          state.experiencesResults = experiences;
      },
      changeSuggestedResults(state, suggested){
          state.suggestedResults = suggested;
      },
      changeSingleResult(state, singleResult){
          state.singleResult = singleResult;
      },
      changeUser(state, user){
          state.user = user;
      },
      changeCurrentlyViewedTrip(state, trip){
          state.currentViewedTrip = trip;
      },
      changeLoggedIn(state, boolean){
          state.loggedIn = boolean;
      }

  },
  actions: {

  }
})
