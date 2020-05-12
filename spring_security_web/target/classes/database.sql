-- Table: users
CREATE TABLE students (
  id       BIGINT       NOT NULL AUTO_INCREMENT PRIMARY KEY,
  username VARCHAR(255) NOT NULL,
  password VARCHAR(255) NOT NULL,
  name VARCHAR(255) NOT NULL,
  surname VARCHAR(255) NOT NULL
)
  ENGINE = InnoDB;

-- Table: roles
CREATE TABLE roles (
  id   INT          NOT NULL AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(100) NOT NULL
)
  ENGINE = InnoDB;

-- Table for mapping user and roles: user_roles
CREATE TABLE student_roles (
  student_id BIGINT NOT NULL,
  role_id INT    NOT NULL,

  FOREIGN KEY (student_id) REFERENCES students (id),
  FOREIGN KEY (role_id) REFERENCES roles (id),

  UNIQUE (student_id, role_id)
)
  ENGINE = InnoDB;

-- Insert data

INSERT INTO students VALUES (1, 'admin', 'admin', 'Raman', 'Kashanok');
INSERT INTO students VALUES (2, 'user', 'user', 'Vasya', 'Pupkin');

INSERT INTO roles VALUES (1, 'ADMIN');
INSERT INTO roles VALUES (2, 'USER');

INSERT INTO student_roles VALUES (1, 1);
INSERT INTO student_roles VALUES (2, 2);