package com.example.maciek.myapplication;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.telephony.SmsMessage;

/**
 * Created by Maciek on 2017-11-08.
 */

public class SmsReceiver extends BroadcastReceiver {

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public void onReceive(Context context, Intent intent) {
        Bundle bundle = intent.getExtras();
        String message = "";

        if (bundle != null) {
            Object[] sms = (Object[]) bundle.get("pdus");
            String format = bundle.getString("format");
            SmsMessage smsMessage = SmsMessage.createFromPdu((byte[]) sms[0], format);
            message += smsMessage.getMessageBody();

            Intent intent1 = new Intent();
            intent1.setClassName("com.example.maciek.myapplication", "com.example.maciek.myapplication.MainActivity");
            intent1.putExtra("message", message);
            context.startActivity(intent1);
        }
    }
}
