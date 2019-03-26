package com.example.madlibs;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    // Start ChooseActivity if the start button is pressed
    public void goToChoose(View view) {
        Intent intent = new Intent(this, ChooseActivity.class);
        startActivity(intent);
    }
}
