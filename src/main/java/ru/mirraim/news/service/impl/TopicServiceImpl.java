package ru.mirraim.news.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.mirraim.news.model.Topic;
import ru.mirraim.news.repository.TopicRepository;
import ru.mirraim.news.service.TopicService;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TopicServiceImpl implements TopicService {

    private final TopicRepository repository;
    @Override
    public List<Topic> getTopics() {
        List<Topic> topics = new ArrayList<>();
        repository.findAll().forEach(topics :: add);
        return topics;
    }
}
