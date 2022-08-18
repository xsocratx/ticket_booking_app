CREATE TABLE AUDITORIUM (
	id INTEGER PRIMARY KEY NOT NULL,
	name VARCHAR NOT NULL,
	capacity INTEGER NOT NULL
);

CREATE TABLE CUSTOMER (
	id INTEGER PRIMARY KEY NOT NULL,
	first_name VARCHAR NOT NULL,
	last_name VARCHAR NOT NULL
);

CREATE TABLE MOVIE (
	id INTEGER PRIMARY KEY NOT NULL,
	name_movie VARCHAR NOT NULL,
	description VARCHAR NOT NULL,
	minutes INTEGER NOT NULL,
	published_year INTEGER NOT NULL
);

CREATE TABLE RESERVATION (
	id INTEGER PRIMARY KEY NOT NULL,
	scheduled_movie_id INTEGER NOT NULL,
	customer_id INTEGER NOT NULL,
	seat_id INTEGER NOT NULL,
	reservation_type VARCHAR NOT NULL
);

CREATE TABLE ROW (
	id INTEGER PRIMARY KEY NOT NULL,
	number INTEGER NOT NULL,
	name VARCHAR NOT NULL,
	seat_in_row INTEGER NOT NULL,
	auditorium_id INTEGER NOT NULL
);

CREATE TABLE SCHEDULED_MOVIE (
	id INTEGER PRIMARY KEY NOT NULL,
	start_of TIMESTAMP NOT NULL,
	end_of TIMESTAMP NOT NULL,
	movie_id INTEGER NOT NULL,
	auditorium_id INTEGER NOT NULL
);

CREATE TABLE SEAT (
    id INTEGER PRIMARY KEY NOT NULL,
    number INTEGER NOT NULL,
    row_id INTEGER NOT NULL
);
