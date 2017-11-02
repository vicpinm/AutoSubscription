package com.vicpinm.sample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.vicpinm.autosubscription.anotations.AutoSubscription;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;

public class MainActivity extends AppCompatActivity {

    @AutoSubscription Disposable s1;
    @AutoSubscription Disposable s2;
    @AutoSubscription Disposable s3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        createSubscriptions();
    }

    public void createSubscriptions(){
        s1 = Observable.create(new ObservableOnSubscribe<String>() {
            @Override public void subscribe(@NonNull ObservableEmitter<String> e) throws Exception {
                Log.d("Sample","Subscription s1 created");
            }

        }).subscribe();

        s2 = Observable.create(new ObservableOnSubscribe<String>() {
            @Override public void subscribe(@NonNull ObservableEmitter<String> e) throws Exception {
                Log.d("Sample","Subscription s2 created");
            }
        }).subscribe();

        s3 = Observable.create(new ObservableOnSubscribe<String>() {
            @Override public void subscribe(@NonNull ObservableEmitter<String> e) throws Exception {
                Log.d("Sample","Subscription s3 created");
            }
        }).subscribe();
    }
}
