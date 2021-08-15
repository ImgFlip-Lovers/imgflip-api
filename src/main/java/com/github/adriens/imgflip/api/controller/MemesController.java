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

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author 3004SAL
 */
@RestController
@Tag(name = "Memes", description = "Memes related resources")
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
public class MemesController {

    @Autowired
    private MemesService memesService;

    @GetMapping("/memes/")
    @Operation(summary = "Get Memes",
            description = "Memes' list.")
    public List<Meme> getMemes() throws JsonProcessingException {
        return memesService.getMemes();
    }
    
    @GetMapping("/memes/top/{n}")
    @Operation(summary = "Get top n memes",
            description = "Top n memes")
    public List<Meme> getMemes(
            @Parameter(description = "Number of memes to retrieve") @PathVariable int n) throws JsonProcessingException {
        return memesService.getMemes(n);
    }
    
    @GetMapping("/memes/{memeId}")
    @Operation(summary = "Get meme",
            description = "Get a meme by ID")
    public Meme getMeme(
            @Parameter(description = "Meme ID") @PathVariable int memeId) throws JsonProcessingException{
        return memesService.getMeme(memeId);
    }
}
