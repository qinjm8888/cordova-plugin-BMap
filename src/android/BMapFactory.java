package com.bd.bmap;

import com.bd.bmap.showmap.ShowMap;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaInterface;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CordovaWebView;
import org.json.JSONArray;
import org.json.JSONException;
import android.widget.Toast;

/**
 * Created by qinjm on 2016.12.23.
 */
public class BMapFactory extends CordovaPlugin{

    public static final String ACT_PLAY="bmap";

    private BMap bmap;

    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
        if (ACT_PLAY.equals(action)){
            String param=args.getString(0);

            bmap = new ShowMap();
            bmap.bmap(cordova,param,callbackContext);
            return true;
        }

        return  false;
    }


}
