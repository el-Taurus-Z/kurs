package by.bsuir.dao.core;




import by.bsuir.dao.core.pool.connection.ConnectionWrapper;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public interface PreparedStatementCreator {

    PreparedStatement createPreparedStatement(ConnectionWrapper connectionWrapper) throws SQLException;

}
