CREATE TABLE user
(
    user_id       INT  NOT NULL,
    first_name    VARCHAR(255) NULL,
    middle_name   VARCHAR(255) NULL,
    last_name     VARCHAR(255) NULL,
    user_name     VARCHAR(255) NULL,
    password      VARCHAR(255) NULL,
    email         VARCHAR(255) NULL,
    mobile_number VARCHAR(255) NULL,
    active_status CHAR NOT NULL,
    CONSTRAINT pk_user PRIMARY KEY (user_id)
);

ALTER TABLE user
    ADD CONSTRAINT uc_user_email UNIQUE (email);

ALTER TABLE user
    ADD CONSTRAINT uc_user_mobilenumber UNIQUE (mobile_number);

ALTER TABLE user
    ADD CONSTRAINT uc_user_username UNIQUE (user_name);