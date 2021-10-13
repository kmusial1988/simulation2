package covidSimulation.DAO;

import covidSimulation.DAO.Impl.ISimulationDAO;
import covidSimulation.model.SimulationModel;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.NoResultException;
import java.util.List;

@Repository
public class SimulationDAOImpl implements ISimulationDAO {

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public void addSimulation(SimulationModel simulationModel) {
        Session session = sessionFactory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.saveOrUpdate(simulationModel);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
        } finally {
            session.close();
        }
    }

    @Override
    public void updateSimulation(SimulationModel simulationModel) {
        Session session = sessionFactory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.saveOrUpdate(simulationModel);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
        } finally {
            session.close();
        }
    }

    @Override
    public List<SimulationModel> getSimulationByFilter(String filter) {
        try {
            Session session = sessionFactory.openSession();
            Query<SimulationModel> query = session
                    .createQuery("FROM covidSimulation.model.SimulationModel WHERE name = :name");
            query.setParameter("name", filter);
            List<SimulationModel> result = query.getResultList();
            session.close();
            return result;
        } catch (NoResultException e) {
            return null;
        }
    }

    @Override
    public List<SimulationModel> getAllSimulation() {
        try {
            Session session = this.sessionFactory.openSession();
            Query<SimulationModel> query = session
                    .createQuery("FROM covidSimulation.model.SimulationModel");
            List<SimulationModel> result = query.getResultList();
            session.close();

            return result;
        } catch (NoResultException e) {
            return null;
        }

    }

    @Override
    public SimulationModel getSimulationModelByName(String name) {
        try {
            Session session = sessionFactory.openSession();
            Query<SimulationModel> query = session
                    .createQuery("FROM covidSimulation.model.SimulationModel WHERE name = :name");
            query.setParameter("name", name);
            SimulationModel simulationModel = query.getSingleResult();
            session.close();
            return simulationModel;
        } catch (NoResultException e) {
            return null;
        }
    }
}
