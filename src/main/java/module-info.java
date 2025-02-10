module com.tugalsan.api.sql.delete {
    requires java.sql;
    requires com.tugalsan.api.function;
    
    requires com.tugalsan.api.log;
    requires com.tugalsan.api.sql.sanitize;
    requires com.tugalsan.api.sql.update;
    requires com.tugalsan.api.sql.where;
    requires com.tugalsan.api.sql.conn;
    exports com.tugalsan.api.sql.delete.server;
}
