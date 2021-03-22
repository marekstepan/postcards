ALTER TABLE postcards
    ADD CONSTRAINT fk_postcards_user
        FOREIGN KEY (user_id)
            REFERENCES users (id);

ALTER TABLE shots
    ADD CONSTRAINT fk_shots_photographer
        FOREIGN KEY (photographer_id)
            REFERENCES photographers (id);

ALTER TABLE postcards
    ADD CONSTRAINT fk_postcards_printinghouse
        FOREIGN KEY (printing_house_id)
            REFERENCES printing_houses (id);

ALTER TABLE postcards
    ADD CONSTRAINT fk_postcards_publisher
        FOREIGN KEY (publisher_id)
            REFERENCES publishers (id);

ALTER TABLE shots
    ADD CONSTRAINT fk_shots_postcard
        FOREIGN KEY (postcard_id)
            REFERENCES postcards (id);

ALTER TABLE shots
    ADD CONSTRAINT fk_shots_locality
        FOREIGN KEY (locality_id)
            REFERENCES localities (id);

