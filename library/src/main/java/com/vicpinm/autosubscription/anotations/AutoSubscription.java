package com.vicpinm.autosubscription.anotations;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;

/**
 * Created by Victor on 10/10/2016.
 */
@Target({ FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface AutoSubscription {
}
