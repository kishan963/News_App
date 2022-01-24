package com.example.newapp;

public class ModelClass {

    private String author,url,urlToImage,description,title,source_id,publishedAt;

    public ModelClass(String author, String url, String urlToImage, String description, String title, String source_id, String publishedAt) {
        this.author = author;
        this.url = url;
        this.urlToImage = urlToImage;
        this.description = description;
        this.title = title;
        this.source_id = source_id;
        this.publishedAt = publishedAt;
    }

    public String getAuthor() {
        return author;
    }

    public String getUrl() {
        return url;
    }

    public String getUrlToImage() {
        return urlToImage;
    }

    public String getDescription() {
        return description;
    }

    public String getTitle() {
        return title;
    }

    public String getSource_id() {
        return source_id;
    }

    public String getPublishedAt() {
        return publishedAt;
    }
}
