package se.jensen.charitha.ccp.presentationlayer.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import se.jensen.charitha.ccp.businesslayer.mapper.RecordMapper;
import se.jensen.charitha.ccp.businesslayer.service.RecordService;
import se.jensen.charitha.ccp.presentationlayer.dto.RecordRequestDto;
import se.jensen.charitha.ccp.presentationlayer.dto.RecordResponseDto;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/records")
public class RecordController {

    private final RecordService recordService;
    private final RecordMapper recordMapper;

    public RecordController(RecordService recordService, RecordMapper recordMapper) {
        this.recordService = recordService;
        this.recordMapper = recordMapper;
    }

    @PostMapping
    public ResponseEntity<RecordResponseDto> addRecord(@RequestBody RecordRequestDto requestDto) {
        RecordResponseDto created = recordService.addRecord(requestDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RecordResponseDto> getRecordById(@PathVariable Long id) {
        Optional<RecordResponseDto> record = recordService.findRecordById(id)
                .map(recordMapper::toResponseDto);

        return record
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/parameter/{parameter}")
    public ResponseEntity<List<RecordResponseDto>> getRecordsByParameter(@PathVariable String parameter) {
        List<RecordResponseDto> records = recordService.findRecordsByParameter(parameter)
                .stream()
                .map(recordMapper::toResponseDto)
                .toList();

        if (records.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(records);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRecord(@PathVariable Long id) {
        boolean deleted = recordService.deleteRecord(id);
        if (!deleted) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.noContent().build();
    }
}
