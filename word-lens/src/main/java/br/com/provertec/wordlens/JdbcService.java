package br.com.provertec.wordlens;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.sql.*;

public class JdbcService {
    @Resource(lookup = "java:jboss/datasources/ExampleDS")
    private DataSource ds;

    public int contarFrases() throws SQLException {
        try (Connection conn = ds.getConnection();
             PreparedStatement ps = conn.prepareStatement("SELECT COUNT(*) FROM FraseAnalise");
             ResultSet rs = ps.executeQuery()) {
            rs.next();
            return rs.getInt(1);
        }
    }
}