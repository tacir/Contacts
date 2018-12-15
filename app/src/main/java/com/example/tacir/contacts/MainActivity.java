package com.example.tacir.contacts;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.tacir.contacts.ContactAdapter.ContactAdapter;
import com.example.tacir.contacts.Model.Contact;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ArrayList<Contact> people = new ArrayList<>();
        people.add(new Contact("Nurlan", "Quliyev", "https://image.shutterstock.com/image-photo/casually-handsome-confident-young-man-260nw-439433326.jpg"));
        people.add(new Contact("Ramil", "Ejderli", "https://steamuserimages-a.akamaihd.net/ugc/939447311817916820/4D8E414835EAB967999F0B2FFA6B3AB76B061CF2/"));
        people.add(new Contact("Aslan", "Abdullayev", "http://purepng.com/public/uploads/large/purepng.com-manmanadult-malemale-childboy-beingmens-1421526920869cscbo.png"));
        people.add(new Contact("Sirac", "Suleymanov","https://studioredondo.nl/wp-content/uploads/2018/04/man-1.jpg"));
        people.add(new Contact("Fazil", "Quliyev", "https://studioredondo.nl/wp-content/uploads/2018/04/man-1.jpg"));
        people.add(new Contact("Ilahe", "Mamedova", "http://socialtextjournal.com/wp-content/uploads/2016/04/Alasan-Wanita-Ingin-Menjadi-Pemain-film-Porno.jpg"));



        ContactAdapter adapter = new ContactAdapter(people, this);
        recyclerView = findViewById(R.id.recycler_1);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

    }

}
