package com.github.pengrad.uw_turnwifi;

import android.content.Context;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SwitchCompat;
import android.widget.CompoundButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SwitchCompat switchWifi = (SwitchCompat) findViewById(R.id.switch_wifi);
        final WifiManager wifiManager = (WifiManager) this.getSystemService(Context.WIFI_SERVICE);

        wifiManager.setWifiEnabled(true);
        switchWifi.setChecked(true);
        Toast.makeText(this, "Enabling wifi", Toast.LENGTH_SHORT).show();

        switchWifi.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                wifiManager.setWifiEnabled(isChecked);
            }
        });
    }
}
