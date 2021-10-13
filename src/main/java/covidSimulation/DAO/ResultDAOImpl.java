package covidSimulation.DAO;

import covidSimulation.DAO.Impl.IResultDAO;
import covidSimulation.model.ResultModel;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.NoResultException;
import java.util.List;

@Repository
public class ResultDAOImpl implements IResultDAO {


    @Autowired
    SessionFactory sessionFactory;

    @Override
    public void addResult(ResultModel resultModel) {
        Session session = sessionFactory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.saveOrUpdate(resultModel);
            tx.commit();
        } catch (Exception e) {
            if(tx != null) {
                tx.rollback();
            }
        } finally {
            session.close();
        }
    }

    @Override
    public List<ResultModel> getAllResultByName(String name) {
        try {
            Session session = this.sessionFactory.openSession();

            Query<ResultModel> query = session
                    .createQuery("FROM covidSimulation.model.ResultModel WHERE name = :name");
            query.setParameter("name", name);
            List<ResultModel> result = query.getResultList();
            session.close();
            return result;
        } catch (NoResultException e) {
            return null;
        }
    }
}
