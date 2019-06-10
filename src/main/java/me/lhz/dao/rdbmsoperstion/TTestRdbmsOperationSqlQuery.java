package me.lhz.dao.rdbmsoperstion;

import me.lhz.bo.TTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.object.SqlQuery;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class TTestRdbmsOperationSqlQuery extends SqlQuery<TTest> {

    public TTestRdbmsOperationSqlQuery(JdbcTemplate jdbcTemplate) {
        super.setJdbcTemplate(jdbcTemplate);
        super.setSql("select * from t_test");
        compile();
    }

    @Override
    protected RowMapper<TTest> newRowMapper(Object[] parameters, Map<?, ?> context) {
        return  (rs, rowNum) -> {
            TTest tTest = new TTest();
            tTest.setName(rs.getString("name"));
            return tTest;
        };
    }

    public List<TTest> list() {
        return execute();
    }
}
