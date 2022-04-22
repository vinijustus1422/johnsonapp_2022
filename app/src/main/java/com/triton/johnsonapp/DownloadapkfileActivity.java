package com.triton.johnsonapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DownloadManager;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class DownloadapkfileActivity extends AppCompatActivity {

    private String TAG ="DownloadapkfileActivity";
    Button btn_download;

    DownloadManager manager;
    String apk_link;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_downloadapkfile);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            apk_link = extras.getString("apk_link");

            Log.w(TAG,"activity_id -->"+apk_link);


        }
        btn_download = findViewById(R.id.btn_download);
        btn_download.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                manager = (DownloadManager) getSystemService(DownloadapkfileActivity.this.DOWNLOAD_SERVICE);
                Uri uri = Uri.parse(apk_link);
                Log.w(TAG,"APK---"+uri);
                DownloadManager.Request request = new DownloadManager.Request(uri);
                request.setTitle("Jlsmart APK");
                request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
                //request.setDestinationInExternalFilesDir(DownloadapkfileActivity.this,"/JlsmartDownload", String.valueOf(uri)+ ".apk");
                manager.enqueue(request);
                //Log.w(TAG,"REQUEST--"+reference);
                Toast.makeText(DownloadapkfileActivity.this,"Jlsmart download file successfully !!!",Toast.LENGTH_SHORT).show();

            }
        });
    }
}