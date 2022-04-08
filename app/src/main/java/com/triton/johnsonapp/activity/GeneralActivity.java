package com.triton.johnsonapp.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.triton.johnsonapp.Forms.GeneralActivityForm;
import com.triton.johnsonapp.Forms.SubordActivityForm;
import com.triton.johnsonapp.R;

public class GeneralActivity extends AppCompatActivity {


    CardView cv_root,cv_root1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_general);
        cv_root = (CardView) findViewById(R.id.cv_root);
        cv_root1 = (CardView) findViewById(R.id.cv_root1);
        cv_root.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(GeneralActivity.this, GeneralActivityForm.class);
                startActivity(intent);
            }
        });

        cv_root1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(GeneralActivity.this, SubordActivityForm.class);
                startActivity(intent);
            }
        });

    }
}