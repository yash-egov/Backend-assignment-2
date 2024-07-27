CREATE TABLE jurisdiction (
    id VARCHAR(255) PRIMARY KEY,
    organisation_id VARCHAR(255) REFERENCES organisations(id),
    code VARCHAR(50),
    jurisdiction_id VARCHAR(50),
    additional_details JSONB
);
