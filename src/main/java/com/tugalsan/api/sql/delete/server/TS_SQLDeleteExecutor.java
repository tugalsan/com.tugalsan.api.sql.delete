package com.tugalsan.api.sql.delete.server;

import com.tugalsan.api.log.server.*;
import com.tugalsan.api.sql.conn.server.*;
import com.tugalsan.api.sql.update.server.*;
import com.tugalsan.api.sql.where.server.*;
import com.tugalsan.api.union.client.TGS_UnionExcuse;

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
            throw new IllegalArgumentException(d.className + " -> toString  -> where cannot be null");
        }
        sb.append(" ").append(where);
        return sb.toString();
    }

    public TGS_UnionExcuse<TS_SQLConnStmtUpdateResult> run() {
        d.ci("run", toString());
        var wrap = new Object() {
            TGS_UnionExcuse<Integer> u_fill;
        };
        var u_update =  TS_SQLUpdateStmtUtils.update(anchor, toString(), fillStmt -> {
            wrap.u_fill = where.fill(fillStmt, 0);
        });
        if (wrap.u_fill != null && wrap.u_fill.isExcuse()){
            return wrap.u_fill.toExcuse();
        }
        return u_update;
    }
}
