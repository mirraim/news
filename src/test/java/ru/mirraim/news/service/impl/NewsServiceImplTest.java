package ru.mirraim.news.service.impl;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.PageRequest;
import ru.mirraim.news.dto.NewsRequest;
import ru.mirraim.news.dto.NewsResponse;
import ru.mirraim.news.repository.NewsRepository;
import ru.mirraim.news.repository.SourceRepository;
import ru.mirraim.news.repository.TopicRepository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;
import static ru.mirraim.news.TestDataFactory.*;

@ExtendWith(MockitoExtension.class)
class NewsServiceImplTest {
    @Mock
    private NewsRepository newsRepository;

    @Mock
    private SourceRepository sourceRepository;

    @Mock
    private TopicRepository topicRepository;

    @InjectMocks
    private NewsServiceImpl newsService;

    @Test
    void getAllNews() {
        PageRequest request = getBasePageRequest();

        when(newsRepository.findAll(request)).thenReturn(getPage());

        NewsResponse response = newsService.getAllNews(pageParams());

        verify(newsRepository).findAll(request);

        assertEquals(getNewsResponse(), response);
    }

    @Test
    void getNewsByTopic() {
        PageRequest request = getBasePageRequest();
        NewsRequest topicRequest = new NewsRequest(pageParams(), ABOUT.getName());
        topicRequest.setId(ABOUT.getId());

        when(newsRepository.findAllByTopic(ABOUT, request)).thenReturn(getPage());

        NewsResponse response = newsService.getNewsByTopic(topicRequest);

        verify(topicRepository, never()).findTopicByName(ABOUT.getName());
        verify(newsRepository).findAllByTopic(ABOUT, request);

        assertEquals(getNewsResponse(), response);
    }

    @Test
    void getNewsByTopicWhenNoId() {
        PageRequest request = getBasePageRequest();
        NewsRequest topicRequest = new NewsRequest(pageParams(), ABOUT.getName());

        when(topicRepository.findTopicByName(ABOUT.getName())).thenReturn(ABOUT);
        when(newsRepository.findAllByTopic(ABOUT, request)).thenReturn(getPage());

        NewsResponse response = newsService.getNewsByTopic(topicRequest);

        verify(topicRepository).findTopicByName(ABOUT.getName());
        verify(newsRepository).findAllByTopic(ABOUT, request);

        assertEquals(getNewsResponse(), response);
    }

    @Test
    void getNewsBySource() {
        PageRequest request = getBasePageRequest();
        NewsRequest sourceRequest = new NewsRequest(pageParams(), IRBIS.getName());
        sourceRequest.setId(IRBIS.getId());

        when(newsRepository.findAllBySource(IRBIS, request)).thenReturn(getPage());

        NewsResponse response = newsService.getNewsBySource(sourceRequest);

        verify(sourceRepository, never()).findSourceByName(IRBIS.getName());
        verify(newsRepository).findAllBySource(IRBIS, request);

        assertEquals(getNewsResponse(), response);
    }

    @Test
    void getNewsBySourceWhenNoId() {
        PageRequest request = getBasePageRequest();
        NewsRequest sourceRequest = new NewsRequest(pageParams(), IRBIS.getName());

        when(sourceRepository.findSourceByName(IRBIS.getName())).thenReturn(IRBIS);
        when(newsRepository.findAllBySource(IRBIS, request)).thenReturn(getPage());

        NewsResponse response = newsService.getNewsBySource(sourceRequest);

        verify(sourceRepository).findSourceByName(IRBIS.getName());
        verify(newsRepository).findAllBySource(IRBIS, request);

        assertEquals(getNewsResponse(), response);
    }
}