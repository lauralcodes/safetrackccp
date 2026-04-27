package se.jensen.charitha.ccp.dataaccesslayer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import se.jensen.charitha.ccp.businesslayer.entity.Ccp;

import java.util.Optional;

@Repository
public interface CcpRepository extends JpaRepository<Ccp, Long> {
    Optional<Ccp> getCcpByCcpId(Long ccpId);

    long deleteByParameterName(String parameterName);
}
