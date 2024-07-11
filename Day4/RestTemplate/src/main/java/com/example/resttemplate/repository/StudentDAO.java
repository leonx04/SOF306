package com.example.resttemplate.repository;

import com.example.resttemplate.beans.StudentMap;
import com.example.resttemplate.entity.Student;
import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

@Repository
public class StudentDAO {
    RestTemplate restTemplate = new RestTemplate();

    String url = "https://sof306-97067-default-rtdb.firebaseio.com/students.json";

    private String getUrl(String key){
        return url.replace(".json", "/"+ key +  ".json");
    }

    public StudentMap findAll(){
        return restTemplate.getForObject(url, StudentMap.class);
    }

    public Student findByKey(String key){
        return restTemplate.getForObject(getUrl(key), Student.class);
    }


    public void save(Student student){
        restTemplate.put(getUrl(student.getEmail()), student);
    }

    public String create(Student student){
        HttpEntity<Student> entity = new HttpEntity<>(student);
        JsonNode response = restTemplate.postForEntity(url, entity, JsonNode.class).getBody();
        return response.get("name").asText();
    }

    public Student update(String key, Student student){
        HttpEntity<Student> entity = new HttpEntity<>(student);
        restTemplate.put(getUrl(key), entity);
        return student;
    }

    public void delete(String key){
        restTemplate.delete(getUrl(key));
    }




}
