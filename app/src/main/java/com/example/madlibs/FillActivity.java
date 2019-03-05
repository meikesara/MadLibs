package com.example.madlibs;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class FillActivity extends AppCompatActivity {

    // Create variables remain, type, story, fill and remainder
    TextView remain;
    TextView type;
    Story story;
    EditText fill;
    int remainder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fill);

        // Grab the current Story from the intent
        Intent intent = getIntent();
        story = (Story) intent.getSerializableExtra("clicked_story");

        // Get how many words need to be filled in
        remainder = story.getPlaceholderCount();

        // Set the remainder
        remain = findViewById(R.id.remain);
        remain.setText(remainder + " word(s) left");

        // Set the type of word that needs to be filled in
        type = findViewById(R.id.type);
        type.setText("Please type a/an " + story.getNextPlaceholder().toLowerCase());
    }

    public void FillText(View view) {

        // Get the text that was filled in by the user
        fill = findViewById(R.id.fill);
        String fill_text = fill.getText().toString();

        // Check if the user filled in the editText
        if (!(fill_text.isEmpty())) {

            // Fill the word into the story
            story.fillInPlaceholder(fill_text);

            // Empty the editText
            fill.setText("");

            // Update the remainder and the type of word
            remainder = story.getPlaceholderRemainingCount();
            remain.setText(remainder + " word(s) left");
            type.setText("Please type a/an " + story.getNextPlaceholder().toLowerCase());
        }

        // Check if the story is completely filled in
        if (story.isFilledIn()){

            // Start FinalActivity and put the story into the intent
            Intent intent = new Intent(this, FinalActivity.class);
            intent.putExtra("story", story);
            startActivity(intent);

            // Finish the current activity
            finish();
        }
    }
}
