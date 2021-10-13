package covidSimulation.controllers;

import covidSimulation.model.SimulationModel;
import covidSimulation.repository.impl.ISimulationRepository;
import covidSimulation.service.impl.IResultService;
import covidSimulation.service.impl.ISimulationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ResultCortroller {

    @Autowired
    ISimulationService simulationService;

    @Autowired
    IResultService resultService;

    @Autowired
    ISimulationRepository simulationRepository;


    @RequestMapping(value = "/details/{name}", method = RequestMethod.GET)
    public String detailsSimulation(@PathVariable String name, Model model) {

        SimulationModel simulationModel = this.simulationRepository.getSimulationModelByName(name);
        model.addAttribute("simulationModel", simulationModel);
        int resultModelI = simulationModel.getStartInfected_I();
        double resultModelR = simulationModel.getFactor_R();
        int resultModelTs = simulationModel.getSimulationDays_Ts();
        int resultModelTm = simulationModel.getMortalityTime_Tm();
        double resultModelM = simulationModel.getMortalityFactor_M();
        int resultModelTi = simulationModel.getRecoveryTime_Ti();
        int resultModelP = simulationModel.getPopulation_P();


        return "details";
    }








}
