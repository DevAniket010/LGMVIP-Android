package com.example.lgmfaceditector;

import android.app.Application;

import com.google.firebase.FirebaseApp;

public class LGMFaceDitection extends Application {
    public final static String RESULT_TEXT = "RESULT_TEXT";
    public final static String RESULT_DIALOG = "RESULT_DIALOG";


    @Override
    public void onCreate()
    {
        super.onCreate();
        FirebaseApp.initializeApp(this);
    }
}
