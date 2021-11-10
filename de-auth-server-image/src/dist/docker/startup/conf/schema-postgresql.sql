
CREATE TABLE IF NOT EXISTS  DEROLE (
    id int  NOT NULL,
    name varchar(255)  NOT NULL,
    PRIMARY KEY (id),
    UNIQUE (name)
);

CREATE TABLE IF NOT EXISTS DEUSER (
    id int  NOT NULL,
    username varchar(255)  NOT NULL,
    password varchar(255)  NOT NULL,
    email varchar(255)  NOT NULL,
    PRIMARY KEY (id),
    UNIQUE (username,email)
);

CREATE TABLE IF NOT EXISTS DEUSER_DEROLE (
    userid int  NOT NULL,
    roleid int NOT NULL,
    FOREIGN KEY (role_id) REFERENCES DEROLE(id),
    FOREIGN KEY (user_id) REFERENCES DEUSER(id)

);
