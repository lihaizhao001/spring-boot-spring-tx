package me.lhz.dao.jdbctemplate;

import me.lhz.bo.TTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TTestJdbcTemplateDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<TTest> list() {
        return jdbcTemplate.query("select name from t_test", (rs, rowNum) -> {
            TTest tTest = new TTest();
            tTest.setName(rs.getString("name"));
            return tTest;
        });
    }

    public void add(String name) {
        jdbcTemplate.update("insert into t_test values(?)",name);
    }
}
