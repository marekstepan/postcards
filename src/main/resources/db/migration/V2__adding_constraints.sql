ALTER TABLE postcards
    ADD CONSTRAINT fk_postcards_user
        FOREIGN KEY (user_id)
            REFERENCES users (id);

ALTER TABLE shots
    ADD CONSTRAINT fk_shots_photographer
        FOREIGN KEY (photographer_id)
            REFERENCES photographers (id);

ALTER TABLE postcards
    ADD CONSTRAINT fk_printinghouses_users
        FOREIGN KEY (printing_house_id)
            REFERENCES printing_houses (id);

ALTER TABLE postcards
    ADD CONSTRAINT fk_publishers_users
        FOREIGN KEY (publisher_id)
            REFERENCES publishers (id);