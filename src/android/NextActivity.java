package com.example.sampletext;

import android.app.Activity;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.LinearLayout;

public class NextActivity extends Activity {

    private static final String TAG = "*** ";

    class ButtonClickListener implements View.OnClickListener {
        @SuppressLint("LongLogTag")
        public void onClick(View v) {
            Intent intent = new Intent();
            intent.putExtra("KEK", "WEW");
            setResult(RESULT_OK, intent);
            finish();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Button button123 = new Button(this);
        Button button456 = new Button(this);
        Button button789 = new Button(this);

        button123.setText("123");
        button456.setText("456");
        button789.setText("789");

        LayoutParams layoutParams = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
        button123.setLayoutParams(layoutParams);
        button456.setLayoutParams(layoutParams);
        button789.setLayoutParams(layoutParams);

        ButtonClickListener buttonClickListener = new ButtonClickListener();
        button123.setOnClickListener(buttonClickListener);
        button456.setOnClickListener(buttonClickListener);
        button789.setOnClickListener(buttonClickListener);

        LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.addView(button123);
        linearLayout.addView(button456);
        linearLayout.addView(button789);
        setContentView(linearLayout);
    }
}