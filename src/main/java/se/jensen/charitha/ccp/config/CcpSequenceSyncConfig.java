package se.jensen.charitha.ccp.config;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@Component
public class CcpSequenceSyncConfig {

    private final JdbcTemplate jdbcTemplate;
    private final DataSource dataSource;

    public CcpSequenceSyncConfig(JdbcTemplate jdbcTemplate, DataSource dataSource) {
        this.jdbcTemplate = jdbcTemplate;
        this.dataSource = dataSource;
    }

    @EventListener(ApplicationReadyEvent.class)
    public void syncSequence() throws SQLException {
        try (Connection connection = dataSource.getConnection()) {
            String databaseProductName = connection.getMetaData().getDatabaseProductName();

            if (!"PostgreSQL".equalsIgnoreCase(databaseProductName)) {
                return;
            }
        }

        jdbcTemplate.execute(
                "SELECT setval('ccp_seq', COALESCE((SELECT MAX(ccp_id) FROM ccp), 0) + 1, false)"
        );
    }
}
