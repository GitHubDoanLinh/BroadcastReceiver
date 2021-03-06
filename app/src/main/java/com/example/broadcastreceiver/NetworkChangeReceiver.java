package com.example.broadcastreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.p2p.WifiP2pManager;
import android.widget.Toast;

public class NetworkChangeReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
       try {
           if(isOnline(context)){
               Toast.makeText(context,"Mang da duoc ket noi",Toast.LENGTH_SHORT).show();
           }
           else{
               Toast.makeText(context,"Mang khong duoc ket noi !",Toast.LENGTH_SHORT).show();
           }
       }catch(NullPointerException e){
           e.printStackTrace();
       }

    }
    public boolean isOnline(Context context)
    {
        try
        {
            ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo networkInfo = cm.getActiveNetworkInfo();
            return (networkInfo!=null && networkInfo.isConnected());

        }
        catch(NullPointerException e)
        {
            e.printStackTrace();
            return false;
        }
    }
}