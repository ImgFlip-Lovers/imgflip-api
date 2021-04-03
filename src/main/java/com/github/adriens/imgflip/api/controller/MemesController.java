/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.adriens.imgflip.api.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.github.adriens.imgflip.api.service.MemesService;
import com.github.adriens.imgflip.sdk.imgflip.sdk.Meme;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author 3004SAL
 */
@RestController
public class MemesController {

    @Autowired
    private MemesService memesService;

    @GetMapping("/memes/")
    public List<Meme> getMemes() throws JsonProcessingException {
        return memesService.getMemes();
    }
    
    @GetMapping("/memes/top/{n}")
    public List<Meme> getMemes(@PathVariable int n) throws JsonProcessingException{
        return memesService.getMemes(n);
    }
    
    @GetMapping("/memes/{memeId}")
    public Meme getMeme(@PathVariable int memeId) throws JsonProcessingException{
        return memesService.getMeme(memeId);
    }
}
