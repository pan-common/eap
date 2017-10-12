

package com.taiji.eap.common.generator.bean;

import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.taiji.eap.common.base.BaseModel;

public class ColumnExtend extends BaseModel implements Comparable<ColumnExtend>{
    private Long id;//
    private String tableSchema;//数据库名
    private String tableName;//表名
    private String columnName;//列名
    private String isNullAble;//是否为空
    private String ordinalPosition;//排序
    private String dataType;//数据类型
    private String columnKey;//主键
    private String columnComment;//注释
    private Integer seq;//排序
    private String formShow;//表单显示
    private String listShow;//列表显示
    private String inputType;//录入类型
    private String isQuery;//是否查询
    private String param;//参数
    private String verify;//校验规则
    private String required;//是否必填

    public ColumnExtend() {
    }

    public ColumnExtend(String tableSchema, String tableName, String columnName) {
        this.tableSchema = tableSchema;
        this.tableName = tableName;
        this.columnName = columnName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public String getTableSchema() {
        return tableSchema;
    }

    public void setTableSchema(String tableSchema) {
        this.tableSchema = tableSchema;
    }


    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }


    public String getColumnName() {
        return columnName;
    }

    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }


    public Integer getSeq() {
        return seq;
    }

    public void setSeq(Integer seq) {
        this.seq = seq;
    }


    public String getFormShow() {
        return formShow;
    }

    public void setFormShow(String formShow) {
        this.formShow = formShow;
    }


    public String getListShow() {
        return listShow;
    }

    public void setListShow(String listShow) {
        this.listShow = listShow;
    }


    public String getInputType() {
        return inputType;
    }

    public void setInputType(String inputType) {
        this.inputType = inputType;
    }


    public String getIsQuery() {
        return isQuery;
    }

    public void setIsQuery(String isQuery) {
        this.isQuery = isQuery;
    }


    public String getParam() {
        return param;
    }

    public void setParam(String param) {
        this.param = param;
    }


    public String getVerify() {
        return verify;
    }

    public void setVerify(String verify) {
        this.verify = verify;
    }


    public String getRequired() {
        return required;
    }

    public void setRequired(String required) {
        this.required = required;
    }

    public String getIsNullAble() {
        return isNullAble;
    }

    public void setIsNullAble(String isNullAble) {
        this.isNullAble = isNullAble;
    }

    public String getOrdinalPosition() {
        return ordinalPosition;
    }

    public void setOrdinalPosition(String ordinalPosition) {
        this.ordinalPosition = ordinalPosition;
    }

    public String getDataType() {
        return dataType;
    }

    public void setDataType(String dataType) {
        this.dataType = dataType;
    }

    public String getColumnKey() {
        return columnKey;
    }

    public void setColumnKey(String columnKey) {
        this.columnKey = columnKey;
    }

    public String getColumnComment() {
        return columnComment;
    }

    public void setColumnComment(String columnComment) {
        this.columnComment = columnComment;
    }

    @Override
    public int compareTo(ColumnExtend o) {
        return this.getSeq().compareTo(o.getSeq());
    }
}
