package sessionFactory;

import entity.Customer;
import entity.Role;
import jakarta.persistence.Column;
import jakarta.persistence.Table;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Optional;
import java.util.stream.Collectors;


public class HibernateRunnerTest {
    /*
    @Test
    public void testHibernateApi() throws SQLException, IllegalAccessException {
        var customer = Customer.builder()
                .id(3)
                .firstName("Николай")
                .lastName("Свистун")
                .birthDate(LocalDate.of(2001, 10, 06))
                .age(23)
                .role(Role.USER)
                .build();
        var sql = """
                insert into
                %s
                (%s)
                values
                (%s)
                """;

        //%s
        var tableName = Optional.ofNullable(customer.getClass().getAnnotation(Table.class))
                .map(table -> table.name())
                .orElse(customer.getClass().getName());

        //(%s)
        Field[] fields = customer.getClass().getDeclaredFields();

        var columnNames = Arrays.stream(fields)
                .map(field -> Optional.ofNullable(field.getAnnotation(Column.class))
                        .map(Column::name)
                        .orElse(field.getName())
                ).collect(Collectors.joining(", "));

        var columnValues = Arrays.stream(fields)
                .map(field -> "?")
                .collect(Collectors.joining(", "));

        Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres",
                "postgres", "0092");
        PreparedStatement preparedStatement = connection
                .prepareStatement(sql.formatted(tableName, columnNames, columnValues));

        for (int i = 0; i < fields.length; i++) {
            fields[i].setAccessible(true);//без него не получим доступ к private полям
            preparedStatement.setObject(i + 1, fields[i].get(customer));
        }

        System.out.println(preparedStatement);

        preparedStatement.executeUpdate();
        preparedStatement.close();
        connection.close();
    }

 */
}
