package com.nnp.common.abs.features.domainvalues.controller;

import com.nnp.common.abs.features.domainvalues.service.IConfigDomainService;
import com.nnp.common.abs.features.domainvalues.vo.ConfigDomainSetVO;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping(value = "/config")
public class ConfigController  {


    private final IConfigDomainService configDomainService;
    public ConfigController(IConfigDomainService configDomainService) {
        this.configDomainService = configDomainService;
    }
    @GetMapping(value = "/domain", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ConfigDomainSetVO> getConfigDomain() {
        ConfigDomainSetVO vo = configDomainService.fetchDomains();
        return new ResponseEntity<>(vo, HttpStatus.OK);
    }

}
