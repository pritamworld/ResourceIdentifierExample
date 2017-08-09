package com.pritesh.resourceidentifierexample;

import android.content.ComponentName;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ImageView;

import java.sql.Time;
import java.text.DateFormat;
import java.util.Date;

public class MainActivity extends AppCompatActivity
{
    ActionBar mActionBar;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        setDynamicActivityLogo();
    }

    private void setDynamicActivityLogo()
    {
        ImageView imageView = (ImageView)findViewById(R.id.imageView);
        int imageResourceId;
        String currentDateTimeString = DateFormat.getDateTimeInstance().format(new Date());
        int hours = new Time(System.currentTimeMillis()).getHours();
        Log.d("DATE", "onCreate: "  + hours);

        getPackageManager().setComponentEnabledSetting(
                getComponentName(), PackageManager.COMPONENT_ENABLED_STATE_DISABLED, PackageManager.DONT_KILL_APP);

        if(hours == 13)
        {
            imageResourceId = this.getResources().getIdentifier("ic_android_red", "drawable", this.getPackageName());
            getPackageManager().setComponentEnabledSetting(
                    new ComponentName("com.pritesh.resourceidentifierexample", "com.pritesh.resourceidentifierexample.MainActivity-Red"),
                    PackageManager.COMPONENT_ENABLED_STATE_ENABLED, PackageManager.DONT_KILL_APP);
        }else if(hours == 14)
        {
            imageResourceId = this.getResources().getIdentifier("ic_android_green", "drawable", this.getPackageName());
            getPackageManager().setComponentEnabledSetting(
                    new ComponentName("com.pritesh.resourceidentifierexample", "com.pritesh.resourceidentifierexample.MainActivity-Green"),
                    PackageManager.COMPONENT_ENABLED_STATE_ENABLED, PackageManager.DONT_KILL_APP);

        }else
        {
            imageResourceId = this.getResources().getIdentifier("ic_android_blue", "drawable", this.getPackageName());
            getPackageManager().setComponentEnabledSetting(
                    new ComponentName("com.pritesh.resourceidentifierexample", "com.pritesh.resourceidentifierexample.MainActivity-Blue"),
                    PackageManager.COMPONENT_ENABLED_STATE_ENABLED, PackageManager.DONT_KILL_APP);

        }

        imageView.setImageResource(imageResourceId);

    }
}
