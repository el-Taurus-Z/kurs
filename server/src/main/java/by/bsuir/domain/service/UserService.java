package by.bsuir.domain.service;

import by.bsuir.domain.entity.User;
import by.bsuir.domain.entity.UserStatus;
import by.bsuir.domain.service.exception.ServiceException;

import java.util.List;

public interface UserService {

    void addNewUser(User user) throws ServiceException;

    void updateUser(User user) throws ServiceException;

    void updateUserPassword(String userId, String curPassword,
                            String newPassword, String confNewPass) throws ServiceException;

    void updateUserStatus(String userId, UserStatus status) throws ServiceException;

    void deleteUser(String id) throws ServiceException;

    List<User> getAll() throws ServiceException;

    User signIn(String login, String password) throws ServiceException;

}
