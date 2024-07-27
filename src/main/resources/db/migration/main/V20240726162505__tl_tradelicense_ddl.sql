CREATE TABLE identifier (
    id VARCHAR(255) PRIMARY KEY,
    organisation_id VARCHAR(255) REFERENCES organisations(id),
    type VARCHAR(64) ,
    value VARCHAR(64) ,
    is_active BOOLEAN,
    additional_details JSONB
);