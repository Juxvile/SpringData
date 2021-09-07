package app.springData.controllers;

import app.springData.domain.User;
import app.springData.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }


    @RequestMapping(method = RequestMethod.GET, path = "/create_table")
    public ResponseEntity<String> createTable(){
        userService.createTableUser();
        return new ResponseEntity<>("Table has been created", HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST, path = "/user/create")
    public ResponseEntity<Integer> createUser(@RequestBody User user){
        int result = userService.createUser(user);
        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.GET, path = "/user/get/{id}")
    public ResponseEntity<User> createUser(@PathVariable Long id){
        User result = userService.getUser(id);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.PUT, path = "/user/update/{id}")
    public ResponseEntity<Integer> updateUser(@RequestBody User user,@PathVariable Long id){
        int result = userService.updateUser(user, id);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.DELETE, path = "/user/delete/{id}")
    public ResponseEntity<Integer> deleteUser(@PathVariable Long id){
        int result = userService.deleteUser(id);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
