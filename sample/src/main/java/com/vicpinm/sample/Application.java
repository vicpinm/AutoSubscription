package com.vicpinm.sample;

import com.vicpinm.autosubscription.Unsubscriber;

/**
 * Created by Oesia on 11/10/2016.
 */

public class Application extends android.app.Application{

    @Override public void onCreate() {
        super.onCreate();

        Unsubscriber.with(this);
    }
}
