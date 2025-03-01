package sessionFactory;

//обязательно эту библиотеку
import converter.BirtdayConverter;
import entity.Birthday;
import entity.Customer;
import entity.Role;
import org.hibernate.cfg.Configuration;

import java.time.LocalDate;

public class HibernateRunner {
    public static void main(String[] args) {

        Configuration configuration = new Configuration(); //по сути то, что написано в файле cfg.xml
        configuration.configure();
        configuration.addAttributeConverter(new BirtdayConverter(), true);
//        configuration.addAnnotatedClass(Customer.class);
        //так хибернейт узнает о нашем классе Кастомер
        try ( var sessionFactory = configuration.buildSessionFactory();
              var session = sessionFactory.openSession()) {
            session.beginTransaction();
            Customer customer = Customer.builder()
                            .id(3)
                            .firstName("Nikolai10")
                            .lastName("Svi")
                            .birthDate(
                                    new Birthday(LocalDate.of(2000, 10, 06)))
                            .role(Role.ADMIN)
                            .build();
//            session.persist(customer); - сохраняет
//            session.merge(customer); - добавляет, если не было или обновляет существующий
//            session.remove(customer); - удаляет сущность из базы

            Customer customer1 = session.get(Customer.class, 1);
            System.out.println(customer1);
            session.getTransaction().commit();
        }
    }
}
