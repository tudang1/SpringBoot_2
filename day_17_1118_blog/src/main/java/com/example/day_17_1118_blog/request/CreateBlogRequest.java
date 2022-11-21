package com.example.day_17_1118_blog.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateBlogRequest {
    private String title;

    private String content;

    private String description;

    private String thumbnail;

    private Boolean status;

    private List<Integer> categoryIds;

}
