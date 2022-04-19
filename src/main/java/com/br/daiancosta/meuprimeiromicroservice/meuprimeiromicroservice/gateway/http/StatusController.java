package com.br.daiancosta.meuprimeiromicroservice.meuprimeiromicroservice.gateway.http;

import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Log4j2
public class StatusController {
    @GetMapping("/status")
    @ResponseBody
    public String status(){
        log.info("metodo status");
        return "ok";
    }
}
