package com.evan.entity;

import java.util.List;

public class OprData {
    private String agg;
    private List agg_as;
    private List agg_column;
    private String agg_con;
    private List agg_group_by;
    private List agg_order_by;
    private Integer agg_size;
    private String task_con;
    private List return_columns;
    private List table;
    private List task_order_by;
    private Integer task_size;
    private String type;

    public String getAgg() {
        return agg;
    }

    public void setAgg(String agg) {
        this.agg = agg;
    }

    public List getAgg_as() {
        return agg_as;
    }

    public void setAgg_as(List agg_as) {
        this.agg_as = agg_as;
    }

    public List getAgg_column() {
        return agg_column;
    }

    public void setAgg_column(List agg_column) {
        this.agg_column = agg_column;
    }

    public String getAgg_con() {
        return agg_con;
    }

    public void setAgg_con(String agg_con) {
        this.agg_con = agg_con;
    }

    public List getAgg_group_by() {
        return agg_group_by;
    }

    public void setAgg_group_by(List agg_group_by) {
        this.agg_group_by = agg_group_by;
    }

    public List getAgg_order_by() {
        return agg_order_by;
    }

    public void setAgg_order_by(List agg_order_by) {
        this.agg_order_by = agg_order_by;
    }

    public Integer getAgg_size() {
        return agg_size;
    }

    public void setAgg_size(Integer agg_size) {
        this.agg_size = agg_size;
    }

    public String getTask_con() {
        return task_con;
    }

    public void setTask_con(String task_con) {
        this.task_con = task_con;
    }

    public List getReturn_columns() {
        return return_columns;
    }

    public void setReturn_columns(List return_columns) {
        this.return_columns = return_columns;
    }

    public List getTable() {
        return table;
    }

    public void setTable(List table) {
        this.table = table;
    }

    public List getTask_order_by() {
        return task_order_by;
    }

    public void setTask_order_by(List task_order_by) {
        this.task_order_by = task_order_by;
    }

    public Integer getTask_size() {
        return task_size;
    }

    public void setTask_size(Integer task_size) {
        this.task_size = task_size;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "OprData{" +
                "agg='" + agg + '\'' +
                ", agg_as='" + agg_as + '\'' +
                ", agg_column='" + agg_column + '\'' +
                ", agg_con='" + agg_con + '\'' +
                ", agg_group_by=" + agg_group_by +
                ", agg_order_by=" + agg_order_by +
                ", agg_size=" + agg_size +
                ", task_con='" + task_con + '\'' +
                ", return_columns=" + return_columns +
                ", table=" + table +
                ", task_order_by=" + task_order_by +
                ", task_size=" + task_size +
                ", type='" + type + '\'' +
                '}';
    }
}
