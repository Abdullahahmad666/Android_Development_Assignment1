package com.example.assignment1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class ReviewInformation extends AppCompatActivity {
    FloatingActionButton fabadd;
    TextView contact_value, address_value, country_value, name_value,name_details,contact_details,address_details,country_details;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_review_information);

        // Handle window insets for edge-to-edge layout
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        init();

        // Retrieve data from Intent
        String fullname = getIntent().getStringExtra("name");
        String country = getIntent().getStringExtra("country");
        String contact = getIntent().getStringExtra("contact");
        String address = getIntent().getStringExtra("address");

        String rfullname = getIntent().getStringExtra("rname");
        String rcountry = getIntent().getStringExtra("rcountry");
        String rcontact = getIntent().getStringExtra("rcontact");
        String raddress = getIntent().getStringExtra("raddress");

        // Set data to TextViews
        name_value.setText(fullname != null ? fullname : "Not Provided");
        country_value.setText(country != null ? country : "Not Provided");
        contact_value.setText(contact != null ? contact : "Not Provided");
        address_value.setText(address != null ? address : "Not Provided");

        name_details.setText(rfullname != null ? rfullname : "Not Provided");
        country_details.setText(rcountry != null ? rcountry : "Not Provided");
        contact_details.setText(rcontact != null ? rcontact : "Not Provided");
        address_details.setText(raddress != null ? raddress : "Not Provided");


        fabadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(ReviewInformation.this,SenderDetails.class);
                startActivity(i);
                finish();
            }
        });
    }

    private void init() {
        fabadd = findViewById(R.id.fabadd);
        contact_value = findViewById(R.id.contact_value);
        name_value = findViewById(R.id.name_value);
        country_value = findViewById(R.id.country_value);
        address_value = findViewById(R.id.address_value);
        address_details = findViewById(R.id.address_details);
        name_details = findViewById(R.id.name_details);
        country_details = findViewById(R.id.country_details);
        contact_details = findViewById(R.id.contact_details);
    }
}
