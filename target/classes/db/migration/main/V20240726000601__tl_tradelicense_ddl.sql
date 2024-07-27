CREATE TABLE organisations (
    id UUID PRIMARY KEY,
    tenant_id VARCHAR(50),
    name VARCHAR(255),
    application_number VARCHAR(255),
    org_number VARCHAR(255),
    application_status VARCHAR(50),
    external_ref_number VARCHAR(50),
    date_of_incorporation NUMERIC,
    is_active BOOLEAN,
    additional_details JSONB
);
