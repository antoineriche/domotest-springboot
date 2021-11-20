package com.ariche.domotest.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("cmd")
public class CommandController {

    @Value("${jeedom.api.base-url}")
    private String baseUrl;

    @Value("${jeedom.api.context}")
    private String context;

    @Value("${jeedom.api.key}")
    private String key;

    @GetMapping("/light-on")
    public String switchLightOnn() {
        return postCommand(52);
    }

    @GetMapping("/light-off")
    public String switchLightOff() {
        return postCommand(53);
    }

    @GetMapping("/{commandId}")
    public String applyCommand(@RequestParam("commandId") Integer commandId) {
        return postCommand(commandId);
    }

    private String postCommand(final int commandId) {
        return new RestTemplate().getForEntity(buildURL(commandId), String.class).getBody();
    }

    private String buildURL(final int commandId) {
        return "http://"
                .concat(baseUrl)
                .concat("/")
                .concat(context)
                .concat("?apikey=")
                .concat(key)
                .concat("&type=cmd")
                .concat("&id=")
                .concat(String.valueOf(commandId));
    }
}
