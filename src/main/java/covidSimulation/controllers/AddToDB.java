package covidSimulation.controllers;


import covidSimulation.model.ResultModel;
import covidSimulation.model.SimulationModel;
import covidSimulation.service.impl.IResultService;
import covidSimulation.service.impl.ISimulationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
@RequestMapping(value = "/admin/utils")
public class AddToDB {

    @Autowired
    IResultService resultService;

    @Autowired
    ISimulationService simulationService;



    @RequestMapping(value = "/addSimulation", method = RequestMethod.GET)
    public String addSimulation() {
        SimulationModel simulationModel = new SimulationModel();

        simulationModel.setName("Polska");
        simulationModel.setPopulation_P(10000);
        simulationModel.setStartInfected_I(50);
        simulationModel.setFactor_R(0.3);
        simulationModel.setMortalityFactor_M(5);
        simulationModel.setRecoveryTime_Ti(14);
        simulationModel.setMortalityTime_Tm(11);
        simulationModel.setSimulationDays_Ts(20);
//        simulationModel.setResultModels();

        SimulationModel simulationModel2 = new SimulationModel();

        simulationModel2.setName("Niemcy");
        simulationModel2.setPopulation_P(10500);
        simulationModel2.setStartInfected_I(60);
        simulationModel2.setFactor_R(0.5);
        simulationModel2.setMortalityFactor_M(7);
        simulationModel2.setRecoveryTime_Ti(19);
        simulationModel2.setMortalityTime_Tm(14);
        simulationModel2.setSimulationDays_Ts(16);
//        simulationModel2.setResultModels();

        simulationService.addSimulation(simulationModel);
        simulationService.addSimulation(simulationModel2);

        return "redirect:/main";

    }
    @RequestMapping(value = "/addResult", method = RequestMethod.GET)
    public String addResult() {

        ResultModel resultModel = new ResultModel();
        resultModel.setInfected_Pi(12);
        resultModel.setSimulationName("Polska");
        resultModel.setCanInfected_Pv(14);
        resultModel.setDead_Pm(111);
        resultModel.setPeopleRecovered_Pr(15);

        ResultModel resultModel2 = new ResultModel();
        resultModel2.setInfected_Pi(14);
        resultModel2.setSimulationName("Polska");
        resultModel2.setCanInfected_Pv(12);
        resultModel2.setDead_Pm(122);
        resultModel2.setPeopleRecovered_Pr(16);

        ResultModel resultModel3 = new ResultModel();
        resultModel3.setInfected_Pi(11);
        resultModel3.setSimulationName("Polska");
        resultModel3.setCanInfected_Pv(21);
        resultModel3.setDead_Pm(123);
        resultModel3.setPeopleRecovered_Pr(19);



        resultService.addResult(resultModel);
        resultService.addResult(resultModel2);
        resultService.addResult(resultModel3);

        return "redirect:/main";
    }






}
