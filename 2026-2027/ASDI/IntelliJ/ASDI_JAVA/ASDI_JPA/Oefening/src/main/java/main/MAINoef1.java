package main;

<<<<<<< HEAD
import domein.Docent;

import java.math.BigDecimal;

import jakarta.persistence.EntityManager;
import util.JPAUtil;

public class MAINoef1 {

    public void main() {

        Docent d1 = new Docent(123, "Jan", "Baard", new BigDecimal(8000));
        Docent d2 = new Docent(456, "Piet", "Baard", new BigDecimal(10000));
        Docent d3 = new Docent(789, "Joris", "ZonderBaard", new BigDecimal(12000));

        //vraag aan de factory een entityManager
        try (EntityManager em = JPAUtil.getENTITY_MANAGER_FACTORY().createEntityManager()) {
            //start een transactie
            em.getTransaction().begin();
            //persisteer de 3 objecten
            em.persist(d1);
            em.persist(d2);
            em.persist(d3);
            //commit
            em.getTransaction().commit();
        }

        //sluit de factory
        JPAUtil.getENTITY_MANAGER_FACTORY().close();
    }

}
=======
public class MAINoef1 {
}
>>>>>>> c39e1c38c8c5d60ff0be1122d8d3f5413ca87126
