package com.example.widgetcontrol;

import android.content.Context;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setWiFiText();
    }

    private void setWiFiText()
    {
        TextView wifionofftxt = (TextView)findViewById(R.id.wifionofftxt);
        TextView wificonntxt = (TextView) findViewById(R.id.wificonntxt);
        TextView apnametxt = (TextView) findViewById(R.id.apnametxt);
        TextView macaddresstxt = (TextView) findViewById(R.id.macaddresstxt);
        WifiManager wiFiManager = (WifiManager) getSystemService(Context.WIFI_SERVICE);

        switch(wiFiManager.getWifiState())
        {
            case WifiManager.WIFI_STATE_DISABLED:
            case WifiManager.WIFI_STATE_DISABLING:
            case WifiManager.WIFI_STATE_UNKNOWN:
                wifionofftxt.setText("꺼짐");
                wificonntxt.setText("연결 안됨");
                apnametxt.setText("N/A");
                macaddresstxt.setText("N/A");
                break;
            case WifiManager.WIFI_STATE_ENABLING:
                wifionofftxt.setText("켜짐");
                wificonntxt.setText("연결 안됨");
                apnametxt.setText("N/A");
                macaddresstxt.setText("N/A");
                break;
            case WifiManager.WIFI_STATE_ENABLED:
                wifionofftxt.setText("켜짐");
                WifiInfo wifiinfo = wiFiManager.getConnectionInfo();
                if(null != wifiinfo)
                {
                    wificonntxt.setText("연결 됨");
                    apnametxt.setText(wiFiManager.getConnectionInfo().getSSID());
                    macaddresstxt.setText(wiFiManager.getConnectionInfo().getMacAddress());
                }
                else
                {
                    wificonntxt.setText("연결 안됨");
                    apnametxt.setText("N/A");
                    macaddresstxt.setText("N/A");
                }
                break;
            default:
                break;
        }
    }
}


