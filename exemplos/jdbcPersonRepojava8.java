import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * jdbcPersonRepojava8
 */
public class jdbcPersonRepojava8 {

    public List<Person> findAll() {
        List<Person> persons;

        String sql = "select p.id as ID, p.name as Name " +
                "p.last as LastName from PERSON p ";

        // dataSource seria outra classe da aplicacao que prove a conecao.
        try (Connection conn = dataSource.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql)) {

            try (ResultSet rs = ps.executeQuery();) {

                while (rs.next()) {
                    Person p = new Person();
                    p.setId(rs.getInt("ID"));
                    p.setName(rs.getString("Name"));
                    p.setLastName(rs.getString("LastName"));
                    persons.add(p);
                }
            }

        } catch (SQLException ex) {
            throw new RuntimeException("Person not found!", ex);
        }

        return persons;
    }

}