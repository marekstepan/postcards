CREATE TABLE users
(
    id         SERIAL PRIMARY KEY,
    password   VARCHAR(255) NOT NULL,
    username   VARCHAR(255) NOT NULL
);

CREATE TABLE owners
(
    id         SERIAL PRIMARY KEY,
    created    TIMESTAMP NOT NULL,
    edited     TIMESTAMP NOT NULL,
    name       INTEGER NOT NULL,
    note       VARCHAR(255)
);

CREATE TABLE photographers
(
    id         SERIAL PRIMARY KEY,
    created    TIMESTAMP NOT NULL,
    edited     TIMESTAMP NOT NULL,
    name       INTEGER NOT NULL,
    note       VARCHAR(255)
);

CREATE TABLE printing_houses
(
    id         SERIAL PRIMARY KEY,
    created    TIMESTAMP NOT NULL,
    edited     TIMESTAMP NOT NULL,
    name       INTEGER NOT NULL,
    note       VARCHAR(255)
);

CREATE TABLE publishers
(
    id         SERIAL PRIMARY KEY,
    created    TIMESTAMP NOT NULL,
    edited     TIMESTAMP NOT NULL,
    name       INTEGER NOT NULL,
    note       VARCHAR(255)
);

CREATE TABLE localities
(
    id                      SERIAL PRIMARY KEY,
    created                 TIMESTAMP NOT NULL,
    edited                  TIMESTAMP NOT NULL,
    object_location         POINT NOT NULL,
    photographer_location   POINT
);

CREATE TABLE shots
(
    id                  SERIAL PRIMARY KEY,
    created             TIMESTAMP NOT NULL,
    edited              TIMESTAMP NOT NULL,
    object              VARCHAR(255),
    object_type         INTEGER,
    image_orientation   INTEGER,
    note                VARCHAR(255),
    postcard_id         BIGINT,
    photographer_id     BIGINT
);

CREATE TABLE postcards
(
    id                          SERIAL PRIMARY KEY,
    created                     TIMESTAMP NOT NULL,
    edited                      TIMESTAMP NOT NULL,
    user_id                     BIGINT NOT NULL,
    front_title                 VARCHAR(255),
    front_subtitle              VARCHAR(255),
    shots_count                 INTEGER,
    publication_year_int_start  INTEGER,
    publication_year_int_end    INTEGER,
    condition                   INTEGER,
    format                      INTEGER,
    orientation                 INTEGER,
    written                     BOOLEAN,
    stamped                     BOOLEAN,
    mailed                      BOOLEAN,
    printing_technique          INTEGER,
    genre                       INTEGER,
    pcs_duplicates              INTEGER,
    pcs_for_sale                INTEGER,
    back_title                  VARCHAR(255),
    back_subtitle               VARCHAR(255),
    image_path                  VARCHAR(255),
    note                        VARCHAR(255),
    addressee_municipality      VARCHAR(255),
    addressee_zip               INTEGER,
    owner_id                    BIGINT,
    printing_house_id           BIGINT,
    publisher_id                BIGINT
);



