package com.projetecam.diary.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class Article {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    private long creatorUserId;
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
