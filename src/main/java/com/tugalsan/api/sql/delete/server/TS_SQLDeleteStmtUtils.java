package com.tugalsan.api.sql.delete.server;

import com.tugalsan.api.sql.conn.server.*;
import com.tugalsan.api.sql.sanitize.server.*;
import com.tugalsan.api.sql.update.server.*;
import com.tugalsan.api.union.client.TGS_UnionExcuse;

public class TS_SQLDeleteStmtUtils { 

    public static TGS_UnionExcuse<TS_SQLConnStmtUpdateResult> clear(TS_SQLConnAnchor anchor, CharSequence tableName) {
        TS_SQLSanitizeUtils.sanitize(tableName);
        return TS_SQLUpdateStmtUtils.update(anchor, "TRUNCATE ".concat(tableName.toString()));
    }
}
