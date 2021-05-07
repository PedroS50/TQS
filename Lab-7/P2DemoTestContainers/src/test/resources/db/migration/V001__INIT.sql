CREATE TABLE employee
(
    id    BIGSERIAL PRIMARY KEY,
    name  varchar(25) NOT NULL,
    email varchar(50) NOT NULL,
    unique (email)
);

INSERT INTO employee(name, email)
VALUES('Pedro', 'pedro@ua.pt');
