package com.example.exams.controller;

import com.example.exams.base.BaseComponent;
import com.example.exams.domain.BaseModel;
import com.example.exams.service.BaseService;
import com.example.exams.transfer.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;
import java.util.List;

public abstract class BaseController<T extends BaseModel> extends BaseComponent {
    protected abstract BaseService<T,Long> getBaseService();

    @GetMapping
    public ResponseEntity<ApiResponse<List<T>>> findAll() {
        return new ResponseEntity<>(ApiResponse.<List<T>>builder().data(getBaseService().findAll()).build(),
                HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<T>> get(@PathVariable Long id) {
        return ResponseEntity.ok(ApiResponse.<T>builder().data(getBaseService().get(id)).build());
    }

    @PostMapping
    public ResponseEntity<ApiResponse<T>> create(@Valid @RequestBody T t) {
        return new ResponseEntity<>(ApiResponse.<T>builder().data(getBaseService().create(t)).build(), HttpStatus.CREATED);
    }

    @DeleteMapping
    public void delete(@Valid @RequestBody T t) {
        if (getBaseService().exists(t)) {
            getBaseService().delete(t);
        }
    }
}
