package edu.utdallas.seers.android.tutorial;

import android.content.Intent;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class DisplayActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);

        String message = getIntent().getStringExtra(Intent.EXTRA_TEXT);

        ((TextView) findViewById(R.id.textView_display_message)).setText(message);
    }
}
