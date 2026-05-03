package se.jensen.charitha.ccp.presentationlayer.controller;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import se.jensen.charitha.ccp.businesslayer.mapper.CcpMapper;
import se.jensen.charitha.ccp.businesslayer.service.CcpService;
import se.jensen.charitha.ccp.presentationlayer.dto.CcpRequestDto;
import se.jensen.charitha.ccp.presentationlayer.dto.CcpResponseDto;

import java.util.Optional;


@RestController
@RequestMapping("/CCP")
public class CcpController {

    private final CcpService ccpService;
    private final CcpMapper ccpMapper;

    public CcpController(CcpService ccpService, CcpMapper ccpMapper) {
        this.ccpService = ccpService;
        this.ccpMapper = ccpMapper;
    }

    @GetMapping("/list")
    public ResponseEntity<Page<CcpResponseDto>> getCcp(Pageable pageable) {
        Page<CcpResponseDto> page = ccpService.getAllCcp(pageable)
                .map(ccpMapper::toResponseDto);

        if (page.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(page);
    }


    @GetMapping("/{id}")
    public ResponseEntity<CcpResponseDto> getCcpById(@PathVariable Long id) {

        Optional<CcpResponseDto> ccp = ccpService.getCcpById(id)
                .map(ccpMapper::toResponseDto);

        return ccp
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }


    @PostMapping("/add")
    public ResponseEntity<CcpResponseDto> addCcp(@RequestBody CcpRequestDto requestDto) {
        CcpResponseDto createdCcp = ccpService.createCcp(requestDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdCcp);
    }

    @DeleteMapping("/{parameterName}")
    public ResponseEntity<Void> deleteByParameterName(@PathVariable String parameterName) {
        long deletedCount = ccpService.deleteByParameterName(parameterName);

        if (deletedCount == 0) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.noContent().build();
    }

}
