CREATE TABLE CARD
(
    CARD_ID                INT PRIMARY KEY NOT NULL,
    CARD_KANJI             NCHAR           NOT NULL,
    HEISIG_INDEX_5_EDITION INT,
    HEISIG_INDEX_6_EDITION INT,
    KEYWORD_5_EDITION      VARCHAR,
    KEYWORD_6_EDITION      VARCHAR,
    ON_READING             NVARCHAR,
    KUN_READING            NVARCHAR
);

CREATE TABLE LESSON
(
    LESSON_ID  INT PRIMARY KEY NOT NULL,
    LAST_FRAME INT             NOT NULL REFERENCES CARD (CARD_ID)
);

CREATE TABLE PRIMITIVE
(
    PRIMITIVE_ID INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,
    NEXT_FRAME   INT REFERENCES CARD (CARD_ID)     NOT NULL,
    SVG_PATH     VARCHAR                           NOT NULL,
    KEYWORD      VARCHAR
);

CREATE TABLE CARD_PRIMITIVE
(
    CARD_ID      INT NOT NULL REFERENCES CARD (CARD_ID),
    PRIMITIVE_ID INT NOT NULL REFERENCES PRIMITIVE (PRIMITIVE_ID),
    PRIMARY KEY (CARD_ID, PRIMITIVE_ID)
);

CREATE TABLE TAG
(
    TAG_ID   INT PRIMARY KEY NOT NULL,
    TAG_NAME NVARCHAR        NOT NULL
);

CREATE TABLE CARD_TAG
(
    CARD_ID INT NOT NULL REFERENCES CARD (CARD_ID),
    TAG_ID  INT NOT NULL REFERENCES TAG (TAG_ID),
    PRIMARY KEY (CARD_ID, TAG_ID)
);

CREATE TABLE NOTE
(
    NOTE_ID       INT PRIMARY KEY NOT NULL,
    NOTE_CONTENTS VARCHAR         NOT NULL
);

CREATE TABLE CARD_NOTE
(
    NOTE_ID INT REFERENCES NOTE (NOTE_ID),
    CARD_ID INT REFERENCES CARD (CARD_ID),
    PRIMARY KEY (NOTE_ID, CARD_ID)
);
