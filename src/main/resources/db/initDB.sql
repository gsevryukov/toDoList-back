CREATE TABLE IF NOT EXISTS task_categories
(
    id          BIGSERIAL PRIMARY KEY,
    description VARCHAR(200) NOT NULL
);
CREATE SEQUENCE IF NOT EXISTS task_categories_id_seq START WITH 1 INCREMENT BY 1;

CREATE TABLE IF NOT EXISTS tasks
(
    id          BIGSERIAL PRIMARY KEY,
    description VARCHAR(200) NOT NULL,
    status      VARCHAR(200) NOT NULL,
    est_date     BIGINT       NOT NULL,
    category_id  BIGINT
);
CREATE SEQUENCE IF NOT EXISTS tasks_id_seq START WITH 1 INCREMENT BY 1;
-- DROP TABLE if exists  tasks;
-- DROP SEQUENCE if exists tasks_id_seq;
-- DROP SEQUENCE if exists tasks_estdate_seq;
