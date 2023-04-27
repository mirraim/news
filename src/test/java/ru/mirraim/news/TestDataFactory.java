package ru.mirraim.news;

import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import ru.mirraim.news.dto.NewsResponse;
import ru.mirraim.news.dto.PageParams;
import ru.mirraim.news.model.News;
import ru.mirraim.news.model.Source;
import ru.mirraim.news.model.Topic;

import java.util.List;

public class TestDataFactory {

    public static final Source IRBIS = new Source(1L, "irbis.plus");
    public static final Source PRACTICA = new Source(2L, "praktika.irbis.plus");

    public static final Topic UL = new Topic(1L, "Помощь юр. лицам");
    public static final Topic FL = new Topic(2L, "Помощь физ. лицам");
    public static final Topic ABOUT = new Topic(3L, "О нас");
    public static final Topic UPDATE = new Topic(4L, "Обновления сервиса");

    public static List<News> getNews() {

        return List.of(
                new News(1L, IRBIS, UL, "Обновления законодательства в 2022 году."),
                new News(2L, IRBIS, UL, "Обновления законодательства в 2023 г."),
                new News(3L, IRBIS, FL, "Рассказываем о том, как обезопасить себя от мошенников"),
                new News(4L, IRBIS, ABOUT, "Рассказываем о том, как отдыхают наши работники"),
                new News(5L, IRBIS, ABOUT, "Знакомим с нашими клиентами. Часть 1"),
                new News(6L, IRBIS, ABOUT, "Знакомим с нашими клиентами. Часть 2"),
                new News(7L, PRACTICA, UPDATE, "Обновления сервиса;Знакомство с сервисом"),
                new News(8L, PRACTICA, UPDATE, "Обновления сервиса;Нововведения во вкладке \"Суды\"")
        );
    }

    public static PageRequest getBasePageRequest() {
        return PageRequest.of(0, 10);
    }

    public static PageParams pageParams() {
        return PageParams.builder()
                .page(0)
                .size(10)
                .build();
    }

    public static PageImpl<News> getPage() {
        return new PageImpl<>(getNews(), getBasePageRequest(), 8);
    }

    public static NewsResponse getNewsResponse() {
        return new NewsResponse(getNews(), 8, 1);
    }
}
