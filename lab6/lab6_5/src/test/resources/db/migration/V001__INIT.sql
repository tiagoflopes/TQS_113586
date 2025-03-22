CREATE TABLE car (
    car_id INTEGER PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
    maker varchar(255) not null,
    model varchar(255) not null
);