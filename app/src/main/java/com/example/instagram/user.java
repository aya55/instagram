package com.example.instagram;

public class user {

    private String Name;
    private int profile ,post_image;

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public int getProfile() {
        return profile;
    }

    public void setProfile(int profile) {
        this.profile = profile;
    }

    public int getPost_image() {
        return post_image;
    }

    public void setPost_image(int post_image) {
        this.post_image = post_image;
    }

    public boolean isLove() {
        return love;
    }

    public void setLove(boolean love) {
        this.love = love;
    }

    public boolean isRate() {
        return rate;
    }

    public void setRate(boolean rate) {
        this.rate = rate;
    }

    public boolean isShare() {
        return share;
    }

    public void setShare(boolean share) {
        this.share = share;
    }

    boolean love , rate , share;


    public user(String Name , int profile , int post_image , boolean love , boolean rate , boolean share) {
        this.Name = Name;
        this.profile=profile ;
        this.post_image = post_image;
        this.love = love;
        this.rate=rate;
        this.share=share;
    }


}
