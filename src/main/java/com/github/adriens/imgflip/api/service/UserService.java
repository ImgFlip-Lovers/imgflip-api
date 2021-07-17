/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.adriens.imgflip.api.service;

import com.gargoylesoftware.htmlunit.FailingHttpStatusCodeException;
import com.github.adriens.imgflip.sdk.imgflip.sdk.TopUserCrawler;
import com.github.adriens.imgflip.sdk.imgflip.sdk.UserCrawler;
import com.github.adriens.imgflip.sdk.imgflip.sdk.domain.TopUser;
import com.github.adriens.imgflip.sdk.imgflip.sdk.domain.User;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

/**
 *
 * @author HakumenNC
 */
@Service
public class UserService {

    public List<TopUser> getTopUsers() throws IOException {
        return TopUserCrawler.getTopUsers();
    }

    public User getUser(String userName) throws IOException, FailingHttpStatusCodeException {
        return UserCrawler.getUser(userName);
    }
}
