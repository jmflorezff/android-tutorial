package edu.utdallas.seers.android.tutorial;

import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class DisplayActivity extends AppCompatActivity {

    public static final String EXTRA_MESSAGE = "message";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);

        String message = getIntent().getStringExtra(EXTRA_MESSAGE);

        ((TextView) findViewById(R.id.textView_display_message)).setText(message);
    }
}
