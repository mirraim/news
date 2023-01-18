package ru.mirraim.news.dto;

import lombok.Data;
import org.springframework.lang.NonNull;

@Data
public class NewsRequest {
    @NonNull
    private PageParams params;

    private long id;
    @NonNull
    private String name;
}
