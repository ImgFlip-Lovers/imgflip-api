/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.adriens.imgflip.api.controller;

import com.gargoylesoftware.htmlunit.FailingHttpStatusCodeException;
import com.github.adriens.imgflip.api.service.UserService;
import com.github.adriens.imgflip.sdk.imgflip.sdk.domain.TopUser;
import com.github.adriens.imgflip.sdk.imgflip.sdk.domain.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.io.IOException;
import java.util.List;

/**
 *
 * @author HakumenNC
 */
@RestController
public class UserController {

    private final Logger log = LoggerFactory.getLogger(UserController.class);

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("users/top")
    public List<TopUser> getTopUsers() throws IOException {
        log.debug("GET getTopUsers request");

        return userService.getTopUsers();
    }

    @GetMapping("user/{userName}")
    public User getUser(@PathVariable String userName) throws IOException {
        log.debug("GET user {}", userName);

        try {
            return userService.getUser(userName);

        } catch (FailingHttpStatusCodeException e) {
            throw new ResponseStatusException(e.getStatusCode(), e.getStatusMessage(), e);
        }
    }
}
