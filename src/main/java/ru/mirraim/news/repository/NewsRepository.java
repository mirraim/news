package ru.mirraim.news.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.mirraim.news.model.News;
import ru.mirraim.news.model.Source;
import ru.mirraim.news.model.Topic;

@Repository
public interface NewsRepository extends PagingAndSortingRepository<News, Long> {

    @Query("select n from News n join n.topic join n.source where n.source = :source")
    Page<News> findAllBySource(@Param("source") Source source, Pageable pageable);

    @Query("select n from News n join n.topic join n.source where n.topic = :topic")
    Page<News> findAllByTopic(@Param("topic") Topic topic, Pageable pageable);

}
