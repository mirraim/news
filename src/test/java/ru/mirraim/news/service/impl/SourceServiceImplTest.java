package ru.mirraim.news.service.impl;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.mirraim.news.model.Source;
import ru.mirraim.news.repository.SourceRepository;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static ru.mirraim.news.TestDataFactory.IRBIS;

@ExtendWith(MockitoExtension.class)
class SourceServiceImplTest {

    @Mock
    private SourceRepository sourceRepository;

    @InjectMocks
    private SourceServiceImpl sourceService;

    @Test
    void getSources() {
        Mockito.when(sourceRepository.findAll()).thenReturn(List.of(IRBIS));

        List<Source> sources = sourceService.getSources();

        assertEquals(IRBIS, sources.get(0));
    }
}