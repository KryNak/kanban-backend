CREATE TABLE boards (
    id uuid NOT NULL,
    name character varying(255),
    position INT NOT NULL
);


ALTER TABLE boards OWNER TO admin;


CREATE TABLE columns (
    id uuid NOT NULL,
    name character varying(255),
    position INT NOT NULL,
    board_id uuid,
    color text
);


ALTER TABLE columns OWNER TO admin;


CREATE TABLE subtasks (
    id uuid NOT NULL,
    is_completed boolean NOT NULL,
    position INT NOT NULL,
    title character varying(255),
    task_id uuid
);


ALTER TABLE subtasks OWNER TO admin;


CREATE TABLE tasks (
    id uuid NOT NULL,
    description character varying(255),
    status character varying(255),
    title character varying(255),
    column_id uuid,
    position INT NOT NULL
);


ALTER TABLE tasks OWNER TO admin;


ALTER TABLE ONLY boards
    ADD CONSTRAINT boards_pkey PRIMARY KEY (id);



ALTER TABLE ONLY columns
    ADD CONSTRAINT columns_pkey PRIMARY KEY (id);



ALTER TABLE ONLY subtasks
    ADD CONSTRAINT subtasks_pkey PRIMARY KEY (id);



ALTER TABLE ONLY tasks
    ADD CONSTRAINT tasks_pkey PRIMARY KEY (id);



ALTER TABLE ONLY columns
    ADD CONSTRAINT fkiylg7oiwdt1tnoff75rkbihc0 FOREIGN KEY (board_id) REFERENCES boards(id);



ALTER TABLE ONLY tasks
    ADD CONSTRAINT fkleqsyhtos46wpnhh7a1lpn38q FOREIGN KEY (column_id) REFERENCES columns(id);



ALTER TABLE ONLY subtasks
    ADD CONSTRAINT fksvs126nsj9ohhvwjog5ddp76x FOREIGN KEY (task_id) REFERENCES tasks(id);



-- ALTER TABLE ONLY columns
--     ADD CONSTRAINT column_position UNIQUE (position, board_id);
--
--
--
-- ALTER TABLE ONLY subtasks
--     ADD CONSTRAINT subtask_position UNIQUE (position, task_id);
--
--
--
-- ALTER TABLE ONLY tasks
--     ADD CONSTRAINT task_position UNIQUE (position, column_id);
