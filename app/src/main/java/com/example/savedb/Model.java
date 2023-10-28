package com.example.savedb;

public class Model {

    String dob, email, name, imgUrl;
    Model() {

    }
    public Model (String name, String dob, String email, String imgUrl){
        this.name = name;
        this.dob = dob;
        this.email = email;
        this.imgUrl = imgUrl;
    }
    public String getName() {
        return name;
    }
    public void setName(String name){
        this.name = name;
    }

    public String getDob() {
        return dob;
    }
    public void setDob(String dob){
        this.dob = dob;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email){
        this.email = email;
    }

    public String getImgUrl(){
        return imgUrl;
    }
    public void setImgUrl(String imgUrl){
        this.imgUrl = imgUrl;
    }
}
