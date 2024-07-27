CREATE TABLE contact_details (
     id VARCHAR(255) PRIMARY KEY,
     organisation_id VARCHAR(255) REFERENCES organisations(id),
     contact_name VARCHAR(64) ,
     contact_mobile_number VARCHAR(20),
     contact_email VARCHAR(200)
);