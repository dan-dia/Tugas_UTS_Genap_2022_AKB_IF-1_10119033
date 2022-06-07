package com.dandiahmadin.tugasutsgenap2022akbif_110119033.fragment;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.dandiahmadin.tugasutsgenap2022akbif_110119033.MainActivity;
import com.dandiahmadin.tugasutsgenap2022akbif_110119033.R;
import com.dandiahmadin.tugasutsgenap2022akbif_110119033.activity.NoteCreateActivity;
import com.dandiahmadin.tugasutsgenap2022akbif_110119033.activity.NoteDetailActivity;
import com.dandiahmadin.tugasutsgenap2022akbif_110119033.activity.NoteEditActivity;
import com.dandiahmadin.tugasutsgenap2022akbif_110119033.database.Database;
import com.dandiahmadin.tugasutsgenap2022akbif_110119033.model.NoteModel;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.Date;
//NIM 10119033
//Nama Dandi Ahmadin
//Kelas IF-1
public class NoteFragment extends Fragment {

    private ListView listView;
    private String[] listNote;
    private Menu menu;
    protected Cursor cursor;
    private Database database;

    public NoteFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_note, container, false);
        FloatingActionButton floatingActionButton = view.findViewById(R.id.fab);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), NoteCreateActivity.class);
                startActivity(intent);
            }
        });

        database = new Database(getContext());
        refreshList(view);

        return view;
    }

    public void refreshList(View view) {
        SQLiteDatabase db = database.getReadableDatabase();
        cursor = db.rawQuery("SELECT * FROM note", null);
        listNote = new String[cursor.getCount()];
        cursor.moveToFirst();
        for (int i = 0; i < cursor.getCount(); i++) {
            listNote[i] = cursor.getString(0).toString();
            cursor.moveToPosition(i);
        }

        listView = view.findViewById(R.id.container_listview);
        listView.setAdapter(new ArrayAdapter<String>(this.getContext(), android.R.layout.simple_list_item_1, listNote));
        listView.setSelected(true);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                final String selection = listNote[i];
                final CharSequence[] dialogItem = {
                        "Detail Notes",
                        "Edit Notes",
                        "Delete Notes"
                };

                AlertDialog.Builder alertDialog = new AlertDialog.Builder(getContext());
                alertDialog.setTitle("Options");
                alertDialog.setItems(dialogItem, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        switch (i) {
                            case 0:
                                Intent intent_detail = new Intent(getContext(), NoteDetailActivity.class);
                                intent_detail.putExtra("title", selection);
                                startActivity(intent_detail);
                                break;
                            case 1:
                                Intent intent_edit = new Intent(getContext(), NoteEditActivity.class);
                                intent_edit.putExtra("title", selection);
                                startActivity(intent_edit);
                                break;
                            case 2:
                                SQLiteDatabase db = database.getWritableDatabase();
                                database.deleteByTitle(db, selection);
                                refreshList(getView());
                                break;
                        }
                    }
                });
                alertDialog.create().show();
            }
        });
        ((ArrayAdapter) listView.getAdapter()).notifyDataSetInvalidated();
    }
}