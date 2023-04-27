package ru.mirraim.news.service.impl;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.mirraim.news.model.Topic;
import ru.mirraim.news.repository.TopicRepository;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static ru.mirraim.news.TestDataFactory.ABOUT;

@ExtendWith(MockitoExtension.class)
class TopicServiceImplTest {

    @Mock
    private TopicRepository topicRepository;

    @InjectMocks
    private TopicServiceImpl topicService;

    @Test
    void getTopics() {
        Mockito.when(topicRepository.findAll()).thenReturn(List.of(ABOUT));

        List<Topic> topics = topicService.getTopics();

        assertEquals(ABOUT, topics.get(0));
    }
}