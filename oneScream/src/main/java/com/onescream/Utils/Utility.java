package com.onescream.Utils;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.WindowManager;

import com.onescream.R;
import com.parse.ParseUser;
import com.segment.analytics.Analytics;
import com.segment.analytics.Properties;
import com.segment.analytics.Traits;
//import com.segment.analytics.Analytics;
//import com.segment.analytics.Properties;
//import com.segment.analytics.Traits;

/**
 * Created by seraphicinfosolutions on 4/21/16.
 */
public class Utility {

    private static final String TAG = "Utility";
    public Context context;

    public Utility(Context context) {
        this.context = context;
    }

    public void RegisterScreen(Context context, String string) {

        try {

            final ParseUser user = ParseUser.getCurrentUser();
            Analytics.with(context).identify("email:" + user.getEmail(), new Traits().putName(user.getString("first_name")).putEmail(user.getEmail()), null);

            Analytics.with(context).screen("Activity", string, new Properties().putValue(string, string));
//            Analytics.with(context).track(string, new Properties().putValue(string, string));
        } catch (Exception e) {
            Log.e(TAG, " error " + e.getMessage());
        }


    }


    public boolean getScreenSize() {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        WindowManager wm = (WindowManager) context.getApplicationContext().getSystemService(Context.WINDOW_SERVICE); // the results will be higher than using the activity context object or the getWindowManager() shortcut
        wm.getDefaultDisplay().getMetrics(displayMetrics);
        int screenWidth = displayMetrics.widthPixels;
        int screenHeight = displayMetrics.heightPixels;
        Log.e(TAG, " height== " + screenHeight);
        Log.e(TAG, " width== " + screenWidth);
        if (screenWidth == 480 && screenHeight == 800) {
            return true;
        }
        return false;
    }

    public int convertPixelsToDp(float px, Context context) {
        Resources resources = context.getResources();
        DisplayMetrics metrics = resources.getDisplayMetrics();
        int dp = (int) (px / (metrics.densityDpi / 160f));
        return dp;
    }

    public boolean getScreenSizeOther() {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        WindowManager wm = (WindowManager) context.getApplicationContext().getSystemService(Context.WINDOW_SERVICE); // the results will be higher than using the activity context object or the getWindowManager() shortcut
        wm.getDefaultDisplay().getMetrics(displayMetrics);
        int screenWidth = displayMetrics.widthPixels;
        int screenHeight = displayMetrics.heightPixels;
        Log.e(TAG, " height== " + screenHeight);
        Log.e(TAG, " width== " + screenWidth);
        if (screenWidth == 540) {
            return true;
        }
        return false;
    }
}
