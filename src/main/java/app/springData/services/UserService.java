package app.springData.services;

import app.springData.domain.User;
import app.springData.services.interfaces.IUserService;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService {

    @Override
    public Integer createUser(User user) {
        return 0;
    }

    @Override
    public User getUser(Long id) {
        return null;
    }

    @Override
    public Integer updateUser(User user, Long id) {
        return 0;
    }

    @Override
    public Integer deleteUser(Long id) {
        return 0;
    }
}
