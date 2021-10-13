package covidSimulation.service.impl;

import covidSimulation.model.SimulationModel;

import java.util.List;

public interface ISimulationService {

    void addSimulation(SimulationModel simulationModel);
    void updateSimulation(SimulationModel simulationModel);
    List<SimulationModel> getAllSimulation();
    SimulationModel getSimulationModelByName(String name);

}
