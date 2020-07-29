package com.example.helplearning.Model;

public class Item {
    public Item() {
    }

    private String link;
    private String title;
    private String date;
    private String description;
    private String content;

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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Item(String link, String title, String date, String description, String content) {
        this.link = link;
        this.title = title;
        this.date = date;
        this.description = description;
        this.content = content;
    }
}
