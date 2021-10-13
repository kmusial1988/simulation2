package covidSimulation.model;

import javax.persistence.*;

@Entity(name = "tResultModel")
public class ResultModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false)
    private int infected_Pi;
    @Column(nullable = false)
    private String simulationName;
    @Column(nullable = false)
    private int canInfected_Pv;
    @Column(nullable = false)
    private int dead_Pm;
    @Column(nullable = false)
    private int peopleRecovered_Pr;

    public ResultModel(){
    }

    public ResultModel(int id, int infected_Pi, String simulationName, int canInfected_Pv, int dead_Pm, int peopleRecovered_Pr) {
        this.id = id;
        this.infected_Pi = infected_Pi;
        this.simulationName = simulationName;
        this.canInfected_Pv = canInfected_Pv;
        this.dead_Pm = dead_Pm;
        this.peopleRecovered_Pr = peopleRecovered_Pr;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getInfected_Pi() {
        return infected_Pi;
    }

    public void setInfected_Pi(int infected_Pi) {
        this.infected_Pi = infected_Pi;
    }

    public String getSimulationName() {
        return simulationName;
    }

    public void setSimulationName(String simulationName) {
        this.simulationName = simulationName;
    }

    public int getCanInfected_Pv() {
        return canInfected_Pv;
    }

    public void setCanInfected_Pv(int canInfected_Pv) {
        this.canInfected_Pv = canInfected_Pv;
    }

    public int getDead_Pm() {
        return dead_Pm;
    }

    public void setDead_Pm(int dead_Pm) {
        this.dead_Pm = dead_Pm;
    }

    public int getPeopleRecovered_Pr() {
        return peopleRecovered_Pr;
    }

    public void setPeopleRecovered_Pr(int peopleRecovered_Pr) {
        this.peopleRecovered_Pr = peopleRecovered_Pr;
    }

    @Override
    public String toString() {
        return "ResultModel{" +
                "id=" + id +
                ", infected_Pi=" + infected_Pi +
                ", simulationName='" + simulationName + '\'' +
                ", canInfected_Pv=" + canInfected_Pv +
                ", dead_Pm=" + dead_Pm +
                ", peopleRecovered_Pr=" + peopleRecovered_Pr +
                '}';
    }
}
