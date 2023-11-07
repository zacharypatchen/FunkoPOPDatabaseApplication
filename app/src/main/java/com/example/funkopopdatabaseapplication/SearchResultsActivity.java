package com.example.funkopopdatabaseapplication;

import android.content.ContentResolver;
import android.database.Cursor;
import android.os.Bundle;
import android.widget.ListView;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;

public class SearchResultsActivity extends AppCompatActivity {
    private ListView listView;
    private FunkoPOPAdapter adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_results);

        String query = getIntent().getStringExtra("query");
        ArrayList<FunkoPOPItem> searchResults = performDatabaseSearch(query);

        listView = findViewById(R.id.listView);
        adapter = new FunkoPOPAdapter(this, searchResults);

        listView.setAdapter(adapter);
    }

    private ArrayList<FunkoPOPItem> performDatabaseSearch(String query) {
        ArrayList<FunkoPOPItem> searchResults = new ArrayList<>();
        DatabaseHelper databaseHelper = new DatabaseHelper(this);
        searchResults = databaseHelper.searchFunkoPOPItemsByQuery(query);

        return searchResults;
    }


}
