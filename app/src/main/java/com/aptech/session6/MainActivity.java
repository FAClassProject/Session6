package com.aptech.session6;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try {
            SQLiteDatabase sqLiteDatabase = this.openOrCreateDatabase("aptech",MODE_PRIVATE, null);
            sqLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS AptechTable(Username VARCHAR, Password VARCHAR)");
            sqLiteDatabase.execSQL("INSERT INTO AptechTable VALUES('session6','Session6');");

            Cursor query = sqLiteDatabase.rawQuery("SELECT * FROM AptechTable", null);
            int userIndex = query.getColumnIndex("Username");
            int passwordIndex = query.getColumnIndex("Password");
            query.moveToFirst();
            while (query != null){
                Log.i("Username", "Username "+query.getString(userIndex));
                Log.e("Password", "password "+query.getString(passwordIndex));
                query.moveToNext();
            }
            sqLiteDatabase.close();

        }catch (Exception e){
            e.printStackTrace();

        }
    }

}