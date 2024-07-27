-- Migration script to add new columns to the organisations table

ALTER TABLE organisations
ADD COLUMN createdBy VARCHAR(64),
ADD COLUMN lastModifiedBy VARCHAR(64),
ADD COLUMN createdTime BIGINT,
ADD COLUMN lastModifiedTime BIGINT;


CREATE TABLE org_address(
    id VARCHAR(255) PRIMARY KEY,
    organisation_id VARCHAR(255) REFERENCES organisations(id),
    tenant_id VARCHAR(255),
    door_no VARCHAR(255),
    latitude NUMERIC,
    longitude NUMERIC,
    address_number VARCHAR(255),
    type VARCHAR(255),
    address_line1 VARCHAR(255),
    address_line2 VARCHAR(255),
    landmark VARCHAR(255),
    city VARCHAR(255),
    pincode VARCHAR(255),
    detail VARCHAR(255),
    building_name VARCHAR(255),
    street VARCHAR(255),
    boundary_code VARCHAR(255),
    boundary_name VARCHAR(255),
    boundary_label VARCHAR(255),
    boundary_latitude VARCHAR(255),
    boundary_longitude VARCHAR(255),
    boundary_children JSONB,
    boundary_type VARCHAR(255)
);