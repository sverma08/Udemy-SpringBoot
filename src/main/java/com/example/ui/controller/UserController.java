package com.example.ui.controller;

import com.example.ui.model.response.UserRest;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("users")
public class UserController {

    @GetMapping()
    public String getUser(@RequestParam(value = "page", defaultValue = "1") int page,
                          @RequestParam(value = "limit", defaultValue = "50") int limit) {
        return "Get User was called with page = " + page + " and limit = " + limit;
    }

    @GetMapping(path = "/{userid}")
    public UserRest getUser(@PathVariable String userid) {
        UserRest returnValue = new UserRest();

        returnValue.setFirstName("Saurav");
        returnValue.setLastName("Verma");
        returnValue.setEmail("saurav.verma97@gmail.com");
        returnValue.setUserid(userid);

        return returnValue;
    }

    @PostMapping
    public String createUser() {

        return "Create User was called!";
    }

    @PutMapping
    public String updateUser() {

        return "Update User was called!";
    }

    @DeleteMapping
    public String deleteUser() {

        return "Delete User was called!";
    }
}
