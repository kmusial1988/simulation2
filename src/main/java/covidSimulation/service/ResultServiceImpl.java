package covidSimulation.service;

import covidSimulation.DAO.Impl.IResultDAO;
import covidSimulation.model.ResultModel;
import covidSimulation.service.impl.IResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResultServiceImpl implements IResultService {
    @Autowired
    IResultDAO resultDAO;


    @Override
    public void addResult(ResultModel resultModel) {
        this.resultDAO.addResult(resultModel);
    }




    @Override
    public List<ResultModel> getAllResultByName(String name) {
        return this.resultDAO.getAllResultByName(name);
    }



}
