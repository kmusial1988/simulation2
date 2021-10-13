package covidSimulation.service.impl;

import covidSimulation.model.ResultModel;

import java.util.List;

public interface IResultService {
    void addResult(ResultModel resultModel);


    List<ResultModel> getAllResultByName(String name);



}
