package covidSimulation.repository.impl;

import covidSimulation.model.SimulationModel;

import java.util.List;

public interface ISimulationRepository {
    List<SimulationModel> getAllSimulation();
    List<SimulationModel>getSimulationByFilter(String filter);
    SimulationModel getSimulationModelByName(String name);
    void addSimulation(SimulationModel simulationModel);
}
