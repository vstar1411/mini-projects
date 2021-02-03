package com.mandal.rahul.attendancemanager;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;

public class AlarmReceiver2 extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        Intent service2 = new Intent(context, NotificationService2.class);
        service2.setData((Uri.parse("custom://" + System.currentTimeMillis())));
        context.startService(service2);
    }
}
