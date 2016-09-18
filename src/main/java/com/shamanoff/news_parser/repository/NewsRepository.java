package com.shamanoff.news_parser.repository;

import com.shamanoff.news_parser.model.News;
import org.springframework.data.repository.CrudRepository;

public interface NewsRepository extends CrudRepository<News, Integer>{


}
