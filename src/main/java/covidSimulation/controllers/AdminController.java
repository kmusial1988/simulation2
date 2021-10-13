package covidSimulation.controllers;

import covidSimulation.model.SimulationModel;
import covidSimulation.repository.impl.ISimulationRepository;
import covidSimulation.service.impl.ISimulationService;
import covidSimulation.session.SessionObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;

@Controller
public class AdminController {

    @Resource
    SessionObject sessionObject;

    @Autowired
    ISimulationRepository simulationRepository;

    @Autowired
    ISimulationService simulationService;

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String addSimulation(Model model) {

        model.addAttribute("simulationModel", new SimulationModel());
        model.addAttribute("info", this.sessionObject.getInfo());

        return "add";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addProduct(@ModelAttribute SimulationModel simulationModel) {


        SimulationModel simulationModel1DB = this.simulationService.getSimulationModelByName(simulationModel.getName());

        if (simulationModel1DB != null) {
            this.sessionObject.setInfo(" Symulacja już istnieje !!!");
        } else {
            if (simulationModel.getName().equals("") || simulationModel.getPopulation_P() == 0.0 ||
                    simulationModel.getStartInfected_I() == 0.0 || simulationModel.getFactor_R() == 0.0 ||
                    simulationModel.getMortalityFactor_M() == 0.0 || simulationModel.getRecoveryTime_Ti() == 0.0 ||
                    simulationModel.getMortalityTime_Tm() == 0.0 || simulationModel.getSimulationDays_Ts() == 0.0) {


                this.sessionObject.setInfo("Uzupełnij formularz!!!");
            } else {
                this.simulationRepository.addSimulation(simulationModel);
                this.sessionObject.setInfo("Dodano nową symulacje !!!");
            }
        }
        return "redirect:/main";
    }

    @RequestMapping(value = "/edit/{name}", method = RequestMethod.GET)
    public String editSimulation(@PathVariable String name, Model model) {

        SimulationModel simulationModel = this.simulationRepository.getSimulationModelByName(name);
        model.addAttribute("simulationModel", simulationModel);

        return "edit";
    }

    @RequestMapping(value = "/edit/{name}", method = RequestMethod.POST)
    public String editSimulationModel(@ModelAttribute SimulationModel simulationModel, @PathVariable String name) {




        SimulationModel simulationModelDB = this.simulationRepository.getSimulationModelByName(simulationModel.getName());

        simulationModelDB.setPopulation_P(simulationModel.getPopulation_P());
        simulationModelDB.setStartInfected_I(simulationModel.getStartInfected_I());
        simulationModelDB.setFactor_R(simulationModel.getFactor_R());
        simulationModelDB.setMortalityFactor_M(simulationModel.getMortalityFactor_M());
        simulationModelDB.setRecoveryTime_Ti(simulationModel.getRecoveryTime_Ti());
        simulationModelDB.setMortalityTime_Tm(simulationModel.getMortalityTime_Tm());
        simulationModelDB.setSimulationDays_Ts(simulationModel.getSimulationDays_Ts());


        this.simulationRepository.addSimulation(simulationModelDB);
        this.simulationService.updateSimulation(simulationModelDB);

        return "redirect:/main";

    }

//    @GetMapping("/api/employees/{id}/{name}")
//    @ResponseBody
//    public String getEmployeesByIdAndName(@PathVariable String id, @PathVariable String name) {
//        return "ID: " + id + ", name: " + name;


//    @RequestMapping(value = "/details/{name}", method = RequestMethod.GET)
//    public String detailsSimulation(@PathVariable String name, Model model) {
//
//        SimulationModel simulationModel = this.simulationRepository.getSimulationModelByName(name);
//        model.addAttribute("simulationModel", simulationModel);
//
//
//
//
//        return "details";
//    }




}
