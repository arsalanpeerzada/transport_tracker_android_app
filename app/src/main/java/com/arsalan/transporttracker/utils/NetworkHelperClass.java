package com.arsalan.transporttracker.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

//NetworkConnectionClass
public class NetworkHelperClass {

    public static boolean hasNetworkAccess(Context _context){
        ConnectivityManager cm = (ConnectivityManager)
                _context.getSystemService(Context.CONNECTIVITY_SERVICE);

        boolean connection = false;
        try {
            NetworkInfo networkInfo = cm.getActiveNetworkInfo();

            connection = false;

            if (networkInfo != null && networkInfo.isConnectedOrConnecting()){
                connection = true;
            }
            else connection = false;

            return connection;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }


    }
}
