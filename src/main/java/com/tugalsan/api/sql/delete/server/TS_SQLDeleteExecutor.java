package com.tugalsan.api.sql.delete.server;

import com.tugalsan.api.function.client.maythrowexceptions.unchecked.TGS_FuncMTUUtils;
import com.tugalsan.api.log.server.*;
import com.tugalsan.api.sql.conn.server.*;
import com.tugalsan.api.sql.update.server.*;
import com.tugalsan.api.sql.where.server.*;


public class TS_SQLDeleteExecutor {

    final private static TS_Log d = TS_Log.of(TS_SQLDeleteExecutor.class);

    public TS_SQLDeleteExecutor(TS_SQLConnAnchor anchor, CharSequence tableName) {
        this.anchor = anchor;
        this.tableName = tableName;
    }
    final public TS_SQLConnAnchor anchor;
    final public CharSequence tableName;
    public TS_SQLWhere where = null;

    @Override
    public String toString() {
        var sb = new StringBuilder("DELETE FROM ").append(tableName);
        if (where == null) {
            TGS_FuncMTUUtils.thrw(d.className, "toString", "where cannot be null");
        }
        sb.append(" ").append(where);
        return sb.toString();
    }

    public TS_SQLConnStmtUpdateResult run() {
        d.ci("run", toString());
        return TS_SQLUpdateStmtUtils.update(anchor, toString(), fillStmt -> {
            where.fill(fillStmt, 0);
        });
    }
}
