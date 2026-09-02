package com.nnp.common.abs.features.domainvalues.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Where;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "cfg_domain",schema = "common")
public class ConfigDomain  implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id", nullable = false)
    private String id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "value_key", nullable = false)
    private String key;

    @Column(name = "value_label")
    private String label;

    @Column(name = "seq")
    private Integer sequence;

    @Column(name = "default")
    private Boolean defaultKey;

    @Column(name = "active")
    private Boolean active;

    @OneToMany(mappedBy = "parent", orphanRemoval = false)
    @OrderBy("name, seq, value_label, value_key")
    @Where(clause = "active=true")
    private List<ConfigDomain> children = new ArrayList<>();

    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="parent_id",nullable=true)
    private ConfigDomain parent;
}
