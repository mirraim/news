package ru.mirraim.news.api;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.mirraim.news.dto.NewsRequest;
import ru.mirraim.news.dto.NewsResponse;
import ru.mirraim.news.dto.PageParams;
import ru.mirraim.news.service.NewsService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/news")
public class NewsController {
    private final NewsService newsService;

    @PostMapping
    public NewsResponse getAllNews(@RequestBody PageParams params) {
        return newsService.getAllNews(params);
    }

    @PostMapping("/topic")
    public NewsResponse getAllNewsByTopic(@RequestBody NewsRequest request) {
        return newsService.getNewsByTopic(request);
    }

    @PostMapping("/source")
    public NewsResponse getAllNewsBySource(@RequestBody NewsRequest request) {
        return newsService.getNewsBySource(request);
    }
}
