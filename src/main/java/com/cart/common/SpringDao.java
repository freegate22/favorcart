package main.java.com.cart.common;

import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.List;

/**
 * Created by hshs on 2016. 2. 14..
 */
public class SpringDao {

    private DataSource dataSource;
    private JdbcTemplate jdbcTemplate;

    public List getNames() {
        return jdbcTemplate.queryForList("select * from mytest");
    }

    public DataSource getDataSource() {
        return dataSource;
    }

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

}
