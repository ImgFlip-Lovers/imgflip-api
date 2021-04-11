/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.adriens.imgflip.api.controller;

import com.github.adriens.imgflip.api.service.PublishedMemesService;
import com.github.adriens.imgflip.sdk.imgflip.sdk.PublishedMeme;
import java.io.IOException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author 3004SAL
 */
@RestController
public class PublishedMemesController {
    @Autowired
    private PublishedMemesService publishedMemesService;
    
    
    @GetMapping("/hot/{stream}")
    public List<PublishedMeme> getMemes(@PathVariable String stream,
            @RequestParam(value="page", defaultValue = "1") int page) throws IOException{
        return publishedMemesService.getPageOfHotStream(stream,page);
    }
    

    @GetMapping("/hot")
    public List<PublishedMeme> getMemes(@RequestParam(value="page", defaultValue = "1") int page) throws IOException{
        return publishedMemesService.getPageOfHotStream(page);
    }
    
    // Top stream queries
    // /top/{stream}/last/1d
    @GetMapping("/top/{stream}/last/1d")
    public List<PublishedMeme> getTop1d(@PathVariable String stream,
            @RequestParam(value="page", defaultValue = "1") int page) throws IOException{
        return publishedMemesService.getTopOneDayPageOfHotStream(stream, page);
    }
    // /top/{stream}/last/7d
    @GetMapping("/top/{stream}/last/7d")
    public List<PublishedMeme> getTop7d(@PathVariable String stream,
            @RequestParam(value="page", defaultValue = "1") int page) throws IOException{
        return publishedMemesService.getTopSevenDayPageOfHotStream(stream, page);
    }
    // /top/{stream}/last/30d
    @GetMapping("/top/{stream}/last/30d")
    public List<PublishedMeme> getTop30d(@PathVariable String stream,
            @RequestParam(value="page", defaultValue = "1") int page) throws IOException{
        return publishedMemesService.getTopThirtyDayPageOfHotStream(stream, page);
    }
    // /top/{stream}/last/month
    @GetMapping("/top/{stream}/last/month")
    public List<PublishedMeme> getTopLastMonth(@PathVariable String stream,
            @RequestParam(value="page", defaultValue = "1") int page) throws IOException{
        return publishedMemesService.getTopLastMonthPageOfHotStream(stream, page);
    }
    
    // /top/{stream}/last/year
    @GetMapping("/top/{stream}/last/year")
    public List<PublishedMeme> getTopLastYear(@PathVariable String stream,
            @RequestParam(value="page", defaultValue = "1") int page) throws IOException{
        return publishedMemesService.getTopLastYearPageOfHotStream(stream, page);
    }
    
    
}
