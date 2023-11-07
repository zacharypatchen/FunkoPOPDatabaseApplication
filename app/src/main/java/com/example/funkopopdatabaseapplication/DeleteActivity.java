package com.example.funkopopdatabaseapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NavUtils;
import androidx.core.app.TaskStackBuilder;
import com.example.funkopopdatabaseapplication.DatabaseHelper;

public class DeleteActivity extends AppCompatActivity {

    private EditText popNumberEditText;
    private Button deleteButton;
    private DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete);

        popNumberEditText = findViewById(R.id.editTextPopNumber);
        deleteButton = findViewById(R.id.buttonDelete);
        databaseHelper = new DatabaseHelper(this);

        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String popNumberString = popNumberEditText.getText().toString();
                if (!popNumberString.isEmpty()) {
                    int popNumber = Integer.parseInt(popNumberString);

                    // Call the method in DatabaseHelper to delete the record
                    boolean isDeleted = databaseHelper.deleteRecord(popNumber);

                    if (isDeleted) {
                        Toast.makeText(DeleteActivity.this, "Record deleted successfully", Toast.LENGTH_SHORT).show();
                        finish();
                    } else {
                        Toast.makeText(DeleteActivity.this, "Record not found", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(DeleteActivity.this, "Please enter POP Number", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
