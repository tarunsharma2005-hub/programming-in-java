package com.tarun.scms;

import jakarta.persistence.*;

public class JpaDemo {
    public static void run() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("studentPU");
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            Student demo = new Student("JPA-DEMO", "JPA Demo Student", "Programming in Java", 88);
            em.persist(demo);
            em.getTransaction().commit();
            System.out.println("JPA entity persisted successfully: " + demo);
        } catch (Exception e) {
            if (em.getTransaction().isActive()) em.getTransaction().rollback();
            throw new AppException("JPA operation failed.", e);
        } finally {
            em.close();
            emf.close();
        }
    }
}
