package com.bignerdranch.android.triplogger.database;

/**
 * Created by harpreet multani on 31/10/2016.
 */
public class TripDbSchema {

    public static final class TripTable {
        public static final String NAME = "trips";

        public static final class Cols {
            public static final String UUID = "uuid";
            public static final String TITLE = "title";
            public static final String DATE = "date";
            public static final String DESTINATION = "destination";
            public static final String TRIPTYPE = "trip_type";
            public static final String DURATION = "duration";
            public static final String COMMENT = "comment";


        }
    }
}
