CREATE TABLE boards (
    id uuid NOT NULL,
    name character varying(255)
);

CREATE TABLE columns (
    id uuid NOT NULL,
    name character varying(255),
    position INT NOT NULL,
    board_id uuid
);

CREATE TABLE subtasks (
    id uuid NOT NULL,
    is_completed boolean NOT NULL,
    position INT NOT NULL,
    title character varying(255),
    task_id uuid
);

CREATE TABLE tasks (
    id uuid NOT NULL,
    description character varying(255),
    status character varying(255),
    title character varying(255),
    column_id uuid,
    position INT NOT NULL
);


ALTER TABLE boards
    ADD CONSTRAINT boards_pkey PRIMARY KEY (id);



ALTER TABLE columns
    ADD CONSTRAINT columns_pkey PRIMARY KEY (id);



ALTER TABLE subtasks
    ADD CONSTRAINT subtasks_pkey PRIMARY KEY (id);



ALTER TABLE tasks
    ADD CONSTRAINT tasks_pkey PRIMARY KEY (id);



ALTER TABLE columns
    ADD CONSTRAINT fkiylg7oiwdt1tnoff75rkbihc0 FOREIGN KEY (board_id) REFERENCES boards(id);



ALTER TABLE tasks
    ADD CONSTRAINT fkleqsyhtos46wpnhh7a1lpn38q FOREIGN KEY (column_id) REFERENCES columns(id);



ALTER TABLE subtasks
    ADD CONSTRAINT fksvs126nsj9ohhvwjog5ddp76x FOREIGN KEY (task_id) REFERENCES tasks(id);



ALTER TABLE columns
    ADD CONSTRAINT column_position UNIQUE (position, board_id);



ALTER TABLE subtasks
    ADD CONSTRAINT subtask_position UNIQUE (position, task_id);



ALTER TABLE tasks
    ADD CONSTRAINT task_position UNIQUE (position, column_id);
