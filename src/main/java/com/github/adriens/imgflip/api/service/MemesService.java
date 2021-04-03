/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.adriens.imgflip.api.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.github.adriens.imgflip.sdk.imgflip.sdk.ImgFlipAPI;
import com.github.adriens.imgflip.sdk.imgflip.sdk.Meme;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 *
 * @author 3004SAL
 */
@Service
public class MemesService {

    private final Logger log = LoggerFactory.getLogger(MemesService.class);
    
    public List<Meme> getMemes() throws JsonProcessingException{
        return ImgFlipAPI.getMemes();
    }
    
    public List<Meme> getMemes(int n) throws JsonProcessingException{
        return ImgFlipAPI.getTopNMemes(n);
    }
    
    public Meme getMeme(int memeId) throws JsonProcessingException{
        return ImgFlipAPI.getMeme(memeId);
    }
}
