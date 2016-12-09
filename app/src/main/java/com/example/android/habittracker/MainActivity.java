package com.example.android.habittracker;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.example.android.habittracker.data.RunDbHelper;
import com.example.android.habittracker.data.RunningContract;

import static com.example.android.habittracker.data.RunningContract.RunningEntry.COLUMN_DAY_RUN;
import static com.example.android.habittracker.data.RunningContract.RunningEntry.COLUMN_DISTANCE_RUN;
import static com.example.android.habittracker.data.RunningContract.RunningEntry.COLUMN_DURATION_RUN;
import static com.example.android.habittracker.data.RunningContract.RunningEntry.COLUMN_PLACE_RUN;
import static com.example.android.habittracker.data.RunningContract.RunningEntry.COLUMN_TIME_RUN;
import static com.example.android.habittracker.data.RunningContract.RunningEntry.TABLE_NAME;

public class MainActivity extends AppCompatActivity {
    SQLiteDatabase db;
    RunDbHelper dbHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dbHelper = new RunDbHelper(this);
    }
    //methods of the project

    /**
     * inserts a new Running entry to the data base
     * @param day day of the week the running took place
     * @param duration duration of the running
     * @param time start time only the hour i.e. 1 to 24
     * @param distance distance traveled by the runner
     * @param place short description of the place where the running took place
     */
    public void insertRunEntry(int day, int duration, int time, int distance, String place){
        // get data base if exists if not create a new one
        db = dbHelper.getWritableDatabase();
        // create Content value to hold the parameters
        ContentValues values = new ContentValues();
        values.put(COLUMN_DAY_RUN,day);
        values.put(COLUMN_DURATION_RUN,duration);
        values.put(COLUMN_TIME_RUN,time);
        values.put(COLUMN_DISTANCE_RUN,distance);
        values.put(COLUMN_PLACE_RUN,place);
        long newItemId = db.insert(TABLE_NAME,null,values);
        if(newItemId < 0){
            Toast.makeText(this,R.string.could_not_insert,Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(this,R.string.successful_insertion,Toast.LENGTH_SHORT).show();
        }

    }

    /**
     * get running entries that were done between the hours given
     * @param h1
     * @param h2
     * @return
     */
    public Cursor getRunsBetweenHours(int h1, int h2){

        db = dbHelper.getReadableDatabase();
        //projection for the query ,all the columns
        String[] projection = {
            COLUMN_DAY_RUN,
            COLUMN_DISTANCE_RUN,
            COLUMN_DURATION_RUN,
            COLUMN_PLACE_RUN,
            COLUMN_TIME_RUN
        };
        // where clause
        String whereClause = COLUMN_TIME_RUN + " >= ? AND " + COLUMN_TIME_RUN + " <= ?";
        String[] whereargs = {
                Integer.toString(h1),
                Integer.toString(h2)
        };
        //perform query and return cursor
        return db.query(TABLE_NAME,projection,whereClause,whereargs,null, null, null);
    }
}
