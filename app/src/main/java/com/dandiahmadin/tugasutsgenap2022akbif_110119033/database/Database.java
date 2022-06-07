package com.dandiahmadin.tugasutsgenap2022akbif_110119033.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;

import androidx.annotation.Nullable;

//NIM 10119033
//Nama Dandi Ahmadin
//Kelas IF-1

public class Database extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "Note.db";

    protected final String SQL_CREATE_ENTRIES =
            "CREATE TABLE " + NoteEntry.TABLE_NAME + " ("
                    + NoteEntry._ID + " INTEGER PRIMARY KEY,"
                    + NoteEntry.COLUMN_NAME_TITLE + " TEXT,"
                    + NoteEntry.COLUMN_NAME_CATEGORY + " TEXT,"
                    + NoteEntry.COLUMN_NAME_NOTE + " TEXT"
                    + ");";

    protected final String SQL_DELETE_ENTRIES = "DROP TABLE IF EXISTS " + NoteEntry.TABLE_NAME + ";";
    protected final String SQL_SELECT_ALL_NOTE = "SELECT * FROM " + NoteEntry.TABLE_NAME;
    protected final String SQL_DELETE_BY_TITLE = "DELETE FROM " + NoteEntry.TABLE_NAME
            + " WHERE "
            + NoteEntry.COLUMN_NAME_TITLE
            + " = ''";
    protected final String SQL_SELECT_BY_TITLE = "SELECT * FROM " + NoteEntry.TABLE_NAME
            + " WHERE "
            + NoteEntry.COLUMN_NAME_TITLE
            + " = '";
    protected final String SQL_INSERT = "INSERT INTO " + NoteEntry.TABLE_NAME + "("
            + NoteEntry.COLUMN_NAME_TITLE + ", " + NoteEntry.COLUMN_NAME_CATEGORY + ", "
            + NoteEntry.COLUMN_NAME_NOTE + ") "
            + "VALUES ";


    public Database(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public static class NoteEntry implements BaseColumns {
        public static final String TABLE_NAME = "note";
        public static final String COLUMN_NAME_TITLE = "title";
        public static final String COLUMN_NAME_CATEGORY = "category";
        public static final String COLUMN_NAME_NOTE = "notes";
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_ENTRIES);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(SQL_DELETE_ENTRIES);
        onCreate(db);
    }

    public String selectAll() {
        return SQL_SELECT_ALL_NOTE;
    }

    public void deleteByTitle(SQLiteDatabase db, String title) {
        db.execSQL("DELETE FROM " + NoteEntry.TABLE_NAME
                + " WHERE "
                + NoteEntry.COLUMN_NAME_TITLE
                + "='" + title + "'");
    }

    public String selectByTitle(SQLiteDatabase db, String title) {
        return SQL_SELECT_BY_TITLE + title + "''";
    }

    public void insertToTable(SQLiteDatabase db, String title, String category, String notes) {
        db.execSQL("INSERT INTO " + NoteEntry.TABLE_NAME
                + "("
                + NoteEntry.COLUMN_NAME_TITLE + ", "
                + NoteEntry.COLUMN_NAME_CATEGORY + ", "
                + NoteEntry.COLUMN_NAME_NOTE
                + ") VALUES "
                + "( '" + title + "', '" + category + "', '" + notes + "')");
    }
    public void updateTable(SQLiteDatabase db, String title, String category, String notes, String intent) {
        db.execSQL(
                "UPDATE " + NoteEntry.TABLE_NAME
                + " SET "
                + NoteEntry.COLUMN_NAME_TITLE + "='" + title + "'"
                + NoteEntry.COLUMN_NAME_CATEGORY + "='" + category + "'"
                + NoteEntry.COLUMN_NAME_NOTE + "='" + notes + "'"
                + " WHERE "
                + NoteEntry.COLUMN_NAME_TITLE + "='" + intent +"'"
                );
    }
}
