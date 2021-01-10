package org.devgeeks.privacyscreen;
import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.WindowManager;

public class ScreenRestrict extends Application {
    private Context context;
    private String TAG = "Purushotham";

    public void onCreate() {
        setupActivityListener();
        super.onCreate();
        context = getApplicationContext();

    }

    private void setupActivityListener() {
        registerActivityLifecycleCallbacks(new ActivityLifecycleCallbacks() {
            @Override
            public void onActivityCreated(Activity activity, Bundle savedInstanceState) {

            }

            @Override
            public void onActivityStarted(Activity activity) {
                Log.v(TAG, "onActivityStarted");
            }

            @Override
            public void onActivityResumed(Activity activity) {
                Log.v(TAG, "onActivityResumed");

            }

            @Override
            public void onActivityPaused(Activity activity) {

                activity.getWindow().setFlags(WindowManager.LayoutParams.FLAG_SECURE, WindowManager.LayoutParams.FLAG_SECURE);

            }

            @Override
            public void onActivityStopped(Activity activity) {
                activity.getWindow().setFlags(WindowManager.LayoutParams.FLAG_SECURE, WindowManager.LayoutParams.FLAG_SECURE);
            }

            @Override
            public void onActivitySaveInstanceState(Activity activity, Bundle outState) {
                Log.v(TAG, "onActivitySaveInstanceState");
            }

            @Override
            public void onActivityDestroyed(Activity activity) {
                Log.v(TAG, "onActivityDestroyed");
            }
        });
    }
}
