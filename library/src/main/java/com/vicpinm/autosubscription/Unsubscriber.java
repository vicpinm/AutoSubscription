package com.vicpinm.autosubscription;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;

import com.vicpinm.autosubscription.anotations.AutoSubscription;

import java.lang.reflect.Field;
import java.util.HashSet;
import java.util.Set;

import io.reactivex.disposables.Disposable;

/**
 * Created by Victor on 10/10/2016.
 */

public class Unsubscriber {

    public static void with(Application application){
        application.registerActivityLifecycleCallbacks(new Application.ActivityLifecycleCallbacks() {
            @Override public void onActivityCreated(Activity activity, Bundle savedInstanceState) {

            }

            @Override public void onActivityStarted(Activity activity) {

            }

            @Override public void onActivityResumed(Activity activity) {

            }

            @Override public void onActivityPaused(Activity activity) {

            }

            @Override public void onActivityStopped(Activity activity) {

            }

            @Override public void onActivitySaveInstanceState(Activity activity, Bundle outState) {

            }

            @Override public void onActivityDestroyed(Activity activity) {
                unlink(activity);
            }
        });
    }

    public static void unlink(Object instance){
        for(Field f : findUnsubscribeFields(instance.getClass())){
            try {
                boolean accesibility = f.isAccessible();
                f.setAccessible(true);
                Object o = f.get(instance);
                if(o instanceof Disposable){
                    ((Disposable)o).dispose();
                }
                else if(o instanceof UnsubscribeListener){
                    ((UnsubscribeListener)o).onUnsubscribe();
                }
                else{
                    unlink(o);
                }
                f.setAccessible(accesibility);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }

    public static Set<Field> findUnsubscribeFields(Class c) {
        Set<Field> set = new HashSet<>();
        while (c != null) {
            for (Field field : c.getDeclaredFields()) {
                if (field.isAnnotationPresent(AutoSubscription.class)) {
                    set.add(field);
                }
            }
            c = c.getSuperclass();
        }
        return set;
    }
}
