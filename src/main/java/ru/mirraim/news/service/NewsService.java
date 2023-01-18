package ru.mirraim.news.service;

import ru.mirraim.news.dto.NewsRequest;
import ru.mirraim.news.dto.NewsResponse;
import ru.mirraim.news.dto.PageParams;

public interface NewsService {

    NewsResponse getAllNews(PageParams pageable);
    NewsResponse getNewsByTopic(NewsRequest topic);
    NewsResponse getNewsBySource(NewsRequest source);
}
