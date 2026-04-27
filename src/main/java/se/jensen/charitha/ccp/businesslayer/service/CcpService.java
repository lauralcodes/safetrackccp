package se.jensen.charitha.ccp.businesslayer.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import se.jensen.charitha.ccp.businesslayer.entity.Ccp;
import se.jensen.charitha.ccp.businesslayer.mapper.CcpMapper;
import se.jensen.charitha.ccp.dataaccesslayer.repository.CcpRepository;
import se.jensen.charitha.ccp.presentationlayer.dto.CcpRequestDto;
import se.jensen.charitha.ccp.presentationlayer.dto.CcpResponseDto;
import java.util.Optional;

@Service
public class CcpService {

    private final CcpRepository ccpRepository;
    private final CcpMapper ccpMapper;

    public CcpService(CcpRepository ccpRepository, CcpMapper ccpMapper) {
        this.ccpRepository = ccpRepository;
        this.ccpMapper = ccpMapper;
    }

    public Page<Ccp> getAllCcp(Pageable pageable) {
        return ccpRepository.findAll(pageable);
    }

    public Optional<Ccp> getCcpById(Long id) {
        return ccpRepository.getCcpByCcpId(id);
    }

    public CcpResponseDto createCcp(CcpRequestDto requestDto) {
        Ccp ccp = new Ccp();
        ccp.setParameterName(requestDto.getParameterName());
        ccp.setDescription(requestDto.getDescription());
        ccp.setMinLimit(requestDto.getMinLimit());
        ccp.setMaxLimit(requestDto.getMaxLimit());

        Ccp savedCcp = ccpRepository.saveAndFlush(ccp);
        return ccpMapper.toResponseDto(savedCcp);
    }

    @Transactional
    public long deleteByParameterName(String parameterName) {
        return ccpRepository.deleteByParameterName(parameterName);
    }
}
