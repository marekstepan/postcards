CREATE TABLE users
(
    id         BIGSERIAL PRIMARY KEY,
    created    DATE NOT NULL,
    edited     DATE NOT NULL,
    password   VARCHAR(255) NOT NULL,
    username   VARCHAR(255) NOT NULL
);

CREATE TABLE owners
(
    id         BIGSERIAL PRIMARY KEY,
    created    DATE NOT NULL,
    edited     DATE NOT NULL,
    name       INTEGER NOT NULL,
    note       VARCHAR(255)
);

CREATE TABLE photographers
(
    id         BIGSERIAL PRIMARY KEY,
    created    DATE NOT NULL,
    edited     DATE NOT NULL,
    name       INTEGER NOT NULL,
    note       VARCHAR(255)
);

CREATE TABLE printing_houses
(
    id         BIGSERIAL PRIMARY KEY,
    created    DATE NOT NULL,
    edited     DATE NOT NULL,
    name       INTEGER NOT NULL,
    note       VARCHAR(255)
);

CREATE TABLE publishers
(
    id         BIGSERIAL PRIMARY KEY,
    created    DATE NOT NULL,
    edited     DATE NOT NULL,
    name       INTEGER NOT NULL,
    note       VARCHAR(255)
);

CREATE TABLE localities
(
    id                      		    BIGSERIAL PRIMARY KEY,
    created                 		    DATE NOT NULL,
    edited                  		    DATE NOT NULL,
    object_location         		    POINT NOT NULL,
    photographer_location   		    POINT,
    object_location_accuracy_id	        BIGINT NOT NULL,
    photographer_location_accuracy_id	BIGINT
);

CREATE TABLE shots
(
    id                  	BIGSERIAL PRIMARY KEY,
    created             	DATE NOT NULL,
    edited              	DATE NOT NULL,
    object              	VARCHAR(255),
    object_type_id      	BIGINT,
    image_orientation_id	BIGINT,
    note                	VARCHAR(255),
    postcard_id         	BIGINT,
    photographer_id     	BIGINT,
    locality_id         	BIGINT
);

CREATE TABLE postcards
(
    id                          BIGSERIAL PRIMARY KEY,
    created                     DATE NOT NULL,
    edited                      DATE NOT NULL,
    user_id                     BIGINT NOT NULL,
    front_title                 VARCHAR(255),
    front_subtitle              VARCHAR(255),
    shots_count                 INTEGER,
    publication_year_int_start  INTEGER,
    publication_year_int_end    INTEGER,
    condition_id                BIGINT,
    format_id                   BIGINT,
    orientation_id              BIGINT,
    written                     BOOLEAN,
    stamped                     BOOLEAN,
    mailed                      BOOLEAN,
    printing_technique_id       BIGINT,
    genre_id                    BIGINT,
    pcs_duplicates              INTEGER,
    pcs_for_sale                INTEGER,
    back_title                  VARCHAR(255),
    back_subtitle               VARCHAR(255),
    image_path                  VARCHAR(255),
    note                        VARCHAR(255),
    addressee_municipality_id   BIGINT,
    addressee_zip               INTEGER,
    owner_id                    BIGINT,
    printinghouse_id           BIGINT,
    publisher_id                BIGINT
);

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
        FOREIGN KEY (printinghouse_id)
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

ALTER TABLE postcards
    ADD CONSTRAINT fk_postcards_owner
        FOREIGN KEY (owner_id)
            REFERENCES owners (id);

CREATE TABLE postcard_tags
(
    id          BIGSERIAL PRIMARY KEY,
    created     DATE NOT NULL,
    edited      DATE NOT NULL,
    tag         VARCHAR(255) NOT NULL
);

CREATE TABLE postcards_postcardtagss
(
    id                  BIGSERIAL PRIMARY KEY,
    created             DATE NOT NULL,
    edited              DATE NOT NULL,
    postcard_id         BIGINT NOT NULL,
    postcardtag_id     BIGINT NOT NULL,
    CONSTRAINT postcards_postcards_postcardtags_fk FOREIGN KEY (postcard_id) REFERENCES postcards,
    CONSTRAINT postcard_tags_postcards_postcardtags_fk FOREIGN KEY (postcardtag_id) REFERENCES postcard_tags
);

