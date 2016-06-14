package com.example.andres.myapplication.service;

import android.accessibilityservice.AccessibilityServiceInfo;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.speech.tts.TextToSpeech;
import android.util.Log;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;

import java.util.Locale;

public class AccessibilityService extends android.accessibilityservice.AccessibilityService {

    public AccessibilityService() {
    }

    static final String TAG = "AccesibilitySERVICE";


    private String getEventType(AccessibilityEvent event) {
        switch (event.getEventType()) {
            case AccessibilityEvent.TYPE_VIEW_CLICKED:
                Log.e("CLICK", String.valueOf(event.getText()));
               // Log.e("HIJONODO",String.valueOf(accessibilityNodeInfo.getChild(0).getText()));
                return "TYPE_VIEW_CLICKED";
        }
        return "default";
    }

    private String getEventText(AccessibilityEvent event) {
        StringBuilder sb = new StringBuilder();
        for (CharSequence s : event.getText()) {
            sb.append(s);
        }
        return sb.toString();
    }

    @Override
    public void onAccessibilityEvent(AccessibilityEvent event) {


        Log.v(TAG, String.format(
                "onAccessibilityEvent: [type] %s [text] %s",
                getEventType(event), getEventText(event)));

        AccessibilityNodeInfo source = null;
        if (AccessibilityEvent.TYPE_VIEW_CLICKED == event.getEventType()) {
            source = event.getSource();
            Log.e("CLICK", String.valueOf(source.getText()));
        }
    }

    @Override
    public void onInterrupt() {
        Log.v(TAG, "onInterrupt");
    }

    @Override
    protected void onServiceConnected() {
        super.onServiceConnected();
        Log.v(TAG, "onServiceConnected");
        AccessibilityServiceInfo info = new AccessibilityServiceInfo();
        info.flags = AccessibilityServiceInfo.DEFAULT;
        info.eventTypes = AccessibilityEvent.TYPES_ALL_MASK;
        info.feedbackType = AccessibilityServiceInfo.FEEDBACK_GENERIC;
        info.notificationTimeout = 100;
        info.packageNames = new String[]{"com.example.andres.myapplication"};
        setServiceInfo(info);

    }
}
