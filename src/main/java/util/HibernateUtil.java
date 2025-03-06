package util;

import converter.BirtdayConverter;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
    public static SessionFactory buildSessionFactory() {

        Configuration configuration = new Configuration().configure(); //по сути то, что написано в файле cfg.xml
        configuration.configure();
        configuration.addAttributeConverter(new BirtdayConverter());
        return configuration.buildSessionFactory();

    }
}
