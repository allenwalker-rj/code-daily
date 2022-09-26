package com.allen.codedaily.day.info;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * @author allen
 * @date 2022/9/26 10:21
 */
@Data
@Component
@ConfigurationProperties(prefix = "person")
public class Person {
    private String nickName;
    private Integer age;
    private String birth;
    private Map<String, Object> maps;
    private List<String> lists;
}
