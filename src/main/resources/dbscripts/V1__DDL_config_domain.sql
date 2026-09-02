-- ==============================================================================
-- DDL Script: Configuration Domain Table
-- Schema: common
-- Table: cfg_domain
-- ==============================================================================

CREATE SCHEMA IF NOT EXISTS common;

CREATE TABLE IF NOT EXISTS common.cfg_domain (
    id VARCHAR(64) NOT NULL,
    name VARCHAR(100) NOT NULL,
    value_key VARCHAR(100) NOT NULL,
    value_label VARCHAR(255),
    seq INTEGER DEFAULT 0,
    "default" BOOLEAN DEFAULT FALSE,
    active BOOLEAN DEFAULT TRUE,
    parent_id VARCHAR(64),
    created_at TIMESTAMP WITHOUT TIME ZONE DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP WITHOUT TIME ZONE DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT pk_cfg_domain PRIMARY KEY (id),
    CONSTRAINT fk_cfg_domain_parent FOREIGN KEY (parent_id) REFERENCES common.cfg_domain (id) ON DELETE RESTRICT
);

-- Index for fast lookups by name and active status
CREATE INDEX IF NOT EXISTS idx_cfg_domain_name_active ON common.cfg_domain (name, active);
CREATE INDEX IF NOT EXISTS idx_cfg_domain_parent_id ON common.cfg_domain (parent_id);
