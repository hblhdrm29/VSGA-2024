package com.habi.vsga_2024;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class DBHelper extends SQLiteOpenHelper {

    private static final String CREATE_TABLE = "CREATE TABLE kontak (id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT, nama TEXT, alamat TEXT);";

    public DBHelper(@Nullable Context context) {
        super(context, "data.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS kontak");
        onCreate(db);
    }

    public long tambahKontak(String nama, String alamat) {
        ContentValues values = new ContentValues();
        values.put("nama", nama);
        values.put("alamat", alamat);
        SQLiteDatabase db = getWritableDatabase();
        long id = db.insert("kontak", null, values);
        db.close();
        return id;
    }

    public ArrayList<Kontak> getData(){
        ArrayList<Kontak> result = new ArrayList<>();

        String query = "SELECT * FROM kontak";
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery(query, null);
        while (cursor.moveToNext()){
            String nama = cursor.getString(1);
            String alamat = cursor.getString(2);
            Kontak kontak = new Kontak(nama, alamat);
            result.add(kontak);
        }

        return result;
    }


}