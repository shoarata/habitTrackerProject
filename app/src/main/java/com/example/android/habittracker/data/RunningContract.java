package com.example.android.habittracker.data;

import android.provider.BaseColumns;

import static android.R.attr.id;

/**
 * Created by arata on 08/12/2016.
 */

public class RunningContract {
    public static class  RunningEntry implements BaseColumns{
        public final static String TABLE_NAME = "runnings";

        public final static String _ID = BaseColumns._ID;
        // day of the week that you ran
        public final static String COLUMN_DAY_RUN = "day";
        //time when started running only the hour i.e. 1 to 24
        public final static String COLUMN_TIME_RUN = "time";
        // how much time it took you
        public final static String COLUMN_DURATION_RUN = "duration";
        // distance traveled by the runner
        public final static String COLUMN_DISTANCE_RUN = "distance";
        // short description of the place where the training took place
        public final static String COLUMN_PLACE_RUN = "place";

        //day of the week integer
        public static final int WEEK_DAY_MONDAY = 1;
        public static final int WEEK_DAY_TUESDAY = 2;
        public static final int WEEK_DAY_WEDNESDAY = 3;
        public static final int WEEK_DAY_THURSDAY = 4;
        public static final int WEEK_DAY_FRIDAY = 5;
        public static final int WEEK_DAY_SATURDAY = 6;
        public static final int WEEK_DAY_SUNDAY = 7;
    }
}
