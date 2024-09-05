package com.example.assignment1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class SenderDetails extends AppCompatActivity {

    Button btnNext;
    EditText etemail,etcontact,etcountry,etfullname,etaddress;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_sender_details);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        init();



        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = etemail.getText().toString().trim();
                String name = etfullname.getText().toString().trim();
                String country = etcountry.getText().toString().trim();
                String contact = etcontact.getText().toString().trim();
                String address = etaddress.getText().toString().trim();


                if(email.isEmpty() || !email.endsWith("@gmail.com") || name.isEmpty() || contact.isEmpty() || country.isEmpty() || address.isEmpty()) {
                    Toast.makeText(SenderDetails.this, "Please fill in all fields", Toast.LENGTH_SHORT).show();
                }
                else{
                    Intent i = new Intent(SenderDetails.this, RecieverDetails.class);
                    i.putExtra("email",email);
                    i.putExtra("name",name);
                    i.putExtra("country",country);
                    i.putExtra("contact",contact);
                    i.putExtra("address",address);
                    startActivity(i);
                    finish();


                }


            }
        });
    }

    private void init()
    {
        btnNext  = findViewById(R.id.btnNext);
        etaddress = findViewById(R.id.etaddress);
        etemail = findViewById(R.id.etemail);
        etcountry = findViewById(R.id.etcountry);
        etcontact = findViewById(R.id.etcontact);
        etfullname = findViewById(R.id.etfullname);
    }





}