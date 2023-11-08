package info.webappborysevychlab_2.dao;

import info.webappborysevychlab_2.dbutil.HibernateUtil;
import info.webappborysevychlab_2.entities.StudentAddPart;
import org.hibernate.Session;
import org.hibernate.Transaction;
import java.util.List;

public class StudentAddPartDAO implements InterfaceDAO<StudentAddPart> {
    @Override
    public List<StudentAddPart> getAllList() {
        List<StudentAddPart> StudentAddPartList;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            StudentAddPartList = session.createQuery("FROM StudentAddPart", StudentAddPart.class).getResultList();
        }
        return StudentAddPartList;
    }
    @Override
    public StudentAddPart findById(Long id) {
        StudentAddPart StudentAddPart;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            StudentAddPart = session.get(StudentAddPart.class, id);
        }
        return StudentAddPart;
    }
    @Override
    public boolean insert(StudentAddPart StudentAddPartToInsert) {
        boolean result;
        Session session = null;
        Transaction transaction = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            session.save(StudentAddPartToInsert);
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
    public boolean update(Long idOfUpdatableRow, StudentAddPart StudentAddPartToUpdate) {
        boolean result;
        StudentAddPart StudentAddPartInTable = findById(idOfUpdatableRow);
        if (StudentAddPartInTable == null) {
            System.err.println("Object which should be updated don`t exist");
            result = false;
        } else {
            Session session = null;
            Transaction transaction = null;
            try {
                session = HibernateUtil.getSessionFactory().openSession();
                StudentAddPartToUpdate.setStudentMainPartId(StudentAddPartInTable.getStudentMainPartId());
                transaction = session.beginTransaction();
                session.update(StudentAddPartToUpdate);
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
    public boolean delete(StudentAddPart StudentAddPartToDelete) {
        boolean result;
        StudentAddPart StudentAddPartInTable = findById(StudentAddPartToDelete.getStudentMainPartId());
        if (StudentAddPartInTable == null) {
            System.err.println("Object which should be deleted don`t exist");
            result = false;
        } else {
            Session session = null;
            Transaction transaction = null;
            try {
                session = HibernateUtil.getSessionFactory().openSession();
                transaction = session.beginTransaction();
                session.delete(StudentAddPartToDelete);
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
