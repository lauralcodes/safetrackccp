package se.jensen.charitha.ccp.businesslayer.mapper;

import org.springframework.stereotype.Component;
import se.jensen.charitha.ccp.businesslayer.entity.Record;
import se.jensen.charitha.ccp.presentationlayer.dto.RecordResponseDto;

@Component
public class RecordMapper {

    public RecordResponseDto toResponseDto(Record record) {
        return new RecordResponseDto(
                record.getRecordId(),
                record.getOperatorId(),
                record.getDate(),
                record.getParameter(),
                record.getMeasurementValue(),
                record.getUnit()
        );
    }
}
