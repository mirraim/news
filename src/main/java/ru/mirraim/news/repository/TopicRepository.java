package ru.mirraim.news.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.mirraim.news.model.Topic;

@Repository
public interface TopicRepository extends CrudRepository<Topic, Long> {

    Topic findTopicByName(String name);
}
