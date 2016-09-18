package com.shamanoff.news_parser.services;

import com.shamanoff.news_parser.model.News;
import com.shamanoff.news_parser.repository.NewsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.util.Assert.notNull;


@Service
public class NewsService implements INewsService {


    private final NewsRepository rep;

    @Autowired
    public NewsService(NewsRepository rep) {
        notNull(rep);
        this.rep = rep;
    }

    @Override
    public void saveNews(List<News> news) {
        notNull(news, "News must not be null");
        rep.save(news);

    }

    @Override
    public List<News> findAll() {
        List<News> newsList = new ArrayList<>();
        for (News news : rep.findAll()){
            newsList.add(news);
        }
        return newsList;

    }
}
