package ru.mirraim.news.service.impl;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import ru.mirraim.news.dto.NewsRequest;
import ru.mirraim.news.dto.NewsResponse;
import ru.mirraim.news.dto.PageParams;
import ru.mirraim.news.model.News;
import ru.mirraim.news.model.Source;
import ru.mirraim.news.model.Topic;
import ru.mirraim.news.repository.NewsRepository;
import ru.mirraim.news.repository.SourceRepository;
import ru.mirraim.news.repository.TopicRepository;
import ru.mirraim.news.service.NewsService;

@Service
@RequiredArgsConstructor
public class NewsServiceImpl implements NewsService {

    private final NewsRepository newsRepository;
    private final TopicRepository topicRepository;

    private final SourceRepository sourceRepository;
    @Override
    @Transactional
    public NewsResponse getAllNews(PageParams params) {

        PageRequest pageRequest = PageRequest.of(params.getPage(), params.getSize());
        Page<News> news = newsRepository.findAll(pageRequest);
        return new NewsResponse(news.getContent(), news.getTotalElements(), news.getTotalPages());
    }

    @Override
    @Transactional
    public NewsResponse getNewsByTopic(NewsRequest request) {
        PageRequest pageRequest = PageRequest.of(request.getParams().getPage(),
                request.getParams().getSize());
        Topic topic = new Topic(request.getId(), request.getName());
        if (topic.getId() == 0){
            topic = topicRepository.findTopicByName(topic.getName());
        }
        Page<News> news = newsRepository.findAllByTopic(topic, pageRequest);
        return new NewsResponse(news.getContent(), news.getTotalElements(), news.getTotalPages());
    }

    @Override
    public NewsResponse getNewsBySource(NewsRequest request) {
        PageRequest pageRequest = PageRequest.of(request.getParams().getPage(),
                request.getParams().getSize());
        Source source = new Source(request.getId(), request.getName());
        if (source.getId() == 0) {
            source = sourceRepository.findSourceByName(source.getName());
        }
        Page<News> news = newsRepository.findAllBySource(source, pageRequest);
        return new NewsResponse(news.getContent(), news.getTotalElements(), news.getTotalPages());
    }

}
