ALTER TABLE postcards
    ADD CONSTRAINT fk_postcards_owner
        FOREIGN KEY (owner_id)
            REFERENCES owners (id);