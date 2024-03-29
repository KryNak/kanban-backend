/*
 * This file is generated by jOOQ.
 */
package com.kanban.jooq.tables;


import com.kanban.jooq.Keys;
import com.kanban.jooq.Public;
import com.kanban.jooq.tables.records.SubtasksRecord;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.Row5;
import org.jooq.Schema;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.TableOptions;
import org.jooq.UniqueKey;
import org.jooq.impl.DSL;
import org.jooq.impl.SQLDataType;
import org.jooq.impl.TableImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Subtasks extends TableImpl<SubtasksRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * The reference instance of <code>public.subtasks</code>
     */
    public static final Subtasks SUBTASKS = new Subtasks();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<SubtasksRecord> getRecordType() {
        return SubtasksRecord.class;
    }

    /**
     * The column <code>public.subtasks.id</code>.
     */
    public final TableField<SubtasksRecord, UUID> ID = createField(DSL.name("id"), SQLDataType.UUID.nullable(false), this, "");

    /**
     * The column <code>public.subtasks.is_completed</code>.
     */
    public final TableField<SubtasksRecord, Boolean> IS_COMPLETED = createField(DSL.name("is_completed"), SQLDataType.BOOLEAN.nullable(false), this, "");

    /**
     * The column <code>public.subtasks.position</code>.
     */
    public final TableField<SubtasksRecord, Integer> POSITION = createField(DSL.name("position"), SQLDataType.INTEGER.nullable(false), this, "");

    /**
     * The column <code>public.subtasks.title</code>.
     */
    public final TableField<SubtasksRecord, String> TITLE = createField(DSL.name("title"), SQLDataType.VARCHAR(255), this, "");

    /**
     * The column <code>public.subtasks.task_id</code>.
     */
    public final TableField<SubtasksRecord, UUID> TASK_ID = createField(DSL.name("task_id"), SQLDataType.UUID, this, "");

    private Subtasks(Name alias, Table<SubtasksRecord> aliased) {
        this(alias, aliased, null);
    }

    private Subtasks(Name alias, Table<SubtasksRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""), TableOptions.table());
    }

    /**
     * Create an aliased <code>public.subtasks</code> table reference
     */
    public Subtasks(String alias) {
        this(DSL.name(alias), SUBTASKS);
    }

    /**
     * Create an aliased <code>public.subtasks</code> table reference
     */
    public Subtasks(Name alias) {
        this(alias, SUBTASKS);
    }

    /**
     * Create a <code>public.subtasks</code> table reference
     */
    public Subtasks() {
        this(DSL.name("subtasks"), null);
    }

    public <O extends Record> Subtasks(Table<O> child, ForeignKey<O, SubtasksRecord> key) {
        super(child, key, SUBTASKS);
    }

    @Override
    public Schema getSchema() {
        return Public.PUBLIC;
    }

    @Override
    public UniqueKey<SubtasksRecord> getPrimaryKey() {
        return Keys.SUBTASKS_PKEY;
    }

    @Override
    public List<UniqueKey<SubtasksRecord>> getKeys() {
        return Arrays.<UniqueKey<SubtasksRecord>>asList(Keys.SUBTASKS_PKEY);
    }

    @Override
    public List<ForeignKey<SubtasksRecord, ?>> getReferences() {
        return Arrays.<ForeignKey<SubtasksRecord, ?>>asList(Keys.SUBTASKS__FKSVS126NSJ9OHHVWJOG5DDP76X);
    }

    public Tasks tasks() {
        return new Tasks(this, Keys.SUBTASKS__FKSVS126NSJ9OHHVWJOG5DDP76X);
    }

    @Override
    public Subtasks as(String alias) {
        return new Subtasks(DSL.name(alias), this);
    }

    @Override
    public Subtasks as(Name alias) {
        return new Subtasks(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public Subtasks rename(String name) {
        return new Subtasks(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public Subtasks rename(Name name) {
        return new Subtasks(name, null);
    }

    // -------------------------------------------------------------------------
    // Row5 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row5<UUID, Boolean, Integer, String, UUID> fieldsRow() {
        return (Row5) super.fieldsRow();
    }
}
