/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.adriens.imgflip.api.service;

import com.github.adriens.imgflip.sdk.imgflip.sdk.PublishedMeme;
import com.github.adriens.imgflip.sdk.imgflip.sdk.PublishedMemesCrawler;
import java.io.IOException;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 *
 * @author 3004SAL
 */
@Service
public class PublishedMemesService {
    private final Logger log = LoggerFactory.getLogger(PublishedMemesService.class);
    
    public List<PublishedMeme> getPageOfHotStream(String stream, int page) throws IOException{
        return PublishedMemesCrawler.getPublishedMemes(stream, page);
    }
    public List<PublishedMeme> getPageOfHotStream(String stream) throws IOException{
        return PublishedMemesCrawler.getPublishedMemes();
    }
    public List<PublishedMeme> getPageOfHotStream(int page) throws IOException{
        return PublishedMemesCrawler.getPublishedMemes(page);
    }
    public List<PublishedMeme> getPageOfHotStream() throws IOException{
        return PublishedMemesCrawler.getPublishedMemes();
    }
    
}
