package com.example.contactsapp;

import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityOptionsCompat;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class ContactsAdapter extends RecyclerView.Adapter<ContactViewHolder> {

    private List<Contact> contacts;

    public ContactsAdapter() {
        contacts = new ArrayList<>();
        contacts.add(new Contact(R.drawable.avatar1, "Contact 1", "Contact1@gmail.com"));
        contacts.add(new Contact(R.drawable.avatar2, "Contact 2", "Contact2@gmail.com"));
        contacts.add(new Contact(R.drawable.avatar3, "Contact 3", "Contact3@gmail.com"));
        contacts.add(new Contact(R.drawable.avatar4, "Contact 4", "Contact4@gmail.com"));
        contacts.add(new Contact(R.drawable.avatar5, "Contact 5", "Contact5@gmail.com"));
        contacts.add(new Contact(R.drawable.avatar6, "Contact 6", "Contact6@gmail.com"));
        contacts.add(new Contact(R.drawable.avatar7, "Contact 7", "Contact7@gmail.com"));
        contacts.add(new Contact(R.drawable.avatar8, "Contact 8", "Contact8@gmail.com"));
    }

    @NonNull
    @Override
    public ContactViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.contact,parent,false);
        ContactViewHolder viewHolder = new ContactViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ContactViewHolder holder, int position) {
        Contact contact = contacts.get(position);
        holder.tv_name.setText(contact.getName());
        holder.tv_email.setText(contact.getEmail());
        holder.avatar.setImageResource(contact.getAvatar());
        holder.card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), ContactActivity.class);
                intent.putExtra("contact",contact);
                ActivityOptionsCompat options = ActivityOptionsCompat.makeSceneTransitionAnimation(
                        (Activity) v.getContext(),
                        holder.card,
                        "cardtransition"
                );
                v.getContext().startActivity(intent,options.toBundle());
            }
        });
    }

    @Override
    public int getItemCount() {
        return contacts.size();
    }

    public void addContact(Contact contact) {
        contacts.add(contact);
        notifyDataSetChanged();
    }

    public void deleteContact(int pos) {
        contacts.remove(pos);
        notifyDataSetChanged();
    }
}
