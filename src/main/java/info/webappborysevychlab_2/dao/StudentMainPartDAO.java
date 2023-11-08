package info.webappborysevychlab_2.dao;

import info.webappborysevychlab_2.dbutil.HibernateUtil;
import info.webappborysevychlab_2.entities.StudentMainPart;
import org.hibernate.Session;
import org.hibernate.Transaction;
import java.util.List;

public class StudentMainPartDAO implements InterfaceDAO<StudentMainPart> {
    @Override
    public List<StudentMainPart> getAllList() {
        List<StudentMainPart> StudentMainPartList;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            StudentMainPartList = session.createQuery("FROM StudentMainPart", StudentMainPart.class).getResultList();
        }
        return StudentMainPartList;
    }
    @Override
    public StudentMainPart findById(Long id) {
        StudentMainPart StudentMainPart;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            StudentMainPart = session.get(StudentMainPart.class, id);
        }
        return StudentMainPart;
    }
    @Override
    public boolean insert(StudentMainPart StudentMainPartToInsert) {
        boolean result;
        Session session = null;
        Transaction transaction = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            session.save(StudentMainPartToInsert);
            transaction.commit();
            result = true;
        } catch (Exception exception) {
            if (transaction != null)
                transaction.rollback();
            System.err.println("Error: insert data " + getClass());
            result = false;
        }
        if (session != null)
            session.close();
        return result;
    }
    @Override
    public boolean update(Long idOfUpdatableRow, StudentMainPart StudentMainPartToUpdate) {
        boolean result;
        StudentMainPart StudentMainPartInTable = findById(idOfUpdatableRow);
        if (StudentMainPartInTable == null) {
            System.err.println("Object which should be updated don`t exist");
            result = false;
        } else {
            Session session = null;
            Transaction transaction = null;
            try {
                session = HibernateUtil.getSessionFactory().openSession();
                transaction = session.beginTransaction();
                StudentMainPartToUpdate.setId(StudentMainPartInTable.getId());
                session.update(StudentMainPartToUpdate);
                transaction.commit();
                result = true;
            } catch (Exception exception) {
                if (transaction != null)
                    transaction.rollback();
                System.err.println("Error: update data " + getClass());
                result = false;
            }
            if (session != null)
                session.close();
        }
        return result;
    }
    @Override
    public boolean delete(StudentMainPart StudentMainPartToDelete) {
        boolean result;
        StudentMainPart StudentMainPartInTable = findById(StudentMainPartToDelete.getId());
        if (StudentMainPartInTable == null) {
            System.err.println("Object which should be deleted don`t exist");
            result = false;
        } else {
            Session session = null;
            Transaction transaction = null;
            try {
                session = HibernateUtil.getSessionFactory().openSession();
                transaction = session.beginTransaction();
                session.delete(StudentMainPartToDelete);
                transaction.commit();
                result = true;
            } catch (Exception exception) {
                if (transaction != null)
                    transaction.rollback();
                System.err.println("Error: delete data " + getClass());
                result = false;
            }
            if (session != null)
                session.close();
        }
        return result;
    }
}
