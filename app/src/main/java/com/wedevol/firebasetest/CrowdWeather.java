package com.wedevol.firebasetest;

import com.firebase.client.Firebase;

/**
 * Created by charz on 8/9/16.
 */
public class CrowdWeather extends android.app.Application {

    @Override
    public void onCreate(){
        super.onCreate();
        Firebase.setAndroidContext(this);
    }
}
