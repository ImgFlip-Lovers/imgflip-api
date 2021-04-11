/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.adriens.imgflip.api.service;

import com.github.adriens.imgflip.sdk.imgflip.sdk.ImgFlipURLHelper;
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
    // top filters
    // 1d filter
    public List<PublishedMeme> getTopOneDayPageOfHotStream(String stream, int page) throws IOException{
        String targetUrl = ImgFlipURLHelper.getPathOfTopOneDay(stream, page);
        return PublishedMemesCrawler.getPublishedMemes(targetUrl);
    }
    // 7d filter
    public List<PublishedMeme> getTopSevenDayPageOfHotStream(String stream, int page) throws IOException{
        String targetUrl = ImgFlipURLHelper.getPathOfTopSevendays(stream, page);
        return PublishedMemesCrawler.getPublishedMemes(targetUrl);
    }
    // 30d filter
    public List<PublishedMeme> getTopThirtyDayPageOfHotStream(String stream, int page) throws IOException{
        String targetUrl = ImgFlipURLHelper.getPathOfTopThirtyDays(stream, page);
        return PublishedMemesCrawler.getPublishedMemes(targetUrl);
    }
    // last month filter
    public List<PublishedMeme> getTopLastMonthPageOfHotStream(String stream, int page) throws IOException{
        String targetUrl = ImgFlipURLHelper.getPathOfTopLastMonth(stream, page);
        return PublishedMemesCrawler.getPublishedMemes(targetUrl);
    }
    // last year filter
    public List<PublishedMeme> getTopLastYearPageOfHotStream(String stream, int page) throws IOException{
        String targetUrl = ImgFlipURLHelper.getPathOfTopLastYear(stream, page);
        return PublishedMemesCrawler.getPublishedMemes(targetUrl);
    }
    
}
