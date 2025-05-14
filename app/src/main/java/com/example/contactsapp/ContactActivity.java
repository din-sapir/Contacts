package com.example.contactsapp;

import android.net.Uri;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.bumptech.glide.Glide;

public class ContactActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_contact);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Bundle bundle = getIntent().getExtras();
        Contact contact = (Contact) bundle.getSerializable("contact");

        ImageView iv = findViewById(R.id.avatar);
        TextView tv_name = findViewById(R.id.tv_name);
        TextView tv_email = findViewById(R.id.tv_email);

        //iv.setImageURI(Uri.parse(contact.getAvatar()));
        Glide.with(iv).load(contact.getAvatar()).into(iv);
        tv_name.setText(contact.getName());
        tv_email.setText(contact.getEmail());
    }
}