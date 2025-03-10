package com.projetecam.diary.core; 

import java.time.LocalDate;

import lombok.Data;

@Data
public class ArticleDTO {
    private final long id;
    private final long creatorUserId;
    private final LocalDate date;

    private final Integer type;
    private final String headline;
    private final String subHeadline1;
    private final String text1;
    private final String subHeadline2;
    private final String text2;
    private final String subHeadline3;
    private final String text3;
}