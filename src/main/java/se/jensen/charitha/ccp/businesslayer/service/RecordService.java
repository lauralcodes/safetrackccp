package se.jensen.charitha.ccp.businesslayer.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import se.jensen.charitha.ccp.businesslayer.entity.Record;
import se.jensen.charitha.ccp.businesslayer.mapper.RecordMapper;
import se.jensen.charitha.ccp.dataaccesslayer.repository.RecordRepository;
import se.jensen.charitha.ccp.presentationlayer.dto.RecordRequestDto;
import se.jensen.charitha.ccp.presentationlayer.dto.RecordResponseDto;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class RecordService {

    private final RecordRepository recordRepository;
    private final RecordMapper recordMapper;

    public RecordService(RecordRepository recordRepository, RecordMapper recordMapper) {
        this.recordRepository = recordRepository;
        this.recordMapper = recordMapper;
    }

    public RecordResponseDto addRecord(RecordRequestDto requestDto) {
        Record record = new Record();
        record.setOperatorId(requestDto.getOperatorId());
        record.setDate(requestDto.getDate() != null ? requestDto.getDate() : LocalDateTime.now());
        record.setParameter(requestDto.getParameter());
        record.setMeasurementValue(requestDto.getMeasurementValue());
        record.setUnit(requestDto.getUnit());

        Record saved = recordRepository.saveAndFlush(record);
        return recordMapper.toResponseDto(saved);
    }

    public Optional<Record> findRecordById(Long recordId) {
        return recordRepository.findById(recordId);
    }

    public List<Record> findRecordsByParameter(String parameter) {
        return recordRepository.findByParameter(parameter);
    }

    @Transactional
    public boolean deleteRecord(Long recordId) {
        if (!recordRepository.existsById(recordId)) {
            return false;
        }
        recordRepository.deleteById(recordId);
        return true;
    }
}
