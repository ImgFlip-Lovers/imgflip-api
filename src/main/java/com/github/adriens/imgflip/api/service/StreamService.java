/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.adriens.imgflip.api.service;

import com.github.adriens.imgflip.sdk.imgflip.sdk.PopularStreamCrawler;
import com.github.adriens.imgflip.sdk.imgflip.sdk.domain.PopularStream;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

/**
 *
 * @author HakumenNC
 */
@Service
public class StreamService {

    public List<PopularStream> getPopularStreams(Boolean includeNSFW) throws IOException {
        return PopularStreamCrawler.getPopularStreams(includeNSFW);
    }

    public  List<PopularStream> getPopularNSFWStreams() throws IOException {
        return PopularStreamCrawler.getPopularNSFWStreams();
    }
}
