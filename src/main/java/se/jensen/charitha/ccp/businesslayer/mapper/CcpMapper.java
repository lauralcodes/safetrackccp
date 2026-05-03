package se.jensen.charitha.ccp.businesslayer.mapper;

import org.springframework.stereotype.Component;
import se.jensen.charitha.ccp.businesslayer.entity.Ccp;
import se.jensen.charitha.ccp.presentationlayer.dto.CcpResponseDto;

@Component
public class CcpMapper {

    public CcpResponseDto toResponseDto(Ccp ccp) {
        return new CcpResponseDto(
                ccp.getCcpId(),
                ccp.getParameterName(),
                ccp.getDescription(),
                ccp.getUnit(),
                ccp.getMinLimit(),
                ccp.getMaxLimit()
        );
    }
}
