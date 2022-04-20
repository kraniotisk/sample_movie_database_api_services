package com.example.exams.service;

import com.example.exams.base.BaseComponent;
import com.example.exams.domain.BaseModel;
import java.util.ArrayList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;

@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED, rollbackFor = Exception.class)
public abstract class BaseServiceImpl<T extends BaseModel> extends BaseComponent implements BaseService<T, Long> {
    protected Logger logger = LoggerFactory.getLogger(getClass());
    public abstract JpaRepository<T, Long> getRepository();

    public T create(T item) {
        logger.info("creating {} {}", item.getClass().getSimpleName(), item);
        return getRepository().save(item);
    }

    public List<T> createAll(List<T> items) {
        List<T> createdItems = new ArrayList<>();
        for (T item : items) {
            createdItems.add(create(item));
        }
        return createdItems;
    }

    public List<T> createAll(T... items) {
        return createAll(Arrays.asList(items));
    }

    public void update(T item) {
        logger.info("updating {} {}", item.getClass().getSimpleName(), item);
        getRepository().save(item);
    }

    public void delete(T item) {
        logger.info("delete {} {}", item.getClass().getSimpleName(), item);
        getRepository().delete(item);
    }

    public void deleteById(Long id) {
        logger.info("delete entity with id {}", id);
        getRepository().deleteById(id);
    }

    @Transactional(readOnly = true)
    public T get(Long id) {
        logger.info("getting entity with id {}", id);
        return getRepository().findById(id).orElseThrow(NoSuchElementException::new);
    }

    @Transactional(readOnly = true)
    public boolean exists(T item) {
        logger.info("check if {} with id {} exists", item.getClass().getSimpleName(), item.getId());
        return getRepository().existsById(item.getId());
    }

    @Transactional(readOnly = true)
    public List<T> findAll() {
        logger.info("getting all entities");
        return getRepository().findAll();
    }
}
