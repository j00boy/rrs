package com.jyujyu.review.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestResponseApi {

    @GetMapping("/test/response/string")
    public String stringResponse() {
        return "This is String.";
    }

    // 객체를 반환할 수 있다면, test/plain 방식이 아닌 application-json 방식으로 return
    @GetMapping("test/response/json")
    public TestResponseBody jsonResponse() {
        return new TestResponseBody("jooboy", 29);
    }

    public static class TestResponseBody {
        String name;
        Integer age;

        public TestResponseBody(String name, Integer age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public Integer getAge() {
            return age;
        }
    }
}
