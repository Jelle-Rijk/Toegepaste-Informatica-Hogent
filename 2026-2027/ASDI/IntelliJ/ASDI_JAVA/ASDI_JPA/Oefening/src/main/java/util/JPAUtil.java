package util;

<<<<<<< HEAD
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class JPAUtil {
    @Getter
    private final static EntityManagerFactory ENTITY_MANAGER_FACTORY = Persistence.createEntityManagerFactory("school");
=======
public class JPAUtil {
>>>>>>> c39e1c38c8c5d60ff0be1122d8d3f5413ca87126
}
