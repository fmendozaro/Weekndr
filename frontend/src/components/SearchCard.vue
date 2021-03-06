<template xmlns:v-slot="http://www.w3.org/1999/XSL/Transform">
    <span>
    <LoadingScreen v-if="isLoading"/>
    <v-container fill-height fluid>
        <v-layout justify-center>
            <v-card height="400px" xs12 light>
                <v-container fill-height>
                    <v-layout align-center justify-center>
                        <v-form ref="form" v-model="valid" lazy-validation>
                        <v-card-text>
                            <v-flex offset-xs1 class="mt-2">
                            <h1>Start Planning Your Trip</h1>
                            </v-flex>
                            <v-flex xs10 offset-xs1>
                                <v-divider></v-divider>
                                <h4 class="font-weight-bold mt-3 mb-4">Where</h4>
                                <v-text-field v-model="Where" placeholder="Where" required solo :rules="whereRules"></v-text-field>
                            </v-flex>
                            <v-flex xs5 offset-xs1 class="d-inline-block">
                                <v-menu v-model="menu1" :close-on-content-click="false" :nudge-right="40"
                                        lazy transition="scale-transition" offset-y full-width min-width="290px">
                                    <template v-slot:activator="{ on }">
                                        <p class="font-weight-bold">Start Date</p>
                                        <v-text-field v-model="Dates.Start" label="yyyy/mm/dd" readonly v-on="on" solo required :rules="startRules"></v-text-field>
                                    </template>
                                    <v-date-picker :min="minDate" v-model="Dates.Start" @input="menu1 = false"></v-date-picker>
                                </v-menu>
                            </v-flex>
                            <v-flex xs5 class="d-inline-block">
                                <v-menu v-model="menu2" :close-on-content-click="false" :nudge-right="40"
                                        lazy transition="scale-transition" offset-y full-width min-width="290px">
                                    <template v-slot:activator="{ on }">
                                        <p class="font-weight-bold">End Date</p>
                                        <v-text-field v-model="Dates.End" label="yyyy/mm/dd" readonly v-on="on" solo required :rules="endRules"></v-text-field>
                                    </template>
                                    <v-date-picker :min="Dates.Start" v-model="Dates.End" @input="menu2 = false"></v-date-picker>
                                </v-menu>
                            </v-flex>
                            <v-flex offset-xs8>
                                <v-btn @click="searchLocation()" class="white--text" color="#E96445">Search</v-btn>
                            </v-flex>
                        </v-card-text>
                        </v-form>
                    </v-layout>
                </v-container>
            </v-card>
        </v-layout>
</v-container>
        </span>
</template>

<script>
    import store from '../store'
    import router from '../router'
    import axios from 'axios'
    import LoadingScreen from "./LoadingScreen";


    let today= new Date();
    let dd = today.getDate();
    let mm = today.getMonth() + 1; //January is 0!
    let yyyy = today.getFullYear();

    if (dd < 10) {
        dd = '0' + dd;
    }
    if (mm < 10) {
        mm = '0' + mm;
    }
    today = yyyy + '-' + mm + '-' + dd;

    export default {
        name: "SearchCard",
        components: {LoadingScreen},
        data(){
            return{
                Where: '',
                Dates:{
                    Start: '',
                    End: ''
                },
                minDate: today,
                minEndDate: '',
                menu1: false,
                menu2: false,
                fadeout: 'fade-out',
                valid: true,
                isLoading: false,
                whereRules: [
                    v => !!v || 'Location is required'
                ],
                startRules: [
                    v => !!v || 'Start Date is required',
                ],
                endRules: [
                    v => !!v || 'End Date is required',
                ]
            }
        },
        computed:{

        },
        methods: {

            //validates user input
            validate () {
                this.valid = !!this.$refs.form.validate();
            },

            //checks whether axios requests are running
            doneLoading(){
                this.isLoading = false
            },

            //searches location that the user has typed, then routes to search view
            async searchLocation(){
                this.validate();
                if (this.valid) {
                    store.commit('changeLocation', this.Where);
                    store.commit('changeStartDate', this.Dates.Start);
                    store.commit('changeEndDate', this.Dates.End);
                    store.commit('changeMinDate', this.minDate);
                    this.isLoading = true;
                    await axios.all([
                        axios.get('/yelpList/' + store.state.location + "/4"),
                        axios.get('/yelpList/' + store.state.location + "/1"),
                        axios.get('/yelpList/' + store.state.location + "/2"),
                        axios.get('/yelpList/' + store.state.location + "/3"),
                        axios.get("https://maps.googleapis.com/maps/api/geocode/json?address="+ store.state.location +"&key=" + "AIzaSyAih6iqhzWmzLIe11sF9yMDuwPhVyFYP2w")
                    ]).then(axios.spread((suggestedRes, experiencesRes, foodRes, hotelRes, weatherRes) => {
                        store.commit('changeSuggestedResults', suggestedRes.data.businesses);
                        store.commit('changeExperiencesResults', experiencesRes.data.businesses);
                        store.commit('changeFoodResults', foodRes.data.businesses);
                        store.commit('changeHotelResults', hotelRes.data.businesses);
                        store.commit('changeWeatherResults', weatherRes.data.results[0]);
                        this.doneLoading();
                        console.log(suggestedRes, experiencesRes, foodRes, hotelRes, weatherRes);
                    }));
                    store.commit('changeMainUser', true);
                    router.push('/search');
                }
            },
        },
    }
</script>

<style scoped>
    v-btn:hover {
        color: #E96445;
    }
</style>