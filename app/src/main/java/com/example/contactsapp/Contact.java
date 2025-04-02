package com.example.contactsapp;

import android.net.Uri;

import java.io.Serializable;

public class Contact implements Serializable {

    private String Avatar;
    private String Name;
    private String Email;

    public Contact(Uri avatar, String name, String email) {
        Avatar = String.valueOf(avatar);
        Name = name;
        Email = email;
    }

    public String getAvatar() {
        return Avatar;
    }

    public String getName() {
        return Name;
    }

    public String getEmail() {
        return Email;
    }
}
