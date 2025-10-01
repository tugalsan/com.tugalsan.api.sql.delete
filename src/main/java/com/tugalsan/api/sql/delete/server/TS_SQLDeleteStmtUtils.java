package com.tugalsan.api.sql.delete.server;

import module com.tugalsan.api.sql.conn;
import module com.tugalsan.api.sql.sanitize;
import module com.tugalsan.api.sql.update;

public class TS_SQLDeleteStmtUtils { 

    public static TS_SQLConnStmtUpdateResult clear(TS_SQLConnAnchor anchor, CharSequence tableName) {
        TS_SQLSanitizeUtils.sanitize(tableName);
        return TS_SQLUpdateStmtUtils.update(anchor, "TRUNCATE ".concat(tableName.toString()));
    }
}
