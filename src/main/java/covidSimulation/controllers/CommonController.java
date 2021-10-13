package covidSimulation.controllers;


import covidSimulation.repository.impl.IResultRepository;
import covidSimulation.repository.impl.ISimulationRepository;
import covidSimulation.session.SessionObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;

@Controller
public class CommonController {

    @Autowired
    ISimulationRepository simulationRepository;

    @Autowired
    IResultRepository resultRepository;

    @Resource
    SessionObject sessionObject;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String commonRedirect() {
        return "redirect:/main";

    }

    @RequestMapping(value = "/main", method = RequestMethod.GET)
    public String main(Model model) {
        {

            model.addAttribute("simulationModels", this.simulationRepository.getAllSimulation());

            model.addAttribute("filter", this.sessionObject.getFilter());
            return "main";
        }

    }


    @RequestMapping(value = "/filter", method = RequestMethod.POST)
    public String filter(@RequestParam String filter) {


        this.sessionObject.setFilter(filter);
        return "redirect:/main";

    }


}
