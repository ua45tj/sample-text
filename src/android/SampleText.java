package com.example.sampletext;

import android.app.Activity;

import android.util.Log;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CallbackContext;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class SampleText extends CordovaPlugin {

    private static final String TAG = "### ";

    public CallbackContext callbackContext;

    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
        this.callbackContext = callbackContext;

        if (action.equals("coolMethod")) {
            String message = args.getString(0);
            this.coolMethod(message, callbackContext);
            return true;
        }
        return false;
    }

    private void coolMethod(String message, CallbackContext callbackContext) {
        if (message != null && message.length() > 0) {
            Context context = cordova.getActivity();
            Intent intent = new Intent(context, NextActivity.class);
            // cordova.setActivityResultCallback(this);
            cordova.startActivityForResult(this, intent, 0);
        } else {
            callbackContext.error("Expected one non-empty string argument.");
        }
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Log.d(TAG, "requestCode=" + requestCode + " resultCode=" + resultCode);
        if (resultCode == Activity.RESULT_OK) {
            if (data != null) {
                Log.w(TAG, "get by SAS => " + data.getStringExtra("SAS"));
                Log.w(TAG, "get by KEK => " + data.getStringExtra("KEK"));
            }
            callbackContext.success("RESULT_OK");
        } else if (resultCode == Activity.RESULT_CANCELED) {
            callbackContext.error("RESULT_CANCELED");
        } else {
            callbackContext.error("RESULT_FIRST_USER or something=" + resultCode);
        }
    }
}
