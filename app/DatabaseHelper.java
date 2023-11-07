import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "FunkoPOPDatabase";
    private static final int DATABASE_VERSION = 1;

    public static final String TABLE_NAME = "FunkoPOP";
    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_POP_NAME = "pop_name";
    public static final String COLUMN_POP_NUMBER = "pop_number";
    public static final String COLUMN_POP_TYPE = "pop_type";
    public static final String COLUMN_FANDOM = "fandom";
    public static final String COLUMN_ON = "on";
    public static final String COLUMN_ULTIMATE = "ultimate";
    public static final String COLUMN_PRICE = "price";

    // Database creation SQL statement
    private static final String DATABASE_CREATE = "CREATE TABLE " + TABLE_NAME + " (" +
            COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            COLUMN_POP_NAME + " TEXT, " +
            COLUMN_POP_NUMBER + " INTEGER, " +
            COLUMN_POP_TYPE + " TEXT, " +
            COLUMN_FANDOM + " TEXT, " +
            "`On` INTEGER, " + // Enclosing 'On' within backticks to avoid conflicts
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
        // Not needed for this example, but you should handle database upgrades properly.
    }
}
