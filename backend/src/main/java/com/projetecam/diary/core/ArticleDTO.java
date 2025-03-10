package com.projetecam.diary.core; 

import lombok.Data;

@Data
public class ArticleDTO {
    private final long id;
    private Integer type;
    private String headline;
    private String subHeadline1;
    private String text1;
    private String subHeadline2;
    private String text2;
    private String subHeadline3;
    private String text3;
}