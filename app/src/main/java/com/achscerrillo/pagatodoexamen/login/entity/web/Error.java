package com.achscerrillo.pagatodoexamen.login.entity.web;

/**
 * Created by alejandrocerrillo on 17/02/18.
 */

public class Error {
    String id;
    String message;
    String title;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "Error{" +
                "id='" + id + '\'' +
                ", message='" + message + '\'' +
                ", title='" + title + '\'' +
                '}';
    }
}
