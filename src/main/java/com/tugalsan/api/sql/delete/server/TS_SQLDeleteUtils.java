package com.tugalsan.api.sql.delete.server;

import com.tugalsan.api.sql.conn.server.*;

public class TS_SQLDeleteUtils {

    public static TS_SQLDelete delete(TS_SQLConnAnchor anchor, CharSequence tableName) {
        return new TS_SQLDelete(anchor, tableName);
    }

//    public static void test() {
//        TS_SQLDeleteUtils
//                .delete(null, "tn")
//                .whereConditionAnd(conditions -> conditions.lngEq("", 0));
//    }
}
