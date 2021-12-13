package by.bsuir.dao;

import by.bsuir.dao.core.CrudRepository;
import by.bsuir.dao.exception.DAOException;
import by.bsuir.domain.entity.User;
import by.bsuir.domain.entity.UserStatus;

import java.util.List;

public interface UserRepository extends CrudRepository<User> {

    @Override
    User getEntityById(String id) throws DAOException;

    @Override
    boolean removeById(String id) throws DAOException;

    @Override
    boolean add(User user) throws DAOException;

    @Override
    boolean update(User user) throws DAOException;

    @Override
    List<User> getAll() throws DAOException;

    void updateUserPassword(String userId, String newPassword) throws DAOException;

    User getPatientByLoginAndPassword(String login, String password) throws DAOException;

    void updateUserStatus(String userId, UserStatus status) throws DAOException;
}
