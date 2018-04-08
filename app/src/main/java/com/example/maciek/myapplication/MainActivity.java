package com.example.maciek.myapplication;

import android.Manifest;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

/**
 * Created by Maciek on 2017-11-08.
 */

public class MainActivity extends AppCompatActivity {
    private TextView sms;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sms = (TextView) findViewById(R.id.sms);

        String permission = Manifest.permission.RECEIVE_SMS;
        int grant = ContextCompat.checkSelfPermission(this, permission);

        if (grant != PackageManager.PERMISSION_GRANTED) {
            String[] permissions = new String[1];
            permissions[0] = permission;
            ActivityCompat.requestPermissions(this, permissions, 1);
        }

        sms.setText("BRAK WIADOMOŚCI");
        if (getIntent().getStringExtra("message") != null) {
            String message = getIntent().getStringExtra("message");
            sms.setText(message);
        }
    }
}
