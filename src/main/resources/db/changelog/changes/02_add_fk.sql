-- add fkeys to column RESERVATION
ALTER TABLE RESERVATION ADD CONSTRAINT fk_reservation_customer
   FOREIGN KEY (customer_id) REFERENCES CUSTOMER (id);

ALTER TABLE RESERVATION ADD CONSTRAINT fk_reservation_seat
   FOREIGN KEY (seat_id) REFERENCES SEAT (id);

ALTER TABLE RESERVATION ADD CONSTRAINT fk_reservation_scheduled_movie
   FOREIGN KEY (scheduled_movie_id) REFERENCES SCHEDULED_MOVIE (id);

ALTER TABLE RESERVATION ADD CONSTRAINT fk_reservation_reservation_type
   FOREIGN KEY (reservation_type_id) REFERENCES RESERVATION_TYPE (id);
--
ALTER TABLE SCHEDULED_MOVIE ADD CONSTRAINT fk_scheduled_movie_movie
   FOREIGN KEY (movie_id) REFERENCES MOVIE (id);

ALTER TABLE SCHEDULED_MOVIE ADD CONSTRAINT fk_scheduled_movie_auditorium
   FOREIGN KEY (auditorium_id) REFERENCES AUDITORIUM (id);
--
ALTER TABLE ROW ADD CONSTRAINT fk_row_auditorium
   FOREIGN KEY (auditorium_id) REFERENCES AUDITORIUM (id);
--
ALTER TABLE SEAT ADD CONSTRAINT fk_seat_row
   FOREIGN KEY(row_id) REFERENCES ROW (id);