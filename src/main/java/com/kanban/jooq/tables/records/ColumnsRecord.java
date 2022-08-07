/*
 * This file is generated by jOOQ.
 */
package com.kanban.jooq.tables.records;


import com.kanban.jooq.tables.Columns;

import java.util.UUID;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record4;
import org.jooq.Row4;
import org.jooq.impl.UpdatableRecordImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class ColumnsRecord extends UpdatableRecordImpl<ColumnsRecord> implements Record4<UUID, String, Integer, UUID> {

    private static final long serialVersionUID = 1L;

    /**
     * Setter for <code>public.columns.id</code>.
     */
    public void setId(UUID value) {
        set(0, value);
    }

    /**
     * Getter for <code>public.columns.id</code>.
     */
    public UUID getId() {
        return (UUID) get(0);
    }

    /**
     * Setter for <code>public.columns.name</code>.
     */
    public void setName(String value) {
        set(1, value);
    }

    /**
     * Getter for <code>public.columns.name</code>.
     */
    public String getName() {
        return (String) get(1);
    }

    /**
     * Setter for <code>public.columns.position</code>.
     */
    public void setPosition(Integer value) {
        set(2, value);
    }

    /**
     * Getter for <code>public.columns.position</code>.
     */
    public Integer getPosition() {
        return (Integer) get(2);
    }

    /**
     * Setter for <code>public.columns.board_id</code>.
     */
    public void setBoardId(UUID value) {
        set(3, value);
    }

    /**
     * Getter for <code>public.columns.board_id</code>.
     */
    public UUID getBoardId() {
        return (UUID) get(3);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    @Override
    public Record1<UUID> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record4 type implementation
    // -------------------------------------------------------------------------

    @Override
    public Row4<UUID, String, Integer, UUID> fieldsRow() {
        return (Row4) super.fieldsRow();
    }

    @Override
    public Row4<UUID, String, Integer, UUID> valuesRow() {
        return (Row4) super.valuesRow();
    }

    @Override
    public Field<UUID> field1() {
        return Columns.COLUMNS.ID;
    }

    @Override
    public Field<String> field2() {
        return Columns.COLUMNS.NAME;
    }

    @Override
    public Field<Integer> field3() {
        return Columns.COLUMNS.POSITION;
    }

    @Override
    public Field<UUID> field4() {
        return Columns.COLUMNS.BOARD_ID;
    }

    @Override
    public UUID component1() {
        return getId();
    }

    @Override
    public String component2() {
        return getName();
    }

    @Override
    public Integer component3() {
        return getPosition();
    }

    @Override
    public UUID component4() {
        return getBoardId();
    }

    @Override
    public UUID value1() {
        return getId();
    }

    @Override
    public String value2() {
        return getName();
    }

    @Override
    public Integer value3() {
        return getPosition();
    }

    @Override
    public UUID value4() {
        return getBoardId();
    }

    @Override
    public ColumnsRecord value1(UUID value) {
        setId(value);
        return this;
    }

    @Override
    public ColumnsRecord value2(String value) {
        setName(value);
        return this;
    }

    @Override
    public ColumnsRecord value3(Integer value) {
        setPosition(value);
        return this;
    }

    @Override
    public ColumnsRecord value4(UUID value) {
        setBoardId(value);
        return this;
    }

    @Override
    public ColumnsRecord values(UUID value1, String value2, Integer value3, UUID value4) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached ColumnsRecord
     */
    public ColumnsRecord() {
        super(Columns.COLUMNS);
    }

    /**
     * Create a detached, initialised ColumnsRecord
     */
    public ColumnsRecord(UUID id, String name, Integer position, UUID boardId) {
        super(Columns.COLUMNS);

        setId(id);
        setName(name);
        setPosition(position);
        setBoardId(boardId);
    }
}
