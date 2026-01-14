package com.nokia.cns.mediation.controller;

import com.nokia.cns.mediation.service.ConfigManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/configmanager")
public class ConfigManagerController {

    private ConfigManager configManager = ConfigManager.getInstance();

    @Autowired()
    private ConfigManager configManagerService;

    @GetMapping(produces = "application/json")
    public Map<String, String> getConfig(@RequestParam String key){
        String value = configManager.getConfig(key);
        if(value == null){
            value ="Key not found";
        }
       return Map.of("key", key, "value", value);
    }

    @GetMapping(path = "all-config", produces = "application/json")
    public Map<String, String> getAllConfig(){
        // cleaner and springway to use the bean, we don't need singleton pattern if we use bean
        return  configManagerService.getAllConfigs();
    }
}
