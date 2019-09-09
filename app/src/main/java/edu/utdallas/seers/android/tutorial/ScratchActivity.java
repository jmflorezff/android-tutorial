package edu.utdallas.seers.android.tutorial;

import android.view.View;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import java.io.*;

public class ScratchActivity extends AppCompatActivity {

    private static final String FILE_NAME = "save";

    private EditText editText;
    private File saveFile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scratch);

        editText = findViewById(R.id.editText_scratch);

        saveFile = new File(getFilesDir(), FILE_NAME);

        if (saveFile.exists()) {
            try {
                BufferedReader reader = new BufferedReader(new FileReader(saveFile));

                StringBuilder builder = new StringBuilder();

                String line;
                while ((line = reader.readLine()) != null) {
                    builder.append(line).append("\n");
                }

                editText.setText(builder.toString());

            } catch (FileNotFoundException ignore) {
            } catch (IOException ignore) {
            }
        }
    }

    public void onClickClearButton(View button) {
        saveFile.delete();
        editText.setText("");
    }

    @Override
    protected void onPause() {
        super.onPause();

        String text = editText.getText().toString();

        try {
            FileWriter writer = new FileWriter(saveFile);
            writer.write(text);
            writer.close();
        } catch (IOException ignore) {
        }
    }
}
