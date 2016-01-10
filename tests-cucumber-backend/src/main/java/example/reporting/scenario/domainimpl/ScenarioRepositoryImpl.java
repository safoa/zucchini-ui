package example.reporting.scenario.domainimpl;

import example.reporting.scenario.domain.Scenario;
import example.reporting.scenario.domain.ScenarioQuery;
import example.reporting.scenario.domain.ScenarioRepository;
import example.support.morphiaddd.MorphiaRepository;
import org.mongodb.morphia.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ScenarioRepositoryImpl extends MorphiaRepository<Scenario, String> implements ScenarioRepository {

    private final ScenarioDAO dao;

    @Autowired
    public ScenarioRepositoryImpl(final ScenarioDAO dao) {
        super(dao);
        this.dao = dao;
    }

    @Override
    public ScenarioQuery query() {
        return dao.createTypedQuery();
    }

    @Override
    public void deleteByTestRunId(final String testRunId) {
        final Query<Scenario> query = dao.prepareTypedQuery(q -> q.withTestRunId(testRunId));
        dao.deleteByQuery(query);
    }

    @Override
    public void deleteByFeatureId(final String featureId) {
        final Query<Scenario> query = dao.prepareTypedQuery(q -> q.withFeatureId(featureId));
        dao.deleteByQuery(query);
    }

}