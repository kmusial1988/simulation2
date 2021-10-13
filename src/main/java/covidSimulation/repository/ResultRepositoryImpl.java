package covidSimulation.repository;

import covidSimulation.model.ResultModel;
import covidSimulation.repository.impl.IResultRepository;
import covidSimulation.service.impl.IResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ResultRepositoryImpl implements IResultRepository {

    @Autowired
    IResultService resultService;

    @Override
    public void addResult(ResultModel resultModel) {
        this.resultService.addResult(resultModel);

    }

    @Override
    public List<ResultModel> getAllResultByName(String name) {
        return this.resultService.getAllResultByName(name);
    }
}