CREATE TABLE conditions
(
    id          BIGSERIAL PRIMARY KEY,
    created     DATE NOT NULL,
    edited      DATE NOT NULL,
    value       VARCHAR(255) NOT NULL
);

CREATE TABLE orientations
(
    id          BIGSERIAL PRIMARY KEY,
    created     DATE NOT NULL,
    edited      DATE NOT NULL,
    value       VARCHAR(255) NOT NULL
);

CREATE TABLE formats
(
    id          BIGSERIAL PRIMARY KEY,
    created     DATE NOT NULL,
    edited      DATE NOT NULL,
    value       VARCHAR(255) NOT NULL
);

CREATE TABLE printing_techniques
(
    id          BIGSERIAL PRIMARY KEY,
    created     DATE NOT NULL,
    edited      DATE NOT NULL,
    value       VARCHAR(255) NOT NULL
);

CREATE TABLE municipalities
(
    id          BIGSERIAL PRIMARY KEY,
    created     DATE NOT NULL,
    edited      DATE NOT NULL,
    value       VARCHAR(255) NOT NULL
);

CREATE TABLE genres
(
    id          BIGSERIAL PRIMARY KEY,
    created     DATE NOT NULL,
    edited      DATE NOT NULL,
    value       VARCHAR(255) NOT NULL
);

CREATE TABLE object_types
(
    id          BIGSERIAL PRIMARY KEY,
    created     DATE NOT NULL,
    edited      DATE NOT NULL,
    value       VARCHAR(255) NOT NULL
);

CREATE TABLE object_location_accuracies
(
    id          BIGSERIAL PRIMARY KEY,
    created     DATE NOT NULL,
    edited      DATE NOT NULL,
    value       VARCHAR(255) NOT NULL
);

CREATE TABLE photographer_location_accuracies
(
    id          BIGSERIAL PRIMARY KEY,
    created     DATE NOT NULL,
    edited      DATE NOT NULL,
    value       VARCHAR(255) NOT NULL
);

ALTER TABLE postcards
    ADD CONSTRAINT fk_postcards_condition
        FOREIGN KEY (condition_id)
            REFERENCES conditions (id);

ALTER TABLE postcards
    ADD CONSTRAINT fk_postcards_orientation
        FOREIGN KEY (orientation_id)
            REFERENCES orientations (id);

ALTER TABLE shots
    ADD CONSTRAINT fk_shots_orientation
        FOREIGN KEY (image_orientation_id)
            REFERENCES orientations (id);

ALTER TABLE postcards
    ADD CONSTRAINT fk_postcards_format
        FOREIGN KEY (format_id)
            REFERENCES formats (id);

ALTER TABLE postcards
    ADD CONSTRAINT fk_postcards_printing_technique
        FOREIGN KEY (printing_technique_id)
            REFERENCES printing_techniques (id);

ALTER TABLE postcards
    ADD CONSTRAINT fk_postcards_municipality
        FOREIGN KEY (addressee_municipality_id)
            REFERENCES municipalities (id);

ALTER TABLE postcards
    ADD CONSTRAINT fk_postcards_genre
        FOREIGN KEY (genre_id)
            REFERENCES genres (id);

ALTER TABLE shots
    ADD CONSTRAINT fk_shots_object_type
        FOREIGN KEY (object_type_id)
            REFERENCES object_types (id);

ALTER TABLE localities
    ADD CONSTRAINT fk_localities_photographer_location_accuracy
        FOREIGN KEY (photographer_location_accuracy_id)
            REFERENCES photographer_location_accuracies (id);

ALTER TABLE localities
    ADD CONSTRAINT fk_localities_object_location_accuracy
        FOREIGN KEY (object_location_accuracy_id)
            REFERENCES object_location_accuracies (id);