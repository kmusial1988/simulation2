package covidSimulation.model;


import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity(name = "tSimulationModel")
public class SimulationModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false, unique = true)
    private String name;
    @Column(nullable = false)
    private int population_P;
    @Column(nullable = false)
    private int startInfected_I;
    @Column(nullable = false)
    private double factor_R;
    @Column(nullable = false)
    private int mortalityFactor_M;
    @Column(nullable = false)
    private int recoveryTime_Ti;
    @Column(nullable = false)
    private int mortalityTime_Tm;
    @Column(nullable = false)
    private int simulationDays_Ts;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<ResultModel> resultModels = new HashSet<>();

    public SimulationModel() {
    }

    public SimulationModel(int id, String name, int population_P, int startInfected_I, double factor_R, int mortalityFactor_M, int recoveryTime_Ti, int mortalityTime_Tm, int simulationDays_Ts, Set<ResultModel> resultModels) {
        this.id = id;
        this.name = name;
        this.population_P = population_P;
        this.startInfected_I = startInfected_I;
        this.factor_R = factor_R;
        this.mortalityFactor_M = mortalityFactor_M;
        this.recoveryTime_Ti = recoveryTime_Ti;
        this.mortalityTime_Tm = mortalityTime_Tm;
        this.simulationDays_Ts = simulationDays_Ts;
        this.resultModels = resultModels;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPopulation_P() {
        return population_P;
    }

    public void setPopulation_P(int population_P) {
        this.population_P = population_P;
    }

    public int getStartInfected_I() {
        return startInfected_I;
    }

    public void setStartInfected_I(int startInfected_I) {
        this.startInfected_I = startInfected_I;
    }

    public double getFactor_R() {
        return factor_R;
    }

    public void setFactor_R(double factor_R) {
        this.factor_R = factor_R;
    }

    public int getMortalityFactor_M() {
        return mortalityFactor_M;
    }

    public void setMortalityFactor_M(int mortalityFactor_M) {
        this.mortalityFactor_M = mortalityFactor_M;
    }

    public int getRecoveryTime_Ti() {
        return recoveryTime_Ti;
    }

    public void setRecoveryTime_Ti(int recoveryTime_Ti) {
        this.recoveryTime_Ti = recoveryTime_Ti;
    }

    public int getMortalityTime_Tm() {
        return mortalityTime_Tm;
    }

    public void setMortalityTime_Tm(int mortalityTime_Tm) {
        this.mortalityTime_Tm = mortalityTime_Tm;
    }

    public int getSimulationDays_Ts() {
        return simulationDays_Ts;
    }

    public void setSimulationDays_Ts(int simulationDays_Ts) {
        this.simulationDays_Ts = simulationDays_Ts;
    }

    public Set<ResultModel> getResultModels() {
        return resultModels;
    }

    public void setResultModels(Set<ResultModel> resultModels) {
        this.resultModels = resultModels;
    }

    @Override
    public String toString() {
        return "SimulationModel{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", population_P=" + population_P +
                ", startInfected_I=" + startInfected_I +
                ", factor_R=" + factor_R +
                ", mortalityFactor_M=" + mortalityFactor_M +
                ", recoveryTime_Ti=" + recoveryTime_Ti +
                ", mortalityTime_Tm=" + mortalityTime_Tm +
                ", simulationDays_Ts=" + simulationDays_Ts +
                ", resultModels=" + resultModels +
                '}';
    }


}

