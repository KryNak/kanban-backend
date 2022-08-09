/*
 * This file is generated by jOOQ.
 */
package com.kanban.jooq;


import com.kanban.jooq.tables.Boards;
import com.kanban.jooq.tables.Columns;
import com.kanban.jooq.tables.FlywaySchemaHistory;
import com.kanban.jooq.tables.Subtasks;
import com.kanban.jooq.tables.Tasks;
import com.kanban.jooq.tables.records.BoardsRecord;
import com.kanban.jooq.tables.records.ColumnsRecord;
import com.kanban.jooq.tables.records.FlywaySchemaHistoryRecord;
import com.kanban.jooq.tables.records.SubtasksRecord;
import com.kanban.jooq.tables.records.TasksRecord;

import org.jooq.ForeignKey;
import org.jooq.TableField;
import org.jooq.UniqueKey;
import org.jooq.impl.DSL;
import org.jooq.impl.Internal;


/**
 * A class modelling foreign key relationships and constraints of tables in 
 * public.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Keys {

    // -------------------------------------------------------------------------
    // UNIQUE and PRIMARY KEY definitions
    // -------------------------------------------------------------------------

    public static final UniqueKey<BoardsRecord> BOARDS_PKEY = Internal.createUniqueKey(Boards.BOARDS, DSL.name("boards_pkey"), new TableField[] { Boards.BOARDS.ID }, true);
    public static final UniqueKey<ColumnsRecord> COLUMNS_PKEY = Internal.createUniqueKey(Columns.COLUMNS, DSL.name("columns_pkey"), new TableField[] { Columns.COLUMNS.ID }, true);
    public static final UniqueKey<FlywaySchemaHistoryRecord> FLYWAY_SCHEMA_HISTORY_PK = Internal.createUniqueKey(FlywaySchemaHistory.FLYWAY_SCHEMA_HISTORY, DSL.name("flyway_schema_history_pk"), new TableField[] { FlywaySchemaHistory.FLYWAY_SCHEMA_HISTORY.INSTALLED_RANK }, true);
    public static final UniqueKey<SubtasksRecord> SUBTASKS_PKEY = Internal.createUniqueKey(Subtasks.SUBTASKS, DSL.name("subtasks_pkey"), new TableField[] { Subtasks.SUBTASKS.ID }, true);
    public static final UniqueKey<TasksRecord> TASKS_PKEY = Internal.createUniqueKey(Tasks.TASKS, DSL.name("tasks_pkey"), new TableField[] { Tasks.TASKS.ID }, true);

    // -------------------------------------------------------------------------
    // FOREIGN KEY definitions
    // -------------------------------------------------------------------------

    public static final ForeignKey<ColumnsRecord, BoardsRecord> COLUMNS__FKIYLG7OIWDT1TNOFF75RKBIHC0 = Internal.createForeignKey(Columns.COLUMNS, DSL.name("fkiylg7oiwdt1tnoff75rkbihc0"), new TableField[] { Columns.COLUMNS.BOARD_ID }, Keys.BOARDS_PKEY, new TableField[] { Boards.BOARDS.ID }, true);
    public static final ForeignKey<SubtasksRecord, TasksRecord> SUBTASKS__FKSVS126NSJ9OHHVWJOG5DDP76X = Internal.createForeignKey(Subtasks.SUBTASKS, DSL.name("fksvs126nsj9ohhvwjog5ddp76x"), new TableField[] { Subtasks.SUBTASKS.TASK_ID }, Keys.TASKS_PKEY, new TableField[] { Tasks.TASKS.ID }, true);
    public static final ForeignKey<TasksRecord, ColumnsRecord> TASKS__FKLEQSYHTOS46WPNHH7A1LPN38Q = Internal.createForeignKey(Tasks.TASKS, DSL.name("fkleqsyhtos46wpnhh7a1lpn38q"), new TableField[] { Tasks.TASKS.COLUMN_ID }, Keys.COLUMNS_PKEY, new TableField[] { Columns.COLUMNS.ID }, true);
}