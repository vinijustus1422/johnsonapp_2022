
package com.triton.johnsonapp.Forms;

import androidx.appcompat.app.AppCompatActivity;

import android.nfc.Tag;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import com.triton.johnsonapp.R;

import java.text.SimpleDateFormat;
import java.util.Date;

public class SubordActivityForm extends AppCompatActivity {

    Spinner AN,FN,spr_dropdownperoff,spr_dropdownpeHRS,AN1,FN1,spr_dropdownperoff1,spr_dropdownpeHRS1,AN2,FN2,spr_dropdownperoff2,spr_dropdownpeHRS2;
    TextView crnt_date;
    String Tag = "SuboardActivityForm";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subord_form);
        AN = (Spinner) findViewById(R.id.spr_dropdownAN);
        AN1 = (Spinner) findViewById(R.id.spr_dropdownAN1);
        AN2 = (Spinner) findViewById(R.id.spr_dropdownAN2);
        String [] Afternoon = {"Select Value","PP","LL"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, Afternoon);
        AN.setAdapter(adapter);
        AN1.setAdapter(adapter);
        AN2.setAdapter(adapter);
        FN = (Spinner) findViewById(R.id.spr_dropdownFN);
        FN1 = (Spinner) findViewById(R.id.spr_dropdownFN1);
        FN2 = (Spinner) findViewById(R.id.spr_dropdownFN2);
        String [] forenoon = {"Select Value","PP","LL"};
        ArrayAdapter<String> adapterfore = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, Afternoon);
        FN.setAdapter(adapterfore);
        FN1.setAdapter(adapterfore);
        FN2.setAdapter(adapterfore);
        spr_dropdownperoff = (Spinner) findViewById(R.id.spr_dropdownperoff);
        spr_dropdownperoff1 = (Spinner) findViewById(R.id.spr_dropdownperoff1);
        spr_dropdownperoff2 = (Spinner) findViewById(R.id.spr_dropdownperoff2);
        String [] peroff = {"Select Value","P","L"};
        ArrayAdapter<String> adapterperoff = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, peroff);
        spr_dropdownperoff.setAdapter(adapterperoff);
        spr_dropdownperoff1.setAdapter(adapterperoff);
        spr_dropdownperoff2.setAdapter(adapterperoff);
        spr_dropdownpeHRS = (Spinner) findViewById(R.id.spr_dropdownpeHRS);
        spr_dropdownpeHRS.setAdapter(adapterperoff);
        spr_dropdownpeHRS1 = (Spinner) findViewById(R.id.spr_dropdownpeHRS1);
        spr_dropdownpeHRS1.setAdapter(adapterperoff);
        spr_dropdownpeHRS2 = (Spinner) findViewById(R.id.spr_dropdownpeHRS2);
        spr_dropdownpeHRS2.setAdapter(adapterperoff);
        SimpleDateFormat currentDate = new SimpleDateFormat("dd-MM-yyyy");
        Date todayDate = new Date();
        String thisDate = currentDate.format(todayDate);
        TextView crnt_date = (TextView)findViewById(R.id.crnt_date);
        Log.w(Tag,thisDate);
        crnt_date.setText(thisDate);
    }
}