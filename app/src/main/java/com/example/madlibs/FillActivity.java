package com.example.madlibs;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class FillActivity extends AppCompatActivity {

    TextView remain;
    TextView type;
    Story story;
    EditText fill;
    int remainder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fill);

        Intent intent = getIntent();
        story = (Story) intent.getSerializableExtra("clicked_story");

        remain = findViewById(R.id.remain);
        type = findViewById(R.id.type);

        remainder = story.getPlaceholderCount();

        remain.setText(remainder + " word(s) left");
        type.setText("Please type a/an " + story.getNextPlaceholder().toLowerCase());
    }

    public void FillText(View view) {

        fill = findViewById(R.id.fill);
        String fill_text = fill.getText().toString();

        if (!(fill_text.isEmpty())) {
            story.fillInPlaceholder(fill_text);
            fill.setText("");
            remainder = story.getPlaceholderRemainingCount();

            remain.setText(remainder + " word(s) left");
            type.setText("Please type a/an " + story.getNextPlaceholder().toLowerCase());
        }

        if (story.isFilledIn()){
            Intent intent = new Intent(this, FinalActivity.class);
            intent.putExtra("story", story);
            startActivity(intent);
            finish();
        }
    }
}
