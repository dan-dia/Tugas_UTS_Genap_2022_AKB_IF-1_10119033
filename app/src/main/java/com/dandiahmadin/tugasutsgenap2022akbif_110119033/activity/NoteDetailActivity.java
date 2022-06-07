package com.dandiahmadin.tugasutsgenap2022akbif_110119033.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.TextView;

import com.dandiahmadin.tugasutsgenap2022akbif_110119033.R;
import com.dandiahmadin.tugasutsgenap2022akbif_110119033.database.Database;
//NIM 10119033
//Nama Dandi Ahmadin
//Kelas IF-1
public class NoteDetailActivity extends AppCompatActivity {

    private Database database;
    private TextView title, category, notes;
    private String intentTitle;
    protected Cursor cursor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note_detail);
        database = new Database(this);
        title = findViewById(R.id.et_title);
        category = findViewById(R.id.et_category);
        notes = findViewById(R.id.et_note);
        intentTitle = getIntent().getStringExtra("title").toString();

        SQLiteDatabase db = database.getReadableDatabase();
        cursor = db.rawQuery(database.selectByTitle(db, intentTitle), null);
        cursor.moveToFirst();
        if (cursor.getCount() > 0) {
            cursor.moveToPosition(0);
            title.setText(cursor.getString(0).toString());
            category.setText(cursor.getString(1).toString());
            notes.setText(cursor.getString(2).toString());
        }
    }
}