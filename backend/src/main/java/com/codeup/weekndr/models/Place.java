package com.codeup.weekndr.models;

import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name = "places")
public class Place {

    @Id
    @GeneratedValue
    private long id;
    @Column(nullable = false)
    private String yelp_uniq;
    private String name;
    private String address;
    private Boolean suggested;
    @Column
    private String imgURL;
    private String websiteURL;
    private String hotelURL;
    private String phone_number;
    private String rating;
    private String price;
    private Date checkin_date;
    private Date checkout_date;
    private Date event_date;
    @Column(nullable = false)
    private LocalDateTime created_at;
    @OneToOne
    @JoinColumn(name = "user_id")
    private User user_id;
    @OneToOne
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    @JoinColumn(name = "trip_id")
    private Trip trip_id;

    public Place(){}

    public Place(String yelp_uniq, String name, String address, Boolean suggested, String imgURL, String websiteURL, String hotelURL, String phone_number, String rating, String price, Date checkin_date, Date checkout_date, LocalDateTime created_at, User user_id, Trip trip_id) {
        this.yelp_uniq = yelp_uniq;
        this.name = name;
        this.address = address;
        this.suggested = suggested;
        this.imgURL = imgURL;
        this.websiteURL = websiteURL;
        this.hotelURL = hotelURL;
        this.phone_number = phone_number;
        this.rating = rating;
        this.price = price;
        this.checkin_date = checkin_date;
        this.checkout_date = checkout_date;
        this.created_at = created_at;
        this.user_id = user_id;
        this.trip_id = trip_id;
    }

    public Place(String yelp_uniq, String name, String address, Boolean suggested, String imgURL, String websiteURL, String phone_number, String rating, String price, Date event_date, LocalDateTime created_at, User user_id, Trip trip_id) {
        this.yelp_uniq = yelp_uniq;
        this.name = name;
        this.address = address;
        this.suggested = suggested;
        this.imgURL = imgURL;
        this.websiteURL = websiteURL;
        this.phone_number = phone_number;
        this.rating = rating;
        this.price = price;
        this.event_date = event_date;
        this.created_at = created_at;
        this.user_id = user_id;
        this.trip_id = trip_id;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getYelp_uniq() {
        return yelp_uniq;
    }

    public void setYelp_uniq(String yelp_uniq) {
        this.yelp_uniq = yelp_uniq;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Boolean getSuggested() {
        return suggested;
    }

    public void setSuggested(Boolean suggested) {
        this.suggested = suggested;
    }

    public String getImgURL() {
        return imgURL;
    }

    public void setImgURL(String imgURL) {
        this.imgURL = imgURL;
    }

    public String getWebsiteURL() {
        return websiteURL;
    }

    public void setWebsiteURL(String websiteURL) {
        this.websiteURL = websiteURL;
    }

    public String getHotelURL() {
        return hotelURL;
    }

    public void setHotelURL(String hotelURL) {
        this.hotelURL = hotelURL;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public Date getCheckin_date() {
        return checkin_date;
    }

    public void setCheckin_date(Date checkin_date) {
        this.checkin_date = checkin_date;
    }

    public Date getCheckout_date() {
        return checkout_date;
    }

    public void setCheckout_date(Date checkout_date) {
        this.checkout_date = checkout_date;
    }

    public Date getEvent_date() {
        return event_date;
    }

    public void setEvent_date(Date event_date) {
        this.event_date = event_date;
    }

    public LocalDateTime getCreated_at() {
        return created_at;
    }

    public void setCreated_at(LocalDateTime created_at) {
        this.created_at = created_at;
    }

    public User getUser_id() {
        return user_id;
    }

    public void setUser_id(User user_id) {
        this.user_id = user_id;
    }

    public Trip getTrip_id() {
        return trip_id;
    }

    public void setTrip_id(Trip trip_id) {
        this.trip_id = trip_id;
    }
}
