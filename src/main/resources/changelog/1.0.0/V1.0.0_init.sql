--DROP SCHEMA IF EXISTS general CASCADE;

CREATE SCHEMA IF NOT EXISTS general;

--UTILS SCHEMA

CREATE TABLE general.maintenance
(
    id varchar NOT NULL,
    user_id varchar NOT NULL,
    metric varchar NOT NULL,
    value bigint NOT NULL,
    maintenance varchar NOT NULL,
    CONSTRAINT pk_maintenance
        PRIMARY KEY (id)
);



