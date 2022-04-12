package database;

public class HibernateDemo {

    public static void main(String[] args) {
        HibernateUtils hibernateUtils = new HibernateUtils();
        hibernateUtils.createConnection();
        hibernateUtils.addStudent("Anna", 1);
        hibernateUtils.listStudents();
    }
}
