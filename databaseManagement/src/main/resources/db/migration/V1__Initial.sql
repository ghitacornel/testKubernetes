CREATE TABLE person (
    id VARCHAR(50) PRIMARY KEY,
    first_name VARCHAR(50) not null,
    last_name VARCHAR(50) not null
    );
CREATE TABLE product (
    id VARCHAR(50) PRIMARY KEY,
    code VARCHAR(50) not null,
    name VARCHAR(50) not null,
    price NUMERIC not null,
    quantity NUMERIC not null,
    person_id VARCHAR(50) not null,
    constraint product_person_fk foreign key(person_id) references person(id)
    );