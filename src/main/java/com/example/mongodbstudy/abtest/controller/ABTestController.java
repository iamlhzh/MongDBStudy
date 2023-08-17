package com.example.mongodbstudy.abtest.controller;

import com.example.mongodbstudy.abtest.dto.PersonDto;
import com.mongodb.client.result.DeleteResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/abTest")
public class ABTestController {

    @Autowired
    private MongoTemplate mongoTemplate;

    @RequestMapping(value = "/save",method = RequestMethod.POST)
    public Map<String,Object> savePerson(@RequestBody PersonDto personDto){
        Map<String,Object>map = new HashMap<>();
        PersonDto save = mongoTemplate.save(personDto);
        map.put("person",save);
        return map;
    }

    @RequestMapping(value = "/get",method = RequestMethod.GET)
    public Map<String,Object> savePerson(String id){
        Map<String,Object>map = new HashMap<>();
        PersonDto person = mongoTemplate.findById(id,PersonDto.class);
        map.put("person",person);
        return map;
    }

    @RequestMapping(value = "/del",method = RequestMethod.GET)
    public Map<String,Object> delPerson(String id){
        Map<String,Object>map = new HashMap<>();
        Query query = Query.query(Criteria.where("id").is(id));
        DeleteResult remove = mongoTemplate.remove(query, PersonDto.class);
        map.put("DeleteResult",remove);
        return map;
    }
}
