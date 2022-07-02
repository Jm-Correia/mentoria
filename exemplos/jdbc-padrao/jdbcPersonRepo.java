import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * jdbcPersonRepo
 */
public class jdbcPersonRepo {

    public List<Person> findAll() {
        List<Person> persons;

        String sql = "select p.id as ID, p.name as Name " +
                "p.last as LastName from PERSON p ";

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            // dataSource seria outra classe da aplicacao que prove a conecao.
            conn = dataSource.getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Person p = new Person();
                p.setId(rs.getInt("ID"));
                p.setName(rs.getString("Name"));
                p.setLastName(rs.getString("LastName"));
                persons.add(p);
            }
        } catch (SQLException ex) {
            throw new RuntimeException("Person not found!", ex);
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException ex) {
                }
            }
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException ex) {
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                }
            }
        }

        return persons;
    }

}