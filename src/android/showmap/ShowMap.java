package com.bd.bmap.showmap;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Toast;
import android.content.Intent;


import com.bd.bmap.BMap;
import com.bd.bmap.ShowMapActivity;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaInterface;


/**
 * Created by qinjm on 2016.12.
 */
public class ShowMap extends BMap{
    private Context context;
    private  CordovaInterface cordova1;
    @Override
    public void bmap(final CordovaInterface cordova, final String param, final CallbackContext callbackContext) {
        cordova1 = cordova;

        cordova.getThreadPool().execute(new Runnable() {
            @Override
            public void run() {
//                mHandler.sendEmptyMessage(1);

                Intent intent=new Intent(cordova.getActivity(),ShowMapActivity.class);
                intent.putExtra("param",param);

                mHandler.sendEmptyMessage(1);
                (cordova.getActivity()).startActivity(intent);
//                cordova.startActivityForResult(cordovaPlugin,intent,200);
//                mHandler.sendEmptyMessage(3);
                if(true){
                    callbackContext.success("success");
                }else{
                    callbackContext.error("error");
                }
            }
        });

    }
    Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            //msg.what
            Toast.makeText(cordova1.getActivity(), "开启中...", Toast.LENGTH_SHORT).show();
        }
    };

}
