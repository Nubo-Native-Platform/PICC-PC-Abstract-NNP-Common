package com.nnp.common.abs.features.domainvalues.vo;


import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.TreeMap;

@Data
@EqualsAndHashCode(callSuper = true)
public class ConfigDomainSetVO extends TreeMap<String, TreeMap<String, ConfigDomainVO>> implements Serializable {
    private static final long serialVersionUID = 1L;
}
