create table if not exists product (
    identifier  INT PRIMARY KEY IDENTITY ,
    name        VARCHAR(50) NOT NULL ,
    price       INT NOT NULL
);