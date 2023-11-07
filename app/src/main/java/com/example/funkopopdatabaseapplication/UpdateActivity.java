package com.example.funkopopdatabaseapplication;

import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.funkopopdatabaseapplication.FunkoPOPContract;

public class UpdateActivity extends AppCompatActivity {

    private EditText popNumberEditText, updatedPopNameEditText, updatedPopTypeEditText,
            updatedFandomEditText, updatedUltimateEditText, updatedPriceEditText;
    private Button updateButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);

        popNumberEditText = findViewById(R.id.popNumberEditText);
        updatedPopNameEditText = findViewById(R.id.updatedPopNameEditText);
        updatedPopTypeEditText = findViewById(R.id.updatedPopTypeEditText);
        updatedFandomEditText = findViewById(R.id.updatedFandomEditText);
        updatedUltimateEditText = findViewById(R.id.updatedUltimateEditText);
        updatedPriceEditText = findViewById(R.id.updatedPriceEditText);
        updateButton = findViewById(R.id.updateButton);

        updateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int popNumber = Integer.parseInt(popNumberEditText.getText().toString());
                String updatedPopName = updatedPopNameEditText.getText().toString();
                String updatedPopType = updatedPopTypeEditText.getText().toString();
                String updatedFandom = updatedFandomEditText.getText().toString();
                String updatedUltimate = updatedUltimateEditText.getText().toString();
                double updatedPrice = Double.parseDouble(updatedPriceEditText.getText().toString());

                ContentValues values = new ContentValues();
                values.put(FunkoPOPContract.FunkoPOPEntry.COLUMN_POP_NAME, updatedPopName);
                values.put(FunkoPOPContract.FunkoPOPEntry.COLUMN_POP_TYPE, updatedPopType);
                values.put(FunkoPOPContract.FunkoPOPEntry.COLUMN_FANDOM, updatedFandom);
                values.put(FunkoPOPContract.FunkoPOPEntry.COLUMN_ULTIMATE, updatedUltimate);
                values.put(FunkoPOPContract.FunkoPOPEntry.COLUMN_PRICE, updatedPrice);

                String selection = FunkoPOPContract.FunkoPOPEntry.COLUMN_POP_NUMBER + " = ?";
                String[] selectionArgs = {String.valueOf(popNumber)};

                try {
                    int updatedRows = getContentResolver().update(
                            FunkoPOPContract.FunkoPOPEntry.CONTENT_URI,
                            values,
                            selection,
                            selectionArgs
                    );
                    if (updatedRows > 0) {
                        Toast.makeText(UpdateActivity.this, "Data updated successfully", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(UpdateActivity.this, "Data failed to update", Toast.LENGTH_SHORT).show();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
