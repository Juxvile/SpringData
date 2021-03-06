package app.springData.controllers;

import app.springData.domain.Todo;
import app.springData.domain.User;
import app.springData.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping(path = "/user")
    public ResponseEntity<User> createUser(@RequestBody User user){
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @PostMapping(path = "/todo")
    public ResponseEntity<Todo> createTodo(@RequestBody Todo todo){
        return new ResponseEntity<>(todo, HttpStatus.OK);
    }

}
