package com.example.maciek.myapplication.wersjaWczesniejsza;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.example.maciek.myapplication.R;

public class MainActivity extends AppCompatActivity {
    //private static MainActivity mainActivity = new MainActivity();
    //private static MainActivity instance = new MainActivity();
    //private MainActivity mainActivity = new MainActivity();
    //Context context;
    private TextView sms;
    //private static Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sms = (TextView) findViewById(R.id.sms);
        //context = getApplicationContext();

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
        //sms.setText("TEST");
    }
/*
    public static MainActivity instance() {
        return mainActivity;
    }*/
/*
    @Override
    protected void onStart() {
        super.onStart();
        //sms = (TextView) findViewById(R.id.sms);
        //super.onStart();
        //instance = this;
    }*/
/*
    @Override
    protected void onResume() {
        super.onResume();
        //sms = (TextView) findViewById(R.id.sms);
    }
*/

    /*public static Context getAppContext() {
        return instance().context;
    }*/
/*
    public void updateInbox(String message) {
        //LayoutInflater layoutInflater = (LayoutInflater) getAppContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        //View view = layoutInflater.inflate(R.layout.activity_main, null, true);
        //View view = layoutInflater.inflate(R.layout.activity_main, null, true);
        //TextView textView = view.findViewById(R.id.sms);
        //Toast.makeText(getApplicationContext(), message, Toast.LENGTH_LONG).show();
        //sms = (TextView) findViewById(R.id.sms);
        //sms = (TextView) findViewById(R.id.sms);
        Bundle bundle = new Bundle();
        onCreate(bundle);
        //sms.setText(message);
    }*/
}
