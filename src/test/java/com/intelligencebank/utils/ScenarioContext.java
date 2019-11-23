package com.intelligencebank.utils;

import java.util.HashMap;
import java.util.Map;

public class ScenarioContext {
	 
	private  Map<String, Object> scenarioContext;

    public ScenarioContext(){
        scenarioContext = new HashMap<>();
    }

    public void setValue(String key, Object value) {
        scenarioContext.put(key, value);
    }

    public void setParameter(TestNGParameter param, Object value) {
        scenarioContext.put(param.toString(), value);
    }

    public void setTestNGParameters(TestNGParameters parameters) {
        scenarioContext.put(TestNGParameter.EnvironmentName.toString(), parameters.EnvironmentName);
        scenarioContext.put(TestNGParameter.BaseURL.toString(), parameters.BaseURL);

        scenarioContext.put(TestNGParameter.Browser.toString(), parameters.Browser);
        scenarioContext.put(TestNGParameter.Headless.toString(), parameters.Headless);
        scenarioContext.put(TestNGParameter.SiteName.toString(), parameters.SiteName);
    }

    public Object getValue(String key){
        return scenarioContext.get(key.toString());
    }

    public Object getParameter(TestNGParameter param){
        return scenarioContext.get(param.toString());
    }

    public Boolean contains(String key){
        return scenarioContext.containsKey(key);
    }

    public Boolean contains(TestNGParameter param){
        return scenarioContext.containsKey(param.toString());
    }

    public void clear() {
        scenarioContext.clear();
    }
}
