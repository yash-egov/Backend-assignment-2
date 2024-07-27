CREATE TABLE functions(
    id VARCHAR(255) PRIMARY KEY,
    organisation_id VARCHAR(255) REFERENCES organisations(id),
    application_number VARCHAR(255),
    type VARCHAR(64) ,
    category VARCHAR(64) ,
    class VARCHAR(64) ,
    valid_from NUMERIC,
    valid_to NUMERIC,
    wf_status VARCHAR(64) ,
    is_active BOOLEAN,
    application_status VARCHAR(255),
    documents JSONB,
    additional_details JSONB
);