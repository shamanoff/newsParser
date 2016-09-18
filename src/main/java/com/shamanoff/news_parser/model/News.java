package com.shamanoff.news_parser.model;

import java.util.Objects;

public class News {

    private String link;
    private String title;

    public News(String link, String title) {
        this.link = link;
        this.title = title;
    }

    public News() {
    }

    @Override
    public String toString() {
        return "News{" +
                "title='" + title + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof News)) return false;
        News news = (News) o;
        return Objects.equals(getLink(), news.getLink()) &&
                Objects.equals(getTitle(), news.getTitle());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getLink(), getTitle());
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
