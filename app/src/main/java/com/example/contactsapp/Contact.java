package com.example.contactsapp;

import java.io.Serializable;

public class Contact implements Serializable {

    private int Avatar;
    private String Name;
    private String Email;

    public Contact(int avatar, String name, String email) {
        Avatar = avatar;
        Name = name;
        Email = email;
    }

    public int getAvatar() {
        return Avatar;
    }

    public String getName() {
        return Name;
    }

    public String getEmail() {
        return Email;
    }
}
