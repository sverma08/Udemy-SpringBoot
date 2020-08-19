package com.example.ui.controller;

import com.example.ui.model.request.UserDetailsRequestModel;
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

    @GetMapping(path = "/{userid}",
            produces = {
                    MediaType.APPLICATION_JSON_VALUE,
                    MediaType.APPLICATION_XML_VALUE
            })
    public UserRest getUser(@PathVariable String userid) {
        UserRest returnValue = new UserRest();

        returnValue.setFirstName("Saurav");
        returnValue.setLastName("Verma");
        returnValue.setEmail("saurav.verma97@gmail.com");
        returnValue.setUserid(userid);

        return returnValue;
    }

    @PostMapping(
            consumes = {
                    MediaType.APPLICATION_JSON_VALUE,
                    MediaType.APPLICATION_XML_VALUE
            },
            produces = {
                    MediaType.APPLICATION_JSON_VALUE,
                    MediaType.APPLICATION_XML_VALUE
            })
    public ResponseEntity<UserRest> createUser(@RequestBody UserDetailsRequestModel userDetails) {

        UserRest returnValue = new UserRest();

        returnValue.setFirstName(userDetails.getFirstName());
        returnValue.setLastName(userDetails.getLastName() );
        returnValue.setEmail(userDetails.getEmail());

        return new ResponseEntity<>(returnValue, HttpStatus.OK);
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
