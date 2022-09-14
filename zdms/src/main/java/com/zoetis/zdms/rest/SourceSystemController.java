package com.zoetis.zdms.rest;

import com.zoetis.zdms.api.dto.SourceSystemsResponseDto;
import com.zoetis.zdms.api.rest.SourceSystemApi;
import com.zoetis.zdms.mapper.SourceSystemMapper;
import com.zoetis.zdms.rest.factory.ResponseEntityFactory;
import com.zoetis.zdms.service.SourceSystemService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
@AllArgsConstructor
public class SourceSystemController implements SourceSystemApi {

    private final SourceSystemService sourceSystemService;

    private SourceSystemMapper sourceSystemMapper;

    @Override
    public ResponseEntity<SourceSystemsResponseDto> getSourceSystems() {
        Set<String> sourceSystemNames = sourceSystemService.getSourceSystemNames();

        SourceSystemsResponseDto sourceSystemDto = sourceSystemMapper.mapSourceSystemNamesToDto(sourceSystemNames);

        return ResponseEntityFactory.buildOk(sourceSystemDto);
    }
}
