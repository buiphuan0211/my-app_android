package com.example.my_app.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.my_app.DTO.User;

public class DBHelper extends SQLiteOpenHelper {
    public static String DBNAME = "SinhVien.db";

    public DBHelper(Context context) {
        super(context, "SinhVien.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase MyDB) {
        MyDB.execSQL("CREATE TABLE IF NOT EXISTS sinhviens(email VARCHAR(50) PRIMARY KEY,name VARCHAR(50), mobieNumber VARCHCAR(10),password VARCHAR(50) )");

    }

    @Override
    public void onUpgrade(SQLiteDatabase MyDB, int i, int i1) {
        MyDB.execSQL("DROP TABLE IF EXISTS sinhviens ");
    }

    public boolean insertData(String email, String name, String mobieNumber, String password) {
        SQLiteDatabase MyDB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("email", email);
        contentValues.put("name", name);
        contentValues.put("mobieNumber", mobieNumber);
        contentValues.put("password", password);
        long result = MyDB.insert("sinhviens", null, contentValues);
        if (result == -1) return false;
        else return true;
    }

    public Boolean checkEmail(String email) {
        SQLiteDatabase MyDB = this.getWritableDatabase();
        Cursor cursor = MyDB.rawQuery("SELECT * FROM sinhviens WHERE email =?", new String[]{email});
        if (cursor.getCount() > 0)
            return true;
        else
            return false;
    }

    public Boolean checkEmailPassword(String email, String password) {
        SQLiteDatabase MyDB = this.getWritableDatabase();
        Cursor cursor = MyDB.rawQuery("SELECT * FROM sinhviens WHERE email = ? and password =?", new String[]{email, password});
        if (cursor.getCount() > 0)
            return true;
        else
            return false;
    }
    public void updateData(String email, String name, String mobieNumber, String password) {
        SQLiteDatabase MyDB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("name", name);
        contentValues.put("mobieNumber", mobieNumber);
        contentValues.put("password", password);
        MyDB.update("sinhviens", contentValues, "email=?", new String[]{email});
    }

    public void delete(String email) {
        SQLiteDatabase MyDB = this.getWritableDatabase();
        MyDB.delete("sinhviens", "email=?", new String[]{email});
        MyDB.close();
    }

    public Cursor getSinhVien(){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery("SELECT * FROM sinhviens ", null);
        return  c;
    }

}
