package app.springData.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class TestController {
    @RequestMapping(method = RequestMethod.GET, path = "/test")
    public ResponseEntity<String> getTest(){
        return new ResponseEntity<>("This is our test message", HttpStatus.OK);
    }
}
