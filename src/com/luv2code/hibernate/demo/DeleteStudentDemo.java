package com.luv2code.hibernate.demo;

import com.luv2code.hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteStudentDemo {
    public static void main(String[] args) {
        // create session factory
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        // create session
        Session session = factory.getCurrentSession();
        try {
            int studentId = 4;

            // get a mew session and start transaction
            session = factory.getCurrentSession();
            session.beginTransaction();

            // retrieve student based on the idL: primary key
            Student myStudent = session.get(Student.class, studentId);

            // delete the student
//            System.out.println("Deleting student: " + myStudent);
//            session.delete(myStudent);

            System.out.println("Delting student id=2");
            session.createQuery("delete  from Student where id=11").executeUpdate();
            session.getTransaction().commit();
            System.out.println("Done :)");
        } finally {
            session.close();
        }
    }
}
