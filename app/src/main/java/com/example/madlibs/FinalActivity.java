package com.example.madlibs;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.TextView;

public class FinalActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final);

        // Grab the story from the intent
        Intent intent = getIntent();
        Story story = (Story) intent.getSerializableExtra("story");

        // Set the text to the story
        TextView text = findViewById(R.id.story);
        text.setText(Html.fromHtml(story.toString(),Html.FROM_HTML_MODE_LEGACY));
    }

    public void newStory(View view) {
        // Start the MainActivity
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);

        // Finish the current activity
        finish();
    }
}
