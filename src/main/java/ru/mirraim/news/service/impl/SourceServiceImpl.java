package ru.mirraim.news.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.mirraim.news.model.Source;
import ru.mirraim.news.repository.SourceRepository;
import ru.mirraim.news.service.SourceService;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SourceServiceImpl implements SourceService {
    private final SourceRepository repository;

    @Override
    public List<Source> getSources() {
        List<Source> sources = new ArrayList<>();
        repository.findAll().forEach(sources::add);
        return sources;
    }
}
