package covidSimulation.DAO.Impl;

import covidSimulation.model.SimulationModel;

import java.util.List;

public interface ISimulationDAO {
    void addSimulation(SimulationModel simulationModel);
    void updateSimulation(SimulationModel simulationModel);
    List<SimulationModel>getSimulationByFilter(String filter);
    List<SimulationModel> getAllSimulation();
    SimulationModel getSimulationModelByName(String name);


}
