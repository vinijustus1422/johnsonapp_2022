package com.triton.johnsonapp.Forms;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import com.triton.johnsonapp.R;

import butterknife.BindView;

public class GeneralActivityForm extends AppCompatActivity {

    Spinner leavecode_drp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_general_form);
        leavecode_drp = findViewById(R.id.leavecode_drp);
        String [] leavecode = {"Select Value"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, leavecode);
        leavecode_drp.setAdapter(adapter);
    }
}