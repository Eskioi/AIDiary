package com.projetecam.diary.core;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CreateArticleDTO {
    private LocalDate date;
    private Integer type;
    private String headline;
    private String subHeadline1;
    private String text1;
    private String subHeadline2;
    private String text2;
    private String subHeadline3;
    private String text3;
}
