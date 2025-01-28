package com.example.contactsapp;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

public class ContactViewHolder extends RecyclerView.ViewHolder {

    public ImageView avatar;
    public TextView tv_name;
    public TextView tv_email;
    public CardView card;

    public ContactViewHolder(@NonNull View itemView) {
        super(itemView);
        this.avatar = itemView.findViewById(R.id.avatar);
        this.tv_email = itemView.findViewById(R.id.tv_email);
        this.tv_name = itemView.findViewById(R.id.tv_name);
        this.card = itemView.findViewById(R.id.card);
    }
}
