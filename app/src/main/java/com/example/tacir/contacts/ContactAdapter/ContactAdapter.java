package com.example.tacir.contacts.ContactAdapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.tacir.contacts.Contact_menu;
import com.example.tacir.contacts.Model.Contact;
import com.example.tacir.contacts.MainActivity;
import com.example.tacir.contacts.R;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class ContactAdapter extends RecyclerView.Adapter<ContactAdapter.ContactView> {

    private ArrayList<Contact> contactArraylist;
    private Context context;


    public ContactAdapter(ArrayList<Contact> contactArraylist, Context context){
        this.contactArraylist=contactArraylist;
        this.context=context;

    }



    @NonNull
    @Override
    public ContactAdapter.ContactView onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater=LayoutInflater.from(context);
        View view=inflater.inflate(R.layout.item_contact, viewGroup, false);
        return new ContactView(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ContactView contactView, int i) {
    final Contact contact=contactArraylist.get(i);
    contactView.nametextView.setText(contact.getName());
    contactView.surnametextView.setText(contact.getSurname());
    Picasso.get().load(contact.getImage()).into(contactView.circleImageView);
    contactView.itemView.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               Intent intent=new Intent(context, Contact_menu.class);
               intent.putExtra("Name", contact.getName());
               intent.putExtra("Surname", contact.getSurname());
               context.startActivity(intent);
           }
       });

    }

    @Override
    public int getItemCount() {
        return contactArraylist== null ? 0: contactArraylist.size();}

    public class ContactView extends RecyclerView.ViewHolder{
       private CircleImageView circleImageView;
        private TextView nametextView;
        private TextView surnametextView;


        public ContactView(@NonNull View itemView) {
            super(itemView);
            circleImageView=itemView.findViewById(R.id.image_1);
            nametextView=itemView.findViewById(R.id.text_name);
            surnametextView=itemView.findViewById(R.id.text_surname);


        }
    }
}
