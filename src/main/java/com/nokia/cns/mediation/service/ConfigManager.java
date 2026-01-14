package com.nokia.cns.mediation.service;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service("ConfigManagerService")
public class ConfigManager {

    private String config_data = "fn=naresh;ln=saw;company=nokia;city=bangalore;country=india;education=bsc";

    private Map<String, String> configs = new HashMap();

    private static ConfigManager INSTANCE = null;

    public synchronized  static ConfigManager getInstance(){
        if(INSTANCE == null){
            INSTANCE = new ConfigManager();
        }
        return INSTANCE;
    }

    private ConfigManager(){
        build(config_data);
    }

    private void  build(String config){
        String[] configAr = config.split(";");
        for (String s : configAr) {
            String[] tmpAr = s.split("=");
            configs.put(tmpAr[0], tmpAr[1]);
        }
    }

    public String getConfig(String k){
        return configs.get(k);
    }

    public Map<String, String> getAllConfigs() {
        return configs;
    }

}
