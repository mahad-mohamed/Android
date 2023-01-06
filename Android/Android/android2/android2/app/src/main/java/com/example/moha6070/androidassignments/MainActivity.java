package com.example.moha6070.androidassignments;

import android.support.v7.app.AppCompatActivity;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    protected static final String ACTIVITY_NAME = "MainActivity";
    private final int REQUEST_CODE = 10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i(ACTIVITY_NAME, "In onCreate()");

        final Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                Log.i(ACTIVITY_NAME, "Returned to StartActivity.onActivityResult");


                Intent intent = new Intent(MainActivity.this, ListItemsActivity.class);
                startActivityForResult(intent, REQUEST_CODE);


            }
        });

        Button start_Chat = findViewById(R.id.start_Chat);
        start_Chat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i(ACTIVITY_NAME, "User clicked Start Chat");

                Intent intent = new Intent(MainActivity.this, ChatWindow.class);
                startActivity(intent);
            }
        }) ;

        Button testToolbarButton = findViewById(R.id.testToolbar);
        testToolbarButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i(ACTIVITY_NAME, "User clicked Test Toolbar");

                Intent intent = new Intent(MainActivity.this, TestToolbar.class);
                startActivity(intent);
            }
        });


    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(ACTIVITY_NAME, "In onResume()");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(ACTIVITY_NAME, "In onStart()");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i(ACTIVITY_NAME, "In onPause()");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(ACTIVITY_NAME, "In onStop()");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(ACTIVITY_NAME, "In onDestroy()");
    }

    public void onActivityResult(int requestCode, int responseCode, Intent data) {
        super.onActivityResult(requestCode, responseCode, data);
        if (requestCode == REQUEST_CODE) Log.i(ACTIVITY_NAME, "Returned to StartActivity.onActivityResult");
        if (responseCode == Activity.RESULT_OK) {
            String messagePassed = data.getStringExtra("Response");
            Toast toast = Toast.makeText(this, "ListItemsActivity passed: " + messagePassed, Toast.LENGTH_LONG);
            toast.show();
        }
    }

}
