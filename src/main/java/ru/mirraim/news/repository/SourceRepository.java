package ru.mirraim.news.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.mirraim.news.model.Source;

@Repository
public interface SourceRepository extends CrudRepository<Source, Long> {

    Source findSourceByName(String name);
}
