package com.dandiahmadin.tugasutsgenap2022akbif_110119033.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.dandiahmadin.tugasutsgenap2022akbif_110119033.R;
import com.dandiahmadin.tugasutsgenap2022akbif_110119033.database.Database;
//NIM 10119033
//Nama Dandi Ahmadin
//Kelas IF-1
public class NoteEditActivity extends AppCompatActivity {

    protected Cursor cursor;
    private Database database;
    private Button button_save;
    private EditText title, category, notes;
    private String intentTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note_edit);
        database = new Database(this);
        title = findViewById(R.id.et_title);
        category = findViewById(R.id.et_category);
        notes = findViewById(R.id.et_note);
        button_save = findViewById(R.id.btn_add);
        intentTitle = getIntent().getStringExtra("title");

        SQLiteDatabase db = database.getReadableDatabase();
        cursor = db.rawQuery(database.selectByTitle(db, intentTitle), null);
        cursor.moveToFirst();
        if (cursor.getCount() > 0) {
            cursor.moveToPosition(0);
            title.setText(cursor.getString(0).toString());
            category.setText(cursor.getString(1).toString());
            notes.setText(cursor.getString(2).toString());
        }

        button_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SQLiteDatabase db = database.getWritableDatabase();
                database.updateTable(db, title.getText().toString(), category.getText().toString(), notes.getText().toString(), intentTitle);
                Toast.makeText(NoteEditActivity.this, "Data has been updated", Toast.LENGTH_SHORT).show();
                finish();
            }
        });
    }
}