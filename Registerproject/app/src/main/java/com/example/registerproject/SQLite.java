package com.example.registerproject;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class SQLite extends SQLiteOpenHelper {

    private Context context;
    private static final String DATABASE_NAME = "login.db";
    private static final String TABLE_NAME = "login_library";
    private static final String COLUMN_ID = "id";
    private static final String COLUMN_FIRST_NAME = "first_name";
    private static final String COLUMN_SECOND_NAME = "second_name";
    private static final String COLUMN_EMAIL = "email";
    private static final String COLUMN_PASSWORD = "password";



    public SQLite(@Nullable Context context) {
        super(context, DATABASE_NAME, null, 2);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE " + TABLE_NAME +
                " (" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_FIRST_NAME + " TEXT, " +
                COLUMN_SECOND_NAME + " TEXT, " +
                COLUMN_EMAIL + " TEXT unique, " +
                COLUMN_PASSWORD + " TEXT);";

        db.execSQL(query);


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP  TABLE IF  EXISTS " + TABLE_NAME);
        onCreate(db);

    }

    void register(String name, String lastname, String email, String password) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(COLUMN_FIRST_NAME, name);
        cv.put(COLUMN_SECOND_NAME, lastname);
        cv.put(COLUMN_EMAIL, email);
        cv.put(COLUMN_PASSWORD, password);
        long result = db.insert(TABLE_NAME, null , cv);
        if (result == -1){
            Toast.makeText(context, "This email is already registered", Toast.LENGTH_SHORT).show();
        }
        else {
            Toast.makeText(context, "Successful Register", Toast.LENGTH_SHORT).show();
        }
    }
    public void deleteAll()
    {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_NAME,null,null);
        db.execSQL("delete from "+ TABLE_NAME);
        db.close();
    }



    public Boolean checkemailandpassword (String email, String password){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("Select * from login_library where email =? and password =?",new String[]{email,password} );
        return cursor.getCount() > 0;
    }

    public Boolean checkmail (String email){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("Select * from login_library where email =?",new String[]{email} );
        return cursor.getCount() > 0;
    }
    public Boolean checkpass (String password){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("Select * from login_library where password =?",new String[]{password} );
        return cursor.getCount() > 0;
    }

}
