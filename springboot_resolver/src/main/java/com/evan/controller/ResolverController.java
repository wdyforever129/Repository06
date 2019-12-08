package com.evan.controller;

import com.evan.service.ResolverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/resolver")
public class ResolverController {
    @Autowired
    ResolverService resolverService;

    @RequestMapping(value = "/query",method = {RequestMethod.GET,RequestMethod.POST})
    public String query(@RequestParam(value = "question") String question,
                        @RequestParam(value = "instrument_id")String instrument_id) {
        String query = resolverService.query(question);
        System.out.println("参数："+"question: "+question+","+"instrument_id："+instrument_id);
        return query;
    }

}
