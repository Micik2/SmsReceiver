package com.example.maciek.myapplication.wersjaWczesniejsza;

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

    public static final String SMS_BUNDLE = "pdus";

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public void onReceive(Context context, Intent intent) {
        Bundle bundle = intent.getExtras();
        String message = "";

        if (bundle != null) {
            Object[] sms = (Object[]) bundle.get(SMS_BUNDLE);
            String format = bundle.getString("format");
            //String smsMessageStr = "";
            SmsMessage smsMessage = SmsMessage.createFromPdu((byte[]) sms[0], format);
            message += smsMessage.getMessageBody();
            for (int i = 0; i < sms.length; i++) {
                //String format = intentExtras.getString("format");
                /*SmsMessage smsMessage = SmsMessage.createFromPdu((byte[]) sms[i], format);

                message += smsMessage.getMessageBody();*/
                //String smsBody = smsMessage.getMessageBody().toString();
                //String address = smsMessage.getOriginatingAddress();

                //smsMessageStr += "SMS From: " + address + "\n";
                //smsMessageStr += smsBody + "\n";

            }
            //Toast toast = Toast.makeText(context, "Otrzymano wiadomość: " + text, Toast.LENGTH_LONG);
            //toast.show();
            //MainActivity mainActivity = MainActivity.instance();
            //MainActivity mainActivity = new MainActivity();
            //MainActivity mainActivity = MainActivity.instance();
            //mainActivity.updateInbox(message);
            Intent intent1 = new Intent();
            intent1.setClassName("com.example.maciek.myapplication", "com.example.maciek.myapplication.MainActivity");
            //intent1.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            intent1.putExtra("message", message);
            context.startActivity(intent1);
        }
    }
}
