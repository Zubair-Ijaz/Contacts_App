package com.zubair.contacts_app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class MainActivity extends AppCompatActivity {


    private ArrayList<String> cName = new ArrayList<>();
    private ArrayList<String> cImageUrls = new ArrayList<>();
    private ArrayList<String> btnVoice = new ArrayList<>();
    private ArrayList<String> btnVideo = new ArrayList<>();

    CircleImageView imgBtnAddContact;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
        initImageBitmaps();

        imgBtnAddContact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Contact_Adapter.ContactViewHolder.setVisibility(1);
//                adapter.notifyItemChanged(0);

                Intent intent = new Intent(MainActivity.this, com.zubair.contacts_app.AddContactActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }

    private void init() {
        imgBtnAddContact = findViewById(R.id.imgBtnAddContact);
    }



    private void initImageBitmaps(){
        cImageUrls.add("https://www.shaadidukaan.com/vogue/wp-content/uploads/2019/08/hug-kiss-images.jpg");
        cName.add("Pakistan");
        cImageUrls.add("https://www.shaadidukaan.com/editor-img/image/others/kisses-hug-pics/Forehead-Kiss1.jpg");
        cName.add("USA");
        cImageUrls.add("C:\\Users\\Muhammad Zubair\\Contacts_App\\app\\src\\main\\res\\drawable-v24\\usa.png");
        cName.add("UK");

        initRecyclerView();
        btnRecyclerView();
    }

    private void initRecyclerView(){
        RecyclerView contactList  = findViewById(R.id.horizontal_contactList);
        adapter = new Contact_Adapter( this, cName, cImageUrls);
        contactList.setAdapter(adapter);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(linearLayoutManager.HORIZONTAL);
        contactList.setLayoutManager(linearLayoutManager);

    }
    private void btnRecyclerView(){
        RecyclerView allContact  = findViewById(R.id.all_contact);
        contact_detail_adapter adapter = new contact_detail_adapter(this, cName, cImageUrls, btnVoice, btnVideo);
        allContact.setAdapter(adapter);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(linearLayoutManager.VERTICAL);
        allContact.setLayoutManager(linearLayoutManager);
    }
    private Contact_Adapter adapter;
}
