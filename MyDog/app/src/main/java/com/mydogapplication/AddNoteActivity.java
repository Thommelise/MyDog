package com.mydogapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;
import com.mydogapplication.DogApi.DogViewModel;
public class AddNoteActivity extends AppCompatActivity {

    EditText editTextRace;
    DogViewModel viewModel;
    EditText editTextTitle;
    EditText editTextDescription;

    public static final String EXTRA_TITLE =
            "com.mydogapplication.EXTRA_TITLE";

    public static final String EXTRA_DESCRIPTION =
            "com.mydogapplication.EXTRA_DESCRIPTION";

    public static final String EXTRA_RACE =
            "com.mydogapplication.EXTRA_PRIORITY";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_note);

        editTextRace = findViewById(R.id.edit_text_race);
        editTextTitle = findViewById(R.id.edit_text_title);
        editTextDescription = findViewById(R.id.edit_text_description);


        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_close);

        setTitle("Add Note");
        viewModel = new ViewModelProvider(this).get(DogViewModel.class);
    }

    private void saveNote(){
        String title = editTextTitle.getText().toString();
        String description = editTextDescription.getText().toString();
        String race = editTextRace.getText().toString();

        if (title.trim().isEmpty() || description.trim().isEmpty()|| race.trim().isEmpty()) {
            Toast.makeText(this, "Please insert a title and description", Toast.LENGTH_SHORT).show();
            return;
        }
        Intent data = new Intent();
        data.putExtra(EXTRA_TITLE, title);
        data.putExtra(EXTRA_DESCRIPTION, description);
        data.putExtra(EXTRA_RACE, race);

        setResult(RESULT_OK, data);
        finish();
    }
    @Override
      public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.add_note_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.save_note:
                saveNote();
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }

    }


}

