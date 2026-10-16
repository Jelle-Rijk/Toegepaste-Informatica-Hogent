package main;

<<<<<<< HEAD
import domein.Docent;
import jakarta.persistence.EntityManager;
import util.JPAUtil;

import java.math.BigDecimal;

public class MAINoef2 {
    void main() {

        try (EntityManager em = JPAUtil.getENTITY_MANAGER_FACTORY().createEntityManager()) {
            em.getTransaction().begin();
            Docent docent = em.find(Docent.class, 2L);
            if (docent != null)
                docent.setWedde(docent.getWedde().add(new BigDecimal(200)));
            em.getTransaction().commit();
        }
    }
=======
public class MAINoef2 {
>>>>>>> c39e1c38c8c5d60ff0be1122d8d3f5413ca87126
}
