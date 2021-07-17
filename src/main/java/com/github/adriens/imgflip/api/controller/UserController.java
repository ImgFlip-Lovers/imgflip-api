/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.adriens.imgflip.api.controller;

import com.github.adriens.imgflip.api.service.TopUsersService;
import com.github.adriens.imgflip.sdk.imgflip.sdk.domain.TopUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

/**
 *
 * @author 3004SAL
 */
@RestController
@RequestMapping("/top-users")
public class TopUsersController {

    private final Logger log = LoggerFactory.getLogger(TopUsersController.class);

    private final TopUsersService topUsersService;

    public TopUsersController(TopUsersService topUsersService) {
        this.topUsersService = topUsersService;
    }

    @GetMapping
    public List<TopUser> getTopUsers() throws IOException {
        log.debug("GET getTopUsers request");

        return topUsersService.getMemes();
    }
}
