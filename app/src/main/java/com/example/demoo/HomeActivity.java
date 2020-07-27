package com.example.demoo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class HomeActivity extends AppCompatActivity {

    Toolbar toolbar;

    ImageView imageView, backBtn;
    TextView listData, listDesc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        //hooks
        toolbar = findViewById(R.id.toolbar);

        //set the back button
        backBtn = findViewById(R.id.back_btn);
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),MainActivity.class));
            }
        });

        listData = findViewById(R.id.listData);
        listDesc = findViewById(R.id.listDesc);
        imageView = findViewById(R.id.imageView);

        //get the intent values
        Intent intent = getIntent();
        String receiveName = intent.getStringExtra("name");
        String receiveDesc = intent.getStringExtra("description");
        int receiveImage = intent.getIntExtra("image",0);
        listData.setText(receiveName);
        listDesc.setText(receiveDesc);
        imageView.setImageResource(receiveImage);

    }
}
