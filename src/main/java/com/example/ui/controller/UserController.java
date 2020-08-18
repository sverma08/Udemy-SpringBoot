package com.example.ui.controller;

import com.example.ui.model.response.UserRest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("users")
public class UserController {

    @GetMapping()
    public String getUser(@RequestParam(value = "page", defaultValue = "1") int page,
                          @RequestParam(value = "limit", defaultValue = "50") int limit) {
        return "Get User was called with page = " + page + " and limit = " + limit;
    }

    //    If we provide produces = MediaType.APPLICATION_XML_VALUE, it'll make our application to respond
    //    with XML only, So we need to give both XML and JSON format.
    @GetMapping(path = "/{userid}",
            produces = {
                    MediaType.APPLICATION_XML_VALUE,
                    MediaType.APPLICATION_JSON_VALUE
            })
    public ResponseEntity<UserRest> getUser(@PathVariable String userid) {
        UserRest returnValue = new UserRest();

        returnValue.setFirstName("Saurav");
        returnValue.setLastName("Verma");
        returnValue.setEmail("saurav.verma97@gmail.com");
        returnValue.setUserid(userid);

        return new ResponseEntity<UserRest>(returnValue, HttpStatus.OK);
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
