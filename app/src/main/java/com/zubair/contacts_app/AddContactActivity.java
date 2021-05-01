package com.zubair.contacts_app;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.io.IOException;
import java.io.OutputStreamWriter;

public class AddContactActivity extends AppCompatActivity {

    ImageButton imageButton;
    Button btn;
    EditText etxtContact;
    EditText etxtEmail;
    EditText etxtAddress;
    EditText etxtDob;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_contact);

        init();

//        btn = findViewById(R.id.button);
        ImageButton imageButton = (ImageButton) findViewById(R.id.imageButton);

//        FloatingActionButton fab = findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                System.out.println("Floating Button Pressed...");
//            }
//        });

//        btn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                System.out.println("------------------------------++++++++++++++++++++++++++++++++++++++++");
//                Toast.makeText(AddContactActivity.this,
//                        "This a toast message",
//                        Toast.LENGTH_LONG)
//                        .show();
//            }
//        });
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("Message","------------------------------++++++++++++++++++++++++++++++++++++++++");
                String data = null;

                data += etxtContact.getText() + ",";
                data += etxtEmail.getText() + ",";
                data += etxtAddress.getText() + ",";
                data += etxtDob.getText().toString();

                writeToFile(data, getApplicationContext());

            }
        });
    }
    private void writeToFile(String data, Context context) {
        try {
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(context.openFileOutput("ContactsData.txt", Context.MODE_PRIVATE));
            outputStreamWriter.write(data);
            outputStreamWriter.close();
        }
        catch (IOException e) {
            Log.e("Exception", "File write failed: " + e.toString());
        }
    }

    private void init() {
        etxtContact = findViewById(R.id.etxtContact);
        etxtEmail = findViewById(R.id.etxtEmail);
        etxtAddress = findViewById(R.id.etxtAddress);
        etxtDob = findViewById(R.id.etxtDoB);
    }
}