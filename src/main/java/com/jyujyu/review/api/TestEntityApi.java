package com.jyujyu.review.api;

import com.jyujyu.review.repository.TestRepository;
import com.jyujyu.review.service.TestService;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
public class TestEntityApi {
    private final TestService testService;
    private final TestRepository testRepository;

    @PostMapping("/test/entity/create")
    public void createTestEntity(@RequestBody CreateTestEntityRequest request) {
        testService.create(request.getName(), request.getAge());
    }

    @PutMapping("/test/entity/{id}")
    public void putTestEntity(@PathVariable("id") Long id, @RequestBody CreateTestEntityRequest request) {
        testService.update(id, request.getName(), request.getAge());
    }

    @DeleteMapping("/test/entity/{id}")
    public void deleteTestEntity(@PathVariable("id") Long id) {
        testService.delete(id);
    }

    @Getter
    @NoArgsConstructor(force = true)
    @AllArgsConstructor
    public static class CreateTestEntityRequest {
        private final String name;
        private final Integer age;
    }
}
