package se.jensen.charitha.ccp.dataaccesslayer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import se.jensen.charitha.ccp.businesslayer.entity.Record;

import java.util.List;

@Repository
public interface RecordRepository extends JpaRepository<Record, Long> {
    List<Record> findByParameterIgnoreCase(String parameter);
}
