package by.bsuir.domain.service.impl;

import by.bsuir.dao.UserRepository;
import by.bsuir.dao.exception.DAOException;
import by.bsuir.dao.factory.RepositoryFactory;
import by.bsuir.domain.entity.User;
import by.bsuir.domain.entity.UserStatus;
import by.bsuir.domain.service.UserService;
import by.bsuir.domain.service.exception.ServiceException;

import java.util.List;

public class UserServiceImpl implements UserService {

    private final UserRepository userRepository = RepositoryFactory.getInstance().getUserRepository();

    @Override
    public void addNewUser(User user) throws ServiceException {

//        final User user = new UserBuilderImpl()
//                .withLogin(login)
//                .withPassword(password)
//                .withName(name)
//                .withSurname(surname)
//                .withBirthDate(new Timestamp(birthDate.getTime() + 11000 * 1000))
//                .withPhone(phone)
//                .build();
        try {

            userRepository.add(user);
        } catch (DAOException e) {
            throw new ServiceException(e.getMessage());
        }
    }

    @Override
    public void updateUser(User user) throws ServiceException {
        try {
            userRepository.update(user);
        } catch (DAOException e) {
            throw new ServiceException(e.getMessage());
        }
    }

    @Override
    public void updateUserPassword(String userId, String curPassword,
                                   String newPassword, String confNewPass) throws ServiceException {

        try {
            User user = userRepository.getEntityById(userId);
            if (!user.getPassword().equals(curPassword)) {
                throw new ServiceException("Ваш текущий пароль неверен!");
            }
            userRepository.updateUserPassword(userId, newPassword);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public void deleteUser(String id) throws ServiceException {
        try {
            userRepository.removeById(id);
        } catch (DAOException e) {
            throw new ServiceException(e.getMessage());
        }
    }

    @Override
    public List<User> getAll() throws ServiceException {
        try {
            return userRepository.getAll();
        } catch (DAOException e) {
            throw new ServiceException(e.getMessage());
        }
    }

    @Override
    public User signIn(String login, String password) throws ServiceException {
        try {
            return userRepository.getPatientByLoginAndPassword(login, password);
//            if (user == null) {
//                throw new ServiceException("Wrong login or password!");
//            }
        } catch (DAOException e) {
            throw new ServiceException(e.getMessage());
        }
    }


    @Override
    public void updateUserStatus(String userId, UserStatus status) throws ServiceException {
        try {
            userRepository.updateUserStatus(userId, status);
        } catch (DAOException e) {
            throw new ServiceException(e.getMessage());
        }
    }
}
