package com.nnp.common.abs.features.domainvalues.vo;


import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.io.Serializable;

@Data
public class ConfigDomainVO  implements Serializable {
    private static final long serialVersionUID = 1L;

    private String label;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Integer sequence;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Boolean defaultKey;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private ConfigDomainSetVO children;

}
