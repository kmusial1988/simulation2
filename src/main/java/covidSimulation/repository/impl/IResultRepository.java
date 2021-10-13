package covidSimulation.repository.impl;

import covidSimulation.model.ResultModel;

import java.util.List;

public interface IResultRepository {
    void addResult(ResultModel resultModel);

    List<ResultModel> getAllResultByName(String name);

}
