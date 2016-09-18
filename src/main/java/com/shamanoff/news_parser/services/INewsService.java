package com.shamanoff.news_parser.services;

import com.shamanoff.news_parser.model.News;

import java.util.List;

public interface INewsService {

    void saveNews(List<News> news);
    List<News> findAll();

}
