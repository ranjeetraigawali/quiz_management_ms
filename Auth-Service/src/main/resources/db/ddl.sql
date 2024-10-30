CREATE  TABLE USERS (
    ID SERIAL PRIMARY KEY,
    NAME VARCHAR(255) NOT NULL,
    EMAIL VARCHAR(255) NOT NULL UNIQUE,
    PASSWORD VARCHAR(255) NOT NULL,
    CREATEDAT TIMESTAMP,
    UPDATEDAT TIMESTAMP
);