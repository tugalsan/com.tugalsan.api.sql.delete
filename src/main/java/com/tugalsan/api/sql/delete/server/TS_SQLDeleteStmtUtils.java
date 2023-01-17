package com.tugalsan.api.sql.delete.server;

import com.tugalsan.api.sql.conn.server.*;
import com.tugalsan.api.sql.sanitize.server.*;
import com.tugalsan.api.sql.update.server.*;

public class TS_SQLDeleteStmtUtils { 

    public static TS_SQLConnStmtUpdateResult clear(TS_SQLConnAnchor anchor, CharSequence tableName) {
        TS_SQLSanitizeUtils.sanitize(tableName);
        return TS_SQLUpdateStmtUtils.update(anchor, "TRUNCATE ".concat(tableName.toString()));
    }
}
