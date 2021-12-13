package by.bsuir.dao.core.pool;

import by.bsuir.dao.core.pool.connection.ProxyConnection;

public interface ConnectionPool {

    ProxyConnection getConnection();

    void putBackConnection(ProxyConnection connection);

    void destroyPool();
}

