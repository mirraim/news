package ru.mirraim.news.api;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.mirraim.news.model.Topic;
import ru.mirraim.news.service.TopicService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/topics")
public class TopicController {

    private final TopicService topicService;

    @GetMapping
    public List<Topic> getTopics() {
        return topicService.getTopics();
    }
}
