package com.tugalsan.api.sql.delete.server;


import com.tugalsan.api.callable.client.TGS_CallableType1Void;
import com.tugalsan.api.sql.conn.server.*;
import com.tugalsan.api.sql.where.server.*;

public class TS_SQLDelete {

    public TS_SQLDelete(TS_SQLConnAnchor anchor, CharSequence tableName) {
        executor = new TS_SQLDeleteExecutor(anchor, tableName);
    }
    private final TS_SQLDeleteExecutor executor;

    public TS_SQLConnStmtUpdateResult whereGroupAnd(TGS_CallableType1Void<TS_SQLWhereGroups> groups) {
        executor.where = TS_SQLWhereUtils.where();
        executor.where.groupsAnd(groups);
        return executor.run();
    }

    public TS_SQLConnStmtUpdateResult whereGroupOr(TGS_CallableType1Void<TS_SQLWhereGroups> groups) {
        executor.where = TS_SQLWhereUtils.where();
        executor.where.groupsOr(groups);
        return executor.run();
    }

    public TS_SQLConnStmtUpdateResult whereConditionAnd(TGS_CallableType1Void<TS_SQLWhereConditions> conditions) {
        return whereGroupAnd(where -> where.conditionsAnd(conditions));
    }

    public TS_SQLConnStmtUpdateResult whereConditionOr(TGS_CallableType1Void<TS_SQLWhereConditions> conditions) {
        return whereGroupOr(where -> where.conditionsOr(conditions));
    }

    public TS_SQLConnStmtUpdateResult whereFirstColumnAsId(long id) {
        return whereConditionAnd(conditions -> {
            conditions.lngEq(
                    TS_SQLConnColUtils.names(executor.anchor, executor.tableName).get(0),
                    id
            );
        });
    }

    public TS_SQLConnStmtUpdateResult whereConditionNone() {
        return executor.run();
    }
}
