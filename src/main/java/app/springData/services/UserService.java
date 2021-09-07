package app.springData.services;

import app.springData.domain.User;
import app.springData.services.interfaces.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public UserService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void  createTableUser(){
        jdbcTemplate.execute("DROP TABLE IF EXISTS Users CASCADE");
        jdbcTemplate.execute("CREATE TABLE Users(Id INTEGER, Email VARCHAR (30), Password VARCHAR (30))");
    }

    @Override
    public Integer createUser(User user) {
        String query = "INSERT INTO Users Values (" + user.getId() + ",'" + user.getEmail() + "','" + user.getPassword() + "')";
        int result = jdbcTemplate.update(query);
        return result;
    }

    @Override
    public User getUser(Long id) {
        return null;
    }

    @Override
    public Integer updateUser(User user) {
        return null;
    }

    @Override
    public Integer deleteUser(Long id) {
        return null;
    }
}
