DROP TABLE IF EXISTS Bundles;
CREATE TABLE Bundles (
    id  serial  PRIMARY KEY,
    name VARCHAR(128) NOT NULL,
    price INTEGER not NULL,
    code integer,
    expdate VARCHAR(128),
    avadate VARCHAR(128) 
);
