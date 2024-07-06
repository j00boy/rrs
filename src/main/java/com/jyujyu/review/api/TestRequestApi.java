package com.jyujyu.review.api;

import org.springframework.web.bind.annotation.*;

@RestController
public class TestRequestApi {

    // Request Parameter 방식
    // 400: Bad Request
    @GetMapping("/test/param")
    public String requestParam(@RequestParam("name") String name, @RequestParam("age") Integer age) {
        return "Hello, Request Param. I am " + name + ", " + age;
    }

    // Path Variable 방식
    // 404: Not Found
    @GetMapping("/test/path/{name}/{age}")
    public String requestPathVariable(@PathVariable("name") String name, @PathVariable("age") Integer age) {
        return "Hello, Path Variable. I am " + name + ", " + age + ".";
    }

    // Request Body 방식
    // 보통 Post Mapping이나 Put Mapping에서 많이 사용
    // RequestBody 방식을 이용하기 위해서는 클래스를 하나 추가해줘야 함
    // 400: Bad Request
    // requestBody를 이용할 때에는 생성자를 꼭 만들어줘야 함
    @PostMapping("/test/body")
    public String requestBody(@RequestBody TestRequestBody request) {
        return "Hello, Request Body. I am " + request.name + ", " + request.age + ".";
    }


    public static class TestRequestBody {
        String name;
        Integer age;


        public void setName(String name) {
            this.name = name;
        }

        public void setAge(Integer age) {
            this.age = age;
        }

        public TestRequestBody() {}

//        public TestRequestBody(String name, Integer age) {
//            this.name = name;
//            this.age = age;
//        }
    }
}
