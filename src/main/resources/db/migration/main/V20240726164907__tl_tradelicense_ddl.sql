-- V2__drop_documents_column.sql
-- Migration script to drop the 'documents' column from the 'functions' table

ALTER TABLE functions DROP COLUMN documents;
