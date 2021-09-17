package com.bq.continues.photo.board.entity;

import lombok.*;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@ToString
public class Photo {

    private long id;
    private String writer;
    private String title;
    private String content;
    private String imageUrl;
    private LocalDateTime generateDate;

}
