package com.example.day_17_1118_blog.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Set;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UpsertBlogRequest {
    private String title;

    private String content;

    private String description;

    private String thumbnail;

    private Boolean status;

    private Set<Integer> categoryIds;

}
