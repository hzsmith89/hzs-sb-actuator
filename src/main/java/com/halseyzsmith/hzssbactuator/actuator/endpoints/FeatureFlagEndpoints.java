package com.halseyzsmith.hzssbactuator.actuator.endpoints;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.actuate.endpoint.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Component
@Endpoint(id = "features")
public class FeatureFlagEndpoints {

    private final Map<String, Feature> features = getFeatures();

    @ReadOperation
    public Map<String, Feature> features() {
        return features;
    }

    @ReadOperation
    public Feature feature(@Selector String name) {
        return features.get(name);
    }

    @WriteOperation
    public void configureFeature(@Selector String name, Feature feature) {
        features.put(name, feature);
    }

    @DeleteOperation
    public void deleteFeature(@Selector String name) {
        features.remove(name);
    }

    @Getter
    @Setter
    @AllArgsConstructor
    public static class Feature {
        private Boolean enabled;
    }

    private Map<String, Feature> getFeatures() {
        Map<String, Feature> featuresMap = new ConcurrentHashMap<>();
        featuresMap.put("Ebooks", new Feature(true));
        featuresMap.put("AudioBooks", new Feature(false));
        return featuresMap;
    }
}
