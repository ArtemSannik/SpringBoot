package com.diplomSpring.diplomSp.models;

import lombok.Builder;
import lombok.Data;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
public class ArticleEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String info;
    private String title;

    public ArticleEntity() {
    }

    public ArticleEntity(String title, String info) {
        this.title = title;
        this.info = info;
    }

}
