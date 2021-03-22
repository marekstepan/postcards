CREATE TABLE postcard_tags
(
    id          SERIAL PRIMARY KEY,
    created     TIMESTAMP NOT NULL,
    edited      TIMESTAMP NOT NULL,
    tag         VARCHAR(255) NOT NULL
);


CREATE TABLE postcards_postcardtags
(
    id                  SERIAL PRIMARY KEY,
    created             TIMESTAMP NOT NULL,
    edited              TIMESTAMP NOT NULL,
    postcard_id         BIGINT NOT NULL,
    postcard_tag_id     BIGINT NOT NULL,
    CONSTRAINT postcards_postcards_postcardtags_fk FOREIGN KEY (postcard_id) REFERENCES postcards,
    CONSTRAINT postcard_tags_postcards_postcardtags_fk FOREIGN KEY (postcard_tag_id) REFERENCES postcard_tags
);