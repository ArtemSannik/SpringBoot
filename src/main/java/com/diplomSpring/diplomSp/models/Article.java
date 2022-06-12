package com.diplomSpring.diplomSp.models;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import org.springframework.web.bind.annotation.RequestPart;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
public class Article {

    private String info;
    private String title;

    public Article() {
    }

    public Article(String title, String info) {
        this.title = title;
        this.info = info;
    }
}
