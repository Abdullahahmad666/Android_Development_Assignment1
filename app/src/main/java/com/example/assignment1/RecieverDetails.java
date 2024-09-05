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

public class RecieverDetails extends AppCompatActivity {
    Button btnrNext;
    EditText etremail,etrcontact,etrcountry,etrfullname,etraddress;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_reciever_details);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


        init();
        Intent intent = getIntent();
        String senderName = intent.getStringExtra("name");
        String senderAddress = intent.getStringExtra("address");
        String sendercountry = intent.getStringExtra("country");
        String sendercontact = intent.getStringExtra("contact");


        btnrNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = etremail.getText().toString().trim();
                String name = etrfullname.getText().toString().trim();
                String country = etrcountry.getText().toString().trim();
                String contact = etrcontact.getText().toString().trim();
                String address = etraddress.getText().toString().trim();


                if(email.isEmpty() || !email.endsWith("@gmail.com") || name.isEmpty() || contact.isEmpty() || country.isEmpty() || address.isEmpty()) {
                    Toast.makeText(RecieverDetails.this, "Please fill in all fields", Toast.LENGTH_SHORT).show();
                }
                else{

                    Intent i = new Intent(RecieverDetails.this, ReviewInformation.class);
                    i.putExtra("remail",email);
                    i.putExtra("rname",name);
                    i.putExtra("rcountry",country);
                    i.putExtra("rcontact",contact);
                    i.putExtra("raddress",address);
                    i.putExtra("name",senderName);
                    i.putExtra("address",senderAddress);
                    i.putExtra("country",sendercountry);
                    i.putExtra("contact",sendercontact);

                    startActivity(i);

                    finish();



                }


            }
        });
    }


    private void init()
    {
        btnrNext  = findViewById(R.id.btnrNext);
        etraddress = findViewById(R.id.etraddress);
        etremail = findViewById(R.id.etremail);
        etrcountry = findViewById(R.id.etrcountry);
        etrcontact = findViewById(R.id.etrcontact);
        etrfullname = findViewById(R.id.etrfullname);
    }
}