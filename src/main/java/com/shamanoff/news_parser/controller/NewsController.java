package com.shamanoff.news_parser.controller;

import com.shamanoff.news_parser.model.News;
import com.shamanoff.news_parser.services.INewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

//@Controller
@RestController
@RequestMapping("/news")
public class NewsController {

    @Autowired
    private INewsService newsService;

    @GetMapping()
//    @ResponseBody
    public List<News> newsList() {

        return newsService.findAll();
    }


}
