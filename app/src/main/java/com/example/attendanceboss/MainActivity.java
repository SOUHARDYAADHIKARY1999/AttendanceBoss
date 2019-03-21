package com.example.attendanceboss;

import com.example.attendanceboss.R1;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;

public class MainActivity extends Activity {

    Button start;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        start =(Button)findViewById(R1.id.buttonstart);
        start.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub

                Intent intent =new Intent(MainActivity.this,LoginActivity.class);
                startActivity(intent);
            }
        });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R1.menu.main, menu);
        return true;
    }
}
