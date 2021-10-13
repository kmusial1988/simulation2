package covidSimulation.service;

import covidSimulation.DAO.Impl.ISimulationDAO;
import covidSimulation.model.SimulationModel;
import covidSimulation.service.impl.ISimulationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SimulationServiceImpl implements ISimulationService {

    @Autowired
    ISimulationDAO simulationDAO;

    @Override
    public void addSimulation(SimulationModel simulationModel) {

        this.simulationDAO.addSimulation(simulationModel);
    }

    @Override
    public void updateSimulation(SimulationModel simulationModel) {

        this.simulationDAO.updateSimulation(simulationModel);
    }

    @Override
    public List<SimulationModel> getAllSimulation() {
        return this.simulationDAO.getAllSimulation();
    }

    @Override
    public SimulationModel getSimulationModelByName(String name) {
        return this.simulationDAO.getSimulationModelByName(name);
    }
}
