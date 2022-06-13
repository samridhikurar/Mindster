package com.example.meditari.Extras;

import android.widget.ImageView;

public class Users {

    String uid; //user id
    String name;
    String email;
    String imageUri;

    public Users(String uid, String name, String email, String imageUri){
        this.uid=uid;
        this.name=name;
        this.email=email;
        this.imageUri=imageUri;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setImageUri(String imageUri) {
        this.imageUri = imageUri;
    }

    public String getImageUri() {
        return imageUri;
    }
}
