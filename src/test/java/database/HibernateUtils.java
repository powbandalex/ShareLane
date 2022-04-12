package database;

import models.databasemodels.Student;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Iterator;
import java.util.List;

public class HibernateUtils {

    private static SessionFactory factory;

    public void createConnection(){
        try {
            factory = new Configuration().configure().buildSessionFactory();
        } catch (Throwable ex) {
            System.err.println("Failed to create sessionFactory object." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public void listStudents( ){
        Session session = factory.openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            List students = session.createQuery("FROM Student").list();
            for (Iterator iterator = students.iterator(); iterator.hasNext();){
                Student student = (Student) iterator.next();
                System.out.print(" First Name: " + student.getName());
            }
            tx.commit();
        } catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public Integer addStudent(String name, int groupId){
        Session session = factory.openSession();
        Transaction tx = null;
        Integer studentID = null;

        try {
            tx = session.beginTransaction();
            Student student = new Student(name, groupId);
            studentID = (Integer) session.save(student);
            tx.commit();
        } catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return studentID;
    }
}
