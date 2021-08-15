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
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.io.IOException;
import java.util.List;

/**
 *
 * @author HakumenNC
 */
@RestController
@Tag(name = "Users", description = "Users related resources")
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
public class UserController {

    private final Logger log = LoggerFactory.getLogger(UserController.class);

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "users/top")
    @Operation(summary = "Get the top users",
            description = "Users' list with rank, username, featured images and creations counters.")
    public List<TopUser> getTopUsers() throws IOException {
        log.debug("GET getTopUsers request");

        return userService.getTopUsers();
    }

    @GetMapping(value = "user/{userName}")
    @Operation(summary = "Get user's details",
            description = "User information details like rank, points, joined date, submissions, streams followed, etc")
    public User getUser(
            @Parameter(description = "username") @PathVariable String userName) throws IOException {
        log.debug("GET user {}", userName);

        try {
            return userService.getUser(userName);

        } catch (FailingHttpStatusCodeException e) {
            throw new ResponseStatusException(e.getStatusCode(), e.getStatusMessage(), e);
        }
    }
}
