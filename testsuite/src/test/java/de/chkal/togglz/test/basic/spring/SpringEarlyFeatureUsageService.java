package de.chkal.togglz.test.basic.spring;

import javax.annotation.PostConstruct;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import de.chkal.togglz.core.context.FeatureContext;
import de.chkal.togglz.core.manager.FeatureManager;
import de.chkal.togglz.test.basic.BasicFeatures;

@Component
@Scope("singleton")
public class SpringEarlyFeatureUsageService {

    private boolean feature1Active;

    private boolean feature2Active;

    @PostConstruct
    public void init() {
        FeatureManager featureManager = FeatureContext.getFeatureManager();
        feature1Active = featureManager.isActive(BasicFeatures.FEATURE1);
        feature2Active = featureManager.isActive(BasicFeatures.FEATURE1);
    }

    public boolean isFeature1Active() {
        return feature1Active;
    }

    public boolean isFeature2Active() {
        return feature2Active;
    }

}
