package app.springData.services.interfaces;

import app.springData.domain.User;

public interface IUserService {
    Integer createUser(User user);
    User getUser(Long id);
    Integer updateUser(User user);
    Integer deleteUser (Long id);
    void createTableUser();
}