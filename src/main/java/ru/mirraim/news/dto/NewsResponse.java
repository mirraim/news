package ru.mirraim.news.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import ru.mirraim.news.model.News;

import java.util.List;

@Data
@AllArgsConstructor
public class NewsResponse {
    private List<News> news;
    private long total;

    private int pages;
}
