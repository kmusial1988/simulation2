package covidSimulation.repository;

import covidSimulation.model.SimulationModel;
import covidSimulation.repository.impl.ISimulationRepository;
import covidSimulation.service.impl.ISimulationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SimulationRepositoryImpl implements ISimulationRepository {

@Autowired
    ISimulationService simulationService;


    @Override
    public List<SimulationModel> getAllSimulation() {
        return this.simulationService.getAllSimulation();
    }

    @Override
    public List<SimulationModel> getSimulationByFilter(String filter) {
        return null;
    }

    @Override
    public SimulationModel getSimulationModelByName(String name) {
        return this.simulationService.getSimulationModelByName(name);
    }

    @Override
    public void addSimulation(SimulationModel simulationModel) {

    this.simulationService.addSimulation(simulationModel);
    }
}
