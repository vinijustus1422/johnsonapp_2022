package com.triton.johnsonapp.adapter;

import android.app.Activity;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.triton.johnsonapp.R;
import com.triton.johnsonapp.interfaces.GetSpinnerListener;
import com.triton.johnsonapp.requestpojo.SubordActivityFormReqest;
import com.triton.johnsonapp.responsepojo.GetFetchAttendanceListResponse;

import java.util.List;

public class AttendanceListAdapter extends RecyclerView.Adapter<AttendanceListAdapter.ViewHolder>{

    private final String TAG = "AttendanceListAdapter";
    private List<SubordActivityFormReqest.DataBean> Data;
    Activity context;
    private List<GetFetchAttendanceListResponse.DataBean> dataBeanList;
    GetSpinnerListener getSpinnerListener;

    public AttendanceListAdapter(Activity context, List<GetFetchAttendanceListResponse.DataBean> dataBeanList, List<SubordActivityFormReqest.DataBean> Data) {
        this.context = context;
        this.dataBeanList = dataBeanList;
        this.Data = Data;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.layout_for_attendanc_adapter, parent, false);
        return new AttendanceListAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Log.w("SubordActivityForm", "dataBeanList Size : " + dataBeanList.size());
        Log.w("SubordActivityForm", "dataBeanList Size : " + dataBeanList.get(position).getEMPNO());
        holder.empId.setText(dataBeanList.get(position).getEMPNO());
        holder.empName.setText(dataBeanList.get(position).getENAME());
        SubordActivityFormReqest.DataBean subordActivityFormReqest = new SubordActivityFormReqest.DataBean();
        subordActivityFormReqest.setEMPNO(holder.empId.getText().toString());
        subordActivityFormReqest.setENAME(holder.empName.getText().toString());

        subordActivityFormReqest.setPER_OFF(holder.empPER_OFF.getSelectedItem().toString());

        holder.empFN.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
                Log.w(TAG," s---> : "+parent.getItemAtPosition(pos).toString());
                //getSpinnerListener.getSpinnerListener(holder.empFN,parent.getItemAtPosition(pos).toString());
                subordActivityFormReqest.setFN(parent.getItemAtPosition(pos).toString());


            }
            public void onNothingSelected(AdapterView<?> parent) {


            }
        });

        holder.empAN.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
                Log.w(TAG," s---> : "+parent.getItemAtPosition(pos).toString());
                //getSpinnerListener.getSpinnerListener(holder.empFN,parent.getItemAtPosition(pos).toString());
                subordActivityFormReqest.setAN(parent.getItemAtPosition(pos).toString());


            }
            public void onNothingSelected(AdapterView<?> parent) {


            }
        });

        holder.empPER_IN_HR.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
                Log.w(TAG," s---> : "+parent.getItemAtPosition(pos).toString());
                //getSpinnerListener.getSpinnerListener(holder.empFN,parent.getItemAtPosition(pos).toString());
                subordActivityFormReqest.setPER_IN_HR(parent.getItemAtPosition(pos).toString());


            }
            public void onNothingSelected(AdapterView<?> parent) {


            }
        });

        holder.empPER_OFF.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
                Log.w(TAG," s---> : "+parent.getItemAtPosition(pos).toString());
                //getSpinnerListener.getSpinnerListener(holder.empFN,parent.getItemAtPosition(pos).toString());
                subordActivityFormReqest.setPER_OFF(parent.getItemAtPosition(pos).toString());


            }
            public void onNothingSelected(AdapterView<?> parent) {


            }
        });

        holder.empREASON.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                Log.w(TAG," s---> : "+s.toString());
                subordActivityFormReqest.setREASON(s.toString());

                // getRemarksListner.getRemarksListner(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {


            }
        });
        Data.add(subordActivityFormReqest);


    }

    @Override
    public int getItemCount() {
        return (dataBeanList != null) ? dataBeanList.size() : 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView empId, empName,empREASON;
        private Spinner empFN,empAN,empPER_IN_HR,empPER_OFF;

        public ViewHolder(View itemView) {
            super(itemView);
            empId = itemView.findViewById(R.id.empId);
            empName = itemView.findViewById(R.id.empName);
            empFN = itemView.findViewById(R.id.spr_dropdownFN);
            empAN = itemView.findViewById(R.id.spr_dropdownAN);
            empPER_IN_HR = itemView.findViewById(R.id.empPER_IN_HR);
            empPER_OFF = itemView.findViewById(R.id.spr_dropdownperoff);
            empREASON = itemView.findViewById(R.id.empREASON);
            String [] forenoon = {"Select Value","PP","LL"};
            ArrayAdapter<String> adapterfore = new ArrayAdapter<String>(context.getApplicationContext(), android.R.layout.simple_spinner_item, forenoon);
            empFN.setAdapter(adapterfore);
            empAN.setAdapter(adapterfore);
            String [] peroff = {"Select Value","P","L"};
            ArrayAdapter<String> adapterperoff = new ArrayAdapter<String>(context.getApplicationContext(), android.R.layout.simple_spinner_item, peroff);
            empPER_IN_HR.setAdapter(adapterperoff);
            empPER_OFF.setAdapter(adapterperoff);



        }
    }
}