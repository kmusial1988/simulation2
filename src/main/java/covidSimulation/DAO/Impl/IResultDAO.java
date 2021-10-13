package covidSimulation.DAO.Impl;

import covidSimulation.model.ResultModel;

import java.util.List;

public interface IResultDAO {

    void addResult(ResultModel resultModel);

    List<ResultModel> getAllResultByName(String name);


}
