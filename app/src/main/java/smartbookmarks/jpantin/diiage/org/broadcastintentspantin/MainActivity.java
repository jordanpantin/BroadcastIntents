package smartbookmarks.jpantin.diiage.org.broadcastintentspantin;

import android.Manifest;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.database.Cursor;
import android.net.Uri;
import android.os.BatteryManager;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Event battery
        this.registerReceiver(new PowerConnectionReceiver(), new IntentFilter(Intent.ACTION_BATTERY_CHANGED));
    }

    @Override
    protected void onStart() {
        // Permission pour les versions android au dessus de 6.0
        ActivityCompat.requestPermissions(MainActivity.this,
                new String[]{Manifest.permission.RECEIVE_SMS},
                1);

        super.onStart();
    }
}
