package com.example.funkopopdatabaseapplication;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "FunkoPOPDatabase";
    private static final int DATABASE_VERSION = 1;

    public static final String TABLE_NAME = "FunkoPOP";
    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_POP_NAME = "pop_name";
    public static final String COLUMN_POP_NUMBER = "pop_number";
    public static final String COLUMN_POP_TYPE = "pop_type";
    public static final String COLUMN_FANDOM = "fandom";
    public static final String COLUMN_ON = "is_on";
    public static final String COLUMN_ULTIMATE = "ultimate";
    public static final String COLUMN_PRICE = "price";

    private static final String DATABASE_CREATE = "CREATE TABLE " + TABLE_NAME + " (" +
            COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            COLUMN_POP_NAME + " TEXT, " +
            COLUMN_POP_NUMBER + " INTEGER, " +
            COLUMN_POP_TYPE + " TEXT, " +
            COLUMN_FANDOM + " TEXT, " +
            COLUMN_ON + " INTEGER, "+
            COLUMN_ULTIMATE + " TEXT, " +
            COLUMN_PRICE + " REAL);";



    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase database) {
        database.execSQL(DATABASE_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }
    public boolean deleteRecord(int popNumber) {
        SQLiteDatabase db = this.getWritableDatabase();
        try {
            String selection = FunkoPOPContract.FunkoPOPEntry.COLUMN_POP_NUMBER + " = ?";
            String[] selectionArgs = { String.valueOf(popNumber) };

            int deletedRows = db.delete(FunkoPOPContract.FunkoPOPEntry.TABLE_NAME, selection, selectionArgs);

            if (deletedRows > 0) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            db.close();
        }
    }
    public ArrayList<FunkoPOPItem> searchFunkoPOPItemsByQuery(String query) {
        ArrayList<FunkoPOPItem> searchResults = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        try {
        String[] projection = {
                FunkoPOPContract.FunkoPOPEntry._ID,
                FunkoPOPContract.FunkoPOPEntry.COLUMN_POP_NAME,
                FunkoPOPContract.FunkoPOPEntry.COLUMN_POP_NUMBER,
                FunkoPOPContract.FunkoPOPEntry.COLUMN_POP_TYPE,
                FunkoPOPContract.FunkoPOPEntry.COLUMN_FANDOM,
                FunkoPOPContract.FunkoPOPEntry.COLUMN_ON,
                FunkoPOPContract.FunkoPOPEntry.COLUMN_ULTIMATE,
                FunkoPOPContract.FunkoPOPEntry.COLUMN_PRICE
        };

        String selection = FunkoPOPContract.FunkoPOPEntry.COLUMN_POP_NAME + " LIKE ?";
        String[] selectionArgs = {"%" + query + "%"};

            Cursor cursor = db.query(
                    FunkoPOPContract.FunkoPOPEntry.TABLE_NAME,
                    projection,
                    selection,
                    selectionArgs,
                    null,
                    null,
                    null
            );
            if (cursor != null) {
                while (cursor.moveToNext()) {
                    FunkoPOPItem item = new FunkoPOPItem(
                            cursor.getInt(cursor.getColumnIndex(FunkoPOPContract.FunkoPOPEntry._ID)),
                            cursor.getString(cursor.getColumnIndex(FunkoPOPContract.FunkoPOPEntry.COLUMN_POP_NAME)),
                            cursor.getInt(cursor.getColumnIndex(FunkoPOPContract.FunkoPOPEntry.COLUMN_POP_NUMBER)),
                            cursor.getString(cursor.getColumnIndex(FunkoPOPContract.FunkoPOPEntry.COLUMN_POP_TYPE)),
                            cursor.getString(cursor.getColumnIndex(FunkoPOPContract.FunkoPOPEntry.COLUMN_FANDOM)),
                            cursor.getInt(cursor.getColumnIndex(FunkoPOPContract.FunkoPOPEntry.COLUMN_ON)) > 0,
                            cursor.getString(cursor.getColumnIndex(FunkoPOPContract.FunkoPOPEntry.COLUMN_ULTIMATE)),
                            cursor.getDouble(cursor.getColumnIndex(FunkoPOPContract.FunkoPOPEntry.COLUMN_PRICE))
                    );
                    searchResults.add(item);
                }
                cursor.close();
            }
        } catch (Exception e) {
            Log.e("Database Query Error", e.toString());
            e.printStackTrace();
        }
        db.close();
        return searchResults;
    }

}
