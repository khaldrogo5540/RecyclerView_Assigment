package com.example.recyclerview.model;

public class Email {
    private String name;
    private String subject;
    private String body;
    private String imageUrl;

    public Email(String name, String subject, String body, String imageUrl) {
        this.name = name;
        this.subject = subject;
        this.body = body;
        this.imageUrl = imageUrl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
