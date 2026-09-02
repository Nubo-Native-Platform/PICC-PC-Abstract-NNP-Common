-- ==============================================================================
-- DML Script: Sample Configuration Domain Master Data
-- Schema: common
-- Table: cfg_domain
-- ==============================================================================

-- Sample Domain: COUNTRY
INSERT INTO common.cfg_domain (id, name, value_key, value_label, seq, "default", active, parent_id)
VALUES 
('DOM-CNT-US', 'COUNTRY', 'US', 'United States', 1, TRUE, TRUE, NULL),
('DOM-CNT-IN', 'COUNTRY', 'IN', 'India', 2, FALSE, TRUE, NULL),
('DOM-CNT-UK', 'COUNTRY', 'GB', 'United Kingdom', 3, FALSE, TRUE, NULL),
('DOM-CNT-DE', 'COUNTRY', 'DE', 'Germany', 4, FALSE, TRUE, NULL)
ON CONFLICT (id) DO NOTHING;

-- Sample Domain: STATE (with parent referencing COUNTRY)
INSERT INTO common.cfg_domain (id, name, value_key, value_label, seq, "default", active, parent_id)
VALUES 
('DOM-ST-CA', 'STATE', 'CA', 'California', 1, FALSE, TRUE, 'DOM-CNT-US'),
('DOM-ST-NY', 'STATE', 'NY', 'New York', 2, FALSE, TRUE, 'DOM-CNT-US'),
('DOM-ST-TX', 'STATE', 'TX', 'Texas', 3, FALSE, TRUE, 'DOM-CNT-US'),
('DOM-ST-MH', 'STATE', 'MH', 'Maharashtra', 1, FALSE, TRUE, 'DOM-CNT-IN'),
('DOM-ST-KA', 'STATE', 'KA', 'Karnataka', 2, FALSE, TRUE, 'DOM-CNT-IN')
ON CONFLICT (id) DO NOTHING;

-- Sample Domain: STATUS
INSERT INTO common.cfg_domain (id, name, value_key, value_label, seq, "default", active, parent_id)
VALUES 
('DOM-STS-ACT', 'STATUS', 'ACTIVE', 'Active', 1, TRUE, TRUE, NULL),
('DOM-STS-INA', 'STATUS', 'INACTIVE', 'Inactive', 2, FALSE, TRUE, NULL),
('DOM-STS-PND', 'STATUS', 'PENDING', 'Pending Approval', 3, FALSE, TRUE, NULL)
ON CONFLICT (id) DO NOTHING;
