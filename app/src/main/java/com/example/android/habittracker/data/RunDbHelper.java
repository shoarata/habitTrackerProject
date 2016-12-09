package com.example.android.habittracker.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.android.habittracker.data.RunningContract.RunningEntry;

/**
 * Created by arata on 08/12/2016.
 */

public class RunDbHelper extends SQLiteOpenHelper{
    private final static String DATABASE_NAME = "runs.db";
    private final static int DATABASE_VERSION = 1;


    public RunDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    /**
     * create a new data base table
     * @param db
     */
    @Override
    public void onCreate(SQLiteDatabase db) {
        String  SQL_CREATE_RUNNING_TABLE = "CREATE TABLE " + RunningEntry.TABLE_NAME+
                "( "+
                RunningEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                RunningEntry.COLUMN_DAY_RUN + " INTEGER NOT NULL, " +
                RunningEntry.COLUMN_DURATION_RUN + " INTEGER NOT NULL DEFAULT 0," +
                RunningEntry.COLUMN_DISTANCE_RUN + " INTEGER DEFAULT 0" +
                RunningEntry.COLUMN_TIME_RUN + " INTEGER NOT NULL" +
                RunningEntry.COLUMN_PLACE_RUN + " TEXT);";


        db.execSQL(SQL_CREATE_RUNNING_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
