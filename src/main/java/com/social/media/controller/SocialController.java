package com.social.media.controller;

import com.social.media.model.SocialUser;
import com.social.media.services.SocialServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@RequestMapping("")
@RestController
public class SocialController {

    @Autowired
    private SocialServices  socialServices;

    @GetMapping("/social/users")
   public ResponseEntity<List<SocialUser>> getUsers() {
	return new ResponseEntity<>(socialServices.getUsers(), HttpStatus.OK);
}
    @PostMapping("/social/users")
    public ResponseEntity<SocialUser> saveUser(@RequestBody SocialUser socilaUse) {
        return new ResponseEntity<>(socialServices.saveUser(socilaUse), HttpStatus.CREATED);
    }

}
