package com.example.contactsapp;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityOptionsCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

public class ContactsAdapter extends RecyclerView.Adapter<ContactViewHolder> {

    FirebaseFirestore db = FirebaseFirestore.getInstance();
    private List<Contact> contacts;

    public ContactsAdapter() {
        contacts = new ArrayList<>();
        db.collection("Contacts").get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                if (task.isSuccessful()) {
                    contacts.clear();
                    for (QueryDocumentSnapshot document : task.getResult()) {
                        Contact c = new Contact(document.get("Avatar").toString(), document.get("Name").toString(), document.get("Email").toString(), document.get("ID").toString());
                        contacts.add(c);
                    }
                    notifyDataSetChanged();
                }
            }

        });
        db.collection("Contacts").addSnapshotListener(new EventListener<QuerySnapshot>() {
            @Override
            public void onEvent(@Nullable QuerySnapshot value, @Nullable FirebaseFirestoreException error) {
                contacts.clear();
                for (QueryDocumentSnapshot document : value) {
                    Contact c = new Contact(document.get("Avatar").toString(), document.get("Name").toString(), document.get("Email").toString(), document.get("ID").toString());
                    contacts.add(c);
                }
                notifyDataSetChanged();
            }
        });
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
        //holder.avatar.setImageURI(Uri.parse(contact.getAvatar()));
        Glide.with(holder.avatar).load(contact.getAvatar()).into(holder.avatar);
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
        Contact c = contacts.get(pos);
        db.collection("Contacts").document(c.getID()).delete();
    }
}
