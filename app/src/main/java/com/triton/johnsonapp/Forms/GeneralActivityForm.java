package com.triton.johnsonapp.Forms;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.triton.johnsonapp.R;
import com.triton.johnsonapp.interfaces.GetDateTimeListener;
import com.triton.johnsonapp.responsepojo.GetFieldListResponse;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import butterknife.BindView;

public class GeneralActivityForm extends AppCompatActivity  {

    private DatePicker datePicker;
    private Calendar calendar;
    private TextView dateFRMView,dateTOView;
    private int year, month, day;

    Spinner leavecode_drp;
    RadioButton radio_ffn,radio_fan,radio_afn,radio_aan;

    private String TAG = "GeneralActivityForm";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_general_form);
        leavecode_drp = findViewById(R.id.leavecode_drp);
        String [] leavecode = {"Select Value","P","L"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, leavecode);
        leavecode_drp.setAdapter(adapter);
        dateFRMView = (TextView) findViewById(R.id.edt_frmdatetime);
        dateTOView = (TextView) findViewById(R.id.todt_datetime);
        calendar = Calendar.getInstance();
        year = calendar.get(Calendar.YEAR);

        month = calendar.get(Calendar.MONTH);
        day = calendar.get(Calendar.DAY_OF_MONTH);


        dateFRMView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDialog(999);
            }
        });

        radio_ffn = (RadioButton) findViewById(R.id.radio_ffn);
        radio_fan = (RadioButton) findViewById(R.id.radio_fan);
        radio_afn = (RadioButton) findViewById(R.id.radio_afn);
        radio_aan = (RadioButton) findViewById(R.id.radio_aan);

        radio_ffn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean checked = ((RadioButton) view).isChecked();
                switch(view.getId()) {
                    case R.id.radio_ffn:
                        if (checked)
                            radio_fan.setChecked(false);
                            radio_afn.setChecked(true);
                            radio_aan.setChecked(false);
                        break;
                    case R.id.radio_fan:
                        if (checked)
                            radio_ffn.setChecked(false);
                            radio_aan.setChecked(true);
                            radio_afn.setChecked(false);
                        break;
                }
                Log.w(TAG,"Radio Clicked");
            }
        });

        radio_fan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean checked = ((RadioButton) view).isChecked();
                switch(view.getId()) {
                    case R.id.radio_ffn:
                        if (checked)
                            radio_fan.setChecked(false);
                            radio_afn.setChecked(true);
                            radio_aan.setChecked(false);
                        break;
                    case R.id.radio_fan:
                        if (checked)
                            radio_ffn.setChecked(false);
                            radio_aan.setChecked(true);
                            radio_afn.setChecked(false);
                        break;
                }
                Log.w(TAG,"Radio Clicked");
            }
        });

    }



    @Override
    protected Dialog onCreateDialog(int id) {
        // TODO Auto-generated method stub
        if (id == 999) {
            return new DatePickerDialog(this,
                    myDateListener, year, month, day);
        }
        return null;
    }

    private DatePickerDialog.OnDateSetListener myDateListener = new
            DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker arg0,
                                      int arg1, int arg2, int arg3) {
                    // TODO Auto-generated method stub
                    // arg1 = year
                    // arg2 = month
                    // arg3 = day
                    showDate(arg1, arg2+1, arg3);
                    calendar.add(day,1);
//                    SimpleDateFormat tom_format = new SimpleDateFormat("dd-MMM");
//                    String tom_date = tom_format.format(calendar);
//                    dateTOView.setText(tom_date);



                    dateTOView.setText(new StringBuilder().append(arg3+1).append("/")
                            .append(arg2+1).append("/").append(arg1));

                }
            };

    private void showDate(int year, int month, int day) {
        dateFRMView.setText(new StringBuilder().append(day).append("/")
                .append(month).append("/").append(year));
    }
}