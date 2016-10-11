package com.vicpinm.sample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.vicpinm.autosubscription.anotations.AutoSubscription;

import rx.Observable;
import rx.Subscriber;
import rx.Subscription;

public class MainActivity extends AppCompatActivity {

    @AutoSubscription Subscription s1;
    @AutoSubscription Subscription s2;
    @AutoSubscription Subscription s3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        createSubscriptions();
    }

    public void createSubscriptions(){
        s1 = Observable.create(new Observable.OnSubscribe<String>() {
            @Override public void call(Subscriber<? super String> subscriber) {
                Log.d("Sample","Subscription s1 created");
            }
        }).subscribe();

        s2 = Observable.create(new Observable.OnSubscribe<String>() {
            @Override public void call(Subscriber<? super String> subscriber) {
                Log.d("Sample","Subscription s2 created");
            }
        }).subscribe();

        s3 = Observable.create(new Observable.OnSubscribe<String>() {
            @Override public void call(Subscriber<? super String> subscriber) {
                Log.d("Sample","Subscription s3 created");
            }
        }).subscribe();
    }
}
