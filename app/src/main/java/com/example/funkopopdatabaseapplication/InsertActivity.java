package com.example.funkopopdatabaseapplication;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class InsertActivity extends AppCompatActivity {

    private EditText idEditText, popNameEditText, popNumberEditText, popTypeEditText, fandomEditText,
            ultimateEditText, priceEditText;
    private Button insertButton;
    DatabaseHelper databaseHelper = new DatabaseHelper(this);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert);

        idEditText = findViewById(R.id.id_edit_text);
        popNameEditText = findViewById(R.id.pop_name_edit_text);
        popNumberEditText = findViewById(R.id.pop_number_edit_text);
        popTypeEditText = findViewById(R.id.pop_type_edit_text);
        fandomEditText = findViewById(R.id.fandom_edit_text);
        ultimateEditText = findViewById(R.id.ultimate_edit_text);
        priceEditText = findViewById(R.id.price_edit_text);
        insertButton = findViewById(R.id.insert_button);

        insertButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String popName = popNameEditText.getText().toString();
                int popNumber = Integer.parseInt(popNumberEditText.getText().toString());
                String popType = popTypeEditText.getText().toString();
                String fandom = fandomEditText.getText().toString();
                String ultimate = ultimateEditText.getText().toString();
                double price = Double.parseDouble(priceEditText.getText().toString());

                SQLiteDatabase db = databaseHelper.getWritableDatabase();
                ContentValues values = new ContentValues();
                values.put(DatabaseHelper.COLUMN_POP_NAME, popName);
                values.put(DatabaseHelper.COLUMN_POP_NUMBER, popNumber);
                values.put(DatabaseHelper.COLUMN_POP_TYPE, popType);
                values.put(DatabaseHelper.COLUMN_FANDOM, fandom);
                values.put(DatabaseHelper.COLUMN_ULTIMATE, ultimate);
                values.put(DatabaseHelper.COLUMN_PRICE, price);

                long newRowId = db.insert(DatabaseHelper.TABLE_NAME, null, values);

                if (newRowId != -1) {

                    Toast.makeText(InsertActivity.this, "Data inserted successfully", Toast.LENGTH_SHORT).show();
                    finish();
                } else {
                    Toast.makeText(InsertActivity.this, "Failed to insert data", Toast.LENGTH_SHORT).show();
                }
                db.close();
            }
        });

    }
}
