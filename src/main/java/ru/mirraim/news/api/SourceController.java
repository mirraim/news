package ru.mirraim.news.api;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.mirraim.news.model.Source;
import ru.mirraim.news.service.SourceService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/sources")
public class SourceController {
        private final SourceService sourceService;
    @GetMapping
    public List<Source> getAllSources() {
        return sourceService.getSources();
    }
}
