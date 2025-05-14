package com.example.contactsapp;

import android.net.Uri;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class Contact implements Serializable {

    private String ID;
    private String Avatar;
    private String Name;
    private String Email;

    public Contact(String avatar, String name, String email) {
        Avatar = avatar;
        Name = name;
        Email = email;
        ID = String.valueOf(System.currentTimeMillis());
    }

    public Contact(String avatar, String name, String email, String id) {
        Avatar = avatar;
        Name = name;
        Email = email;
        ID = id;
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

    public String getID() {
        return ID;
    }

    public Map<String,String> getAsMap() {
        Map<String,String> map = new HashMap<>();
        map.put("ID",ID);
        map.put("Avatar",Avatar);
        map.put("Email",Email);
        map.put("Name",Name);

        return map;
    }
}
