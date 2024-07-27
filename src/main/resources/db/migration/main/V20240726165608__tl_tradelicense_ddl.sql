CREATE TABLE document (
    id VARCHAR(255),
    organisation_id VARCHAR(255) REFERENCES organisations(id),
    org_function_id VARCHAR(255) REFERENCES functions(id),
    document_type VARCHAR(255),
    file_store VARCHAR(255),
    document_uid VARCHAR(255),
    additional_details JSONB,
    is_active BOOLEAN
);