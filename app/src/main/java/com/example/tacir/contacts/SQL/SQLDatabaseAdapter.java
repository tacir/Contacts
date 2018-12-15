package com.example.tacir.contacts.SQL;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.tacir.contacts.Model.Contact;

public class SQLDatabaseAdapter {
    private static SQLHelper helper;
    private Context context;

    public SQLDatabaseAdapter(Context context) {
        this.context = context;
    }

    private SQLHelper getHelper() {
        if (helper == null)
            helper = new SQLHelper(context, SQLHelper.DB_NAME, null, SQLHelper.VERSION);
        return helper;
    }

    private SQLiteDatabase getDatabase() {
        return getHelper().getWritableDatabase();
    }

    public Contact getContactWithID(int contactID) {
        String[] columns = new String[]{
                SQLHelper.COLUMN_STREET,
                SQLHelper.COLUMN_EMAIL,
                SQLHelper.COLUMN_SURNAME,
                SQLHelper.COLUMN_CITY,
                SQLHelper.COLUMN_ID
        };
        String[] selectionArgs = new String[]{String.valueOf(contactID)};

        Cursor cursor = getDatabase().query(SQLHelper.TABLE_NAME, columns,
                SQLHelper.COLUMN_ID + " = ? ",
                selectionArgs, null, null, null);

        while (cursor.moveToNext()) {

            int id = cursor.getInt(cursor.getColumnIndex(SQLHelper.COLUMN_ID));
            String name = cursor.getString(cursor.getColumnIndex(SQLHelper.COLUMN_NAME));
            String surname = cursor.getString(cursor.getColumnIndex(SQLHelper.COLUMN_SURNAME));
            String number = cursor.getString(cursor.getColumnIndex(SQLHelper.COLUMN_NUMBER));
            String email = cursor.getString(cursor.getColumnIndex(SQLHelper.COLUMN_EMAIL));
            String street = cursor.getString(cursor.getColumnIndex(SQLHelper.COLUMN_STREET));
            String city = cursor.getString(cursor.getColumnIndex(SQLHelper.COLUMN_CITY));
            Contact contact = new Contact(city, street, email, id, number);
            contact.setName(name);
            contact.setSurname(surname);
            cursor.close();
            return contact;
        }
        return null;
    }

    public long insertContact(Contact contact) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(SQLHelper.COLUMN_CITY, contact.getCity());
        contentValues.put(SQLHelper.COLUMN_EMAIL, contact.getE_mail());
        contentValues.put(SQLHelper.COLUMN_NAME, contact.getName());
        contentValues.put(SQLHelper.COLUMN_IS_COMPLETED, contact.isIs_comleted());
        return getDatabase().insert(SQLHelper.TABLE_NAME, null, contentValues);
    }

    public void getContactWithId(int contactID) {
        String[] columns = new String[]{
                SQLHelper.COLUMN_ID,
                SQLHelper.COLUMN_NAME,
                SQLHelper.COLUMN_SURNAME,
                SQLHelper.COLUMN_CITY,
                SQLHelper.COLUMN_EMAIL,
                SQLHelper.COLUMN_STREET,
                SQLHelper.COLUMN_NUMBER
        };
        String selection = SQLHelper.COLUMN_IS_COMPLETED + "=1";
    }


    class SQLHelper extends SQLiteOpenHelper {
        public static final int VERSION = 1;
        public static final String DB_NAME = "database";
        public static final String TABLE_NAME = "contact";
        public static final String COLUMN_NAME = "name";
        public static final String COLUMN_ID = "id";
        public static final String COLUMN_IS_COMPLETED = "is_completed";
        public static final String COLUMN_CITY = "city";
        public static final String COLUMN_STREET = "streeet";
        public static final String COLUMN_EMAIL = "e-mail";
        public static final String COLUMN_SURNAME = "surname";
        public static final String COLUMN_NUMBER = "number";

        public SQLHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
            super(context, DB_NAME, null, VERSION);
        }


        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL("CREATE TABLE IF NOT EXISTS " + TABLE_NAME + " (" + COLUMN_CITY
                    + COLUMN_EMAIL + "VARCHAR(255), " + COLUMN_ID + "INTEGER PRIMARY KEY AUTOINCREMENT" + COLUMN_STREET +
                    "VARCHAR(255)," + COLUMN_NUMBER + "VARCHAR(255)" + COLUMN_SURNAME + "VARCHAR(255), " + COLUMN_NAME + "VARCHAR(255)," + COLUMN_IS_COMPLETED + "INTEGER (1));"
            );
        }

        @Override
        public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

        }
    }
}


