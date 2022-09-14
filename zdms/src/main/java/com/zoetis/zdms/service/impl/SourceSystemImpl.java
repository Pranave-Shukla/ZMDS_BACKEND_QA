package com.zoetis.zdms.service.impl;

import com.zoetis.zdms.dao.projection.SourceSystemName;
import com.zoetis.zdms.dao.repository.SourceSystemRepository;
import com.zoetis.zdms.service.SourceSystemService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Slf4j
public class SourceSystemImpl implements SourceSystemService {

    private SourceSystemRepository repository;

    @Override
    @Cacheable("getSourceSystemNames")
    public Set<String> getSourceSystemNames() {
        log.info("[getSourceSystemNames] started processing]");
        log.info("[findAllBy] invoked]");
        return repository.findAllBy().parallelStream()
                .map(SourceSystemName::getName)
                .collect(Collectors.toSet());
    }
}
