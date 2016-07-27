package io.zucchiniui.backend.scenario.domain;

import io.zucchiniui.backend.shared.domain.TagSelection;

public interface ScenarioQuery {

    ScenarioQuery withFeatureId(String featureId);

    ScenarioQuery withScenarioKey(String scenarioKey);

    ScenarioQuery withTestRunId(String testRunId);

    ScenarioQuery orderedByName();

    ScenarioQuery withSelectedTags(TagSelection tagSelection);

}