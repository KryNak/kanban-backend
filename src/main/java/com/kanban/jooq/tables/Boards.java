/*
 * This file is generated by jOOQ.
 */
package com.kanban.jooq.tables;


import com.kanban.jooq.Keys;
import com.kanban.jooq.Public;
import com.kanban.jooq.tables.records.BoardsRecord;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.Row4;
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
public class Boards extends TableImpl<BoardsRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * The reference instance of <code>public.boards</code>
     */
    public static final Boards BOARDS = new Boards();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<BoardsRecord> getRecordType() {
        return BoardsRecord.class;
    }

    /**
     * The column <code>public.boards.id</code>.
     */
    public final TableField<BoardsRecord, UUID> ID = createField(DSL.name("id"), SQLDataType.UUID.nullable(false), this, "");

    /**
     * The column <code>public.boards.name</code>.
     */
    public final TableField<BoardsRecord, String> NAME = createField(DSL.name("name"), SQLDataType.VARCHAR(255), this, "");

    /**
     * The column <code>public.boards.position</code>.
     */
    public final TableField<BoardsRecord, Integer> POSITION = createField(DSL.name("position"), SQLDataType.INTEGER.nullable(false), this, "");

    /**
     * The column <code>public.boards.user_id</code>.
     */
    public final TableField<BoardsRecord, UUID> USER_ID = createField(DSL.name("user_id"), SQLDataType.UUID.nullable(false), this, "");

    private Boards(Name alias, Table<BoardsRecord> aliased) {
        this(alias, aliased, null);
    }

    private Boards(Name alias, Table<BoardsRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""), TableOptions.table());
    }

    /**
     * Create an aliased <code>public.boards</code> table reference
     */
    public Boards(String alias) {
        this(DSL.name(alias), BOARDS);
    }

    /**
     * Create an aliased <code>public.boards</code> table reference
     */
    public Boards(Name alias) {
        this(alias, BOARDS);
    }

    /**
     * Create a <code>public.boards</code> table reference
     */
    public Boards() {
        this(DSL.name("boards"), null);
    }

    public <O extends Record> Boards(Table<O> child, ForeignKey<O, BoardsRecord> key) {
        super(child, key, BOARDS);
    }

    @Override
    public Schema getSchema() {
        return Public.PUBLIC;
    }

    @Override
    public UniqueKey<BoardsRecord> getPrimaryKey() {
        return Keys.BOARDS_PKEY;
    }

    @Override
    public List<UniqueKey<BoardsRecord>> getKeys() {
        return Arrays.<UniqueKey<BoardsRecord>>asList(Keys.BOARDS_PKEY);
    }

    @Override
    public Boards as(String alias) {
        return new Boards(DSL.name(alias), this);
    }

    @Override
    public Boards as(Name alias) {
        return new Boards(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public Boards rename(String name) {
        return new Boards(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public Boards rename(Name name) {
        return new Boards(name, null);
    }

    // -------------------------------------------------------------------------
    // Row4 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row4<UUID, String, Integer, UUID> fieldsRow() {
        return (Row4) super.fieldsRow();
    }
}
