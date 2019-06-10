package me.lhz.dao.rdbmsoperstion;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.object.SqlUpdate;
import org.springframework.stereotype.Repository;

import java.sql.Types;

@Repository
public  class TTestRdbmsOperationSqlUpdate extends SqlUpdate {
    public TTestRdbmsOperationSqlUpdate(JdbcTemplate jdbcTemplate) {
        super.setJdbcTemplate(jdbcTemplate);
        super.setSql("insert into t_test values(?)");
        super.declareParameter(new SqlParameter(Types.VARCHAR));
        compile();
    }
    public void add(String name){
        update(name);
    }
}
