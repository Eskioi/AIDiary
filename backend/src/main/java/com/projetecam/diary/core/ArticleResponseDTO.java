package com.projetecam.diary.core; 

import lombok.AllArgsConstructor; 
import lombok.NoArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
@NoArgsConstructor

public class ArticleResponseDTO {
    private Int type;
    private String headline;
    private String subHeadline1;
    private String text1;
    private String subHeadline2;
    private String text2;
    private String subHeadline3;
    private String text3;
}