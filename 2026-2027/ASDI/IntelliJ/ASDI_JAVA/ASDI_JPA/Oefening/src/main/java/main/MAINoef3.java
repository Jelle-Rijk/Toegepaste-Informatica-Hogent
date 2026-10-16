package main;

import domein.Campus;
import domein.Docent;
import domein.Werkruimte;

import java.math.BigDecimal;

import jakarta.persistence.EntityManager;
import util.JPAUtil;

public class MAINoef3 {
    void main() {
        Docent jan = new Docent(123, "Jan", "Baard", new BigDecimal(8000));
        Docent piet = new Docent(456, "Piet", "Baard", new BigDecimal(10000));
        Docent joris = new Docent(789, "Joris", "ZonderBaard", new BigDecimal(12000));
        Campus gent = new Campus("Gent");
        Campus aalst = new Campus("Aalst");

        Werkruimte zolder = new Werkruimte("SCH123", "zolder", 12, 6);
        Werkruimte kelder = new Werkruimte("SCH555", "kelder", 4, 4);
        Werkruimte dak = new Werkruimte("AA222", "dak", 10, 2);

        try (EntityManager em = JPAUtil.getENTITY_MANAGER_FACTORY().createEntityManager()) {
            em.getTransaction().begin();
            em.persist(jan);
            em.persist(piet);
            em.persist(joris);
            em.persist(gent);
            em.persist(aalst);
            em.persist(zolder);
            em.persist(kelder);
            em.persist(dak);
            em.getTransaction().commit();
        }
    }

}
