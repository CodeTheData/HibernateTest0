import entity.Birthday;
import entity.Customer;
import entity.PersonalInfo;
import entity.Role;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import util.HibernateUtil;


import java.time.LocalDate;

@Slf4j //ЗАМЕНЯЕТ ЭТУ СТРОКУ private static final Logger log = LoggerFactory.getLogger(HibernateRunner.class);
public class HibernateRunner {

    public static void main(String[] args) {

        //TRANSIENT
        Customer customer = Customer.builder()
                .username("ivan10@mail.ru")
                .personalInfo(PersonalInfo.builder()
                    .firstName("Ivan")
                    .lastName("Ivanov")
                    .birthDate(new Birthday(LocalDate.of(2000, 1, 19)))
                    .build())
                .role(Role.ADMIN)
                .build();
        log.info("Customer firstName is changed: {} ",customer);


        //TRANSIENT
        try (SessionFactory sessionFactory = HibernateUtil.buildSessionFactory()) {
            try (Session session1 = sessionFactory.openSession()) {
                session1.beginTransaction();

                //PERSISTENT k session1
                session1.persist(customer);

                log.debug("User: {}, session: {} ", customer, session1);
                session1.getTransaction().commit();

            }
        } catch (Exception e) {
            log.info("Exception: " + e);
            throw e;
        }
    }
}
