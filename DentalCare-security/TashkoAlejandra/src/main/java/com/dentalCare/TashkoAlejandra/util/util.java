package com.dentalCare.TashkoAlejandra.util;

import java.sql.Timestamp;
import java.util.Date;

public class util {

    public static Timestamp dateToTimestamp(Date date){
        Timestamp timestamp = new Timestamp(date.getTime());
        return timestamp;

    }
}

