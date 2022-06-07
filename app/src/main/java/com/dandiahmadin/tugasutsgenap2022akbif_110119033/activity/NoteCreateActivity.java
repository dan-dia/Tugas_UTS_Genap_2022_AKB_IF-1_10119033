package com.dandiahmadin.tugasutsgenap2022akbif_110119033.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.dandiahmadin.tugasutsgenap2022akbif_110119033.MainActivity;
import com.dandiahmadin.tugasutsgenap2022akbif_110119033.R;
import com.dandiahmadin.tugasutsgenap2022akbif_110119033.database.Database;
import com.dandiahmadin.tugasutsgenap2022akbif_110119033.fragment.HomeFragment;
import com.dandiahmadin.tugasutsgenap2022akbif_110119033.fragment.NoteFragment;
import com.dandiahmadin.tugasutsgenap2022akbif_110119033.model.NoteModel;
//NIM 10119033
//Nama Dandi Ahmadin
//Kelas IF-1
public class NoteCreateActivity extends AppCompatActivity {

    protected Cursor cursor;
    Database database;
    Button button_save;
    EditText title, category, notes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note_create);
        database = new Database(this);
        title = findViewById(R.id.et_title);
        category = findViewById(R.id.et_category);
        notes = findViewById(R.id.et_note);
        button_save = findViewById(R.id.btn_add);
        button_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SQLiteDatabase db = database.getWritableDatabase();
                database.insertToTable(
                        db,
                        title.getText().toString(),
                        category.getText().toString(),
                        notes.getText().toString() );
                Toast.makeText(NoteCreateActivity.this, "Data Tersimpan", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(NoteCreateActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}