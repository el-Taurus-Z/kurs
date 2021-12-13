package by.bsuir.dao.core;


import by.bsuir.dao.core.impl.JdbcTemplate;

/**
 * Base class with protected reference on {@code JdbcTemplate}.
 * All repository must extend of initialRepository
 */
public class InitializerRepository {

    protected JdbcOperations jdbcTemplate;

    public InitializerRepository() {
        this.jdbcTemplate = new JdbcTemplate();
    }
}
