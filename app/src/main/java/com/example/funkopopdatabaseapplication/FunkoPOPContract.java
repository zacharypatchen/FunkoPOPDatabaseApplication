package com.example.funkopopdatabaseapplication;
import android.content.ContentProvider;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.provider.BaseColumns;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class FunkoPOPContract extends ContentProvider {
    public static final String CONTENT_AUTHORITY = "com.example.funkopopapp";

    public static final Uri BASE_CONTENT_URI = Uri.parse("content://" + CONTENT_AUTHORITY);

    public static final String PATH_FUNKO_POP = "funkopop";

    @Override
    public boolean onCreate() {
        return false;
    }

    @Nullable
    @Override
    public Cursor query(@NonNull Uri uri, @Nullable String[] strings, @Nullable String s, @Nullable String[] strings1, @Nullable String s1) {
        return null;
    }

    @Nullable
    @Override
    public String getType(@NonNull Uri uri) {
        return null;
    }

    @Nullable
    @Override
    public Uri insert(@NonNull Uri uri, @Nullable ContentValues contentValues) {
        return null;
    }

    @Override
    public int delete(@NonNull Uri uri, @Nullable String s, @Nullable String[] strings) {
        return 0;
    }

    @Override
    public int update(@NonNull Uri uri, @Nullable ContentValues contentValues, @Nullable String s, @Nullable String[] strings) {
        return 0;
    }

    public static final class FunkoPOPEntry implements BaseColumns {

        public static final Uri CONTENT_URI = Uri.withAppendedPath(BASE_CONTENT_URI, PATH_FUNKO_POP);

        // Table name
        public static final String TABLE_NAME = "FunkoPOP";

        // Column names
        public static final String _ID = BaseColumns._ID;
        public static final String COLUMN_POP_NAME = "pop_name";
        public static final String COLUMN_POP_NUMBER = "pop_number";
        public static final String COLUMN_POP_TYPE = "pop_type";
        public static final String COLUMN_FANDOM = "fandom";
        public static final String COLUMN_ON = "is_on";
        public static final String COLUMN_ULTIMATE = "ultimate";
        public static final String COLUMN_PRICE = "price";

        public static final int ON_TRUE = 1;
        public static final int ON_FALSE = 0;

        public static final String CONTENT_LIST_TYPE =
                "vnd.android.cursor.dir/" + CONTENT_AUTHORITY + "/" + PATH_FUNKO_POP;

        public static final String CONTENT_ITEM_TYPE =
                "vnd.android.cursor.item/" + CONTENT_AUTHORITY + "/" + PATH_FUNKO_POP;

        public static Uri buildFunkoPOPUri(long id) {
            return CONTENT_URI.buildUpon()
                    .appendPath(Long.toString(id))
                    .build();
        }
    }
}


