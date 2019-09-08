package edu.utdallas.seers.android.tutorial;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;

public class MainActivity extends AppCompatActivity implements View.OnKeyListener {

    private EditText editText;
    private TextView textView;
    private ViewModel viewModel;

    public void onClickDisplayButton(View button) {
        String text = editText.getText().toString();
        if (text.isEmpty()) {
            Toast.makeText(this, R.string.message_empty_input, Toast.LENGTH_SHORT).show();
            return;
        }

        Intent intent = new Intent(this, DisplayActivity.class);

        intent.putExtra(DisplayActivity.EXTRA_MESSAGE, text);

        startActivity(intent);
    }

    @Override
    public boolean onKey(View view, int keyCode, KeyEvent keyEvent) {
        if (keyEvent.getAction() == KeyEvent.ACTION_DOWN &&
                keyCode == KeyEvent.KEYCODE_ENTER) {
            textView.setText(editText.getText());
            editText.setText("");

            return true;
        }

        return false;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewModel = ViewModelProviders.of(this).get(ViewModel.class);

        editText = findViewById(R.id.editText_main_input);
        textView = findViewById(R.id.textView_main_message);

        editText.setOnKeyListener(this);

        if (viewModel.message != null) {
            textView.setText(viewModel.message);
        }
    }

    @Override
    protected void onPause() {
        super.onPause();

        viewModel.message = textView.getText().toString();
    }

    @SuppressWarnings("WeakerAccess")
    public static class ViewModel extends androidx.lifecycle.ViewModel {
        private String message;
    }
}
