package com.taiji.eap.common.query;

import com.taiji.eap.common.query.bean.*;
import com.taiji.eap.common.utils.SpringContextUtil;
import org.jeecgframework.poi.excel.ExcelImportUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.web.context.ContextLoader;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class QueryUtil {

    private static final Logger LOGGER = LoggerFactory.getLogger(QueryUtil.class);

    private QueryUtil() {


    }

    public static List<List<ColumnData>> getColumnData(String tableName, List<ColumnEntity> columnEntities){
        JdbcTemplate jdbcTemplate = (JdbcTemplate) SpringContextUtil.getBean("jdbcTemplate");

        String columnSql = "select *  from user_tab_columns where table_name = ?";
        List<TabColumn> tabColumns = jdbcTemplate.query(columnSql, new Object[]{tableName}, new RowMapper<TabColumn>() {
            @Override
            public TabColumn mapRow(ResultSet rs, int rowNum) throws SQLException {
                TabColumn tabColumn = new TabColumn();
                tabColumn.setColumnId(rs.getString("COLUMN_ID"));
                tabColumn.setColumnName(rs.getString("COLUMN_NAME"));
                tabColumn.setDataType(rs.getString("DATA_TYPE"));
                tabColumn.setNullAble(rs.getString("NULLABLE"));
                tabColumn.setTableName(rs.getString("TABLE_NAME"));
                return tabColumn;
            }
        });

        List<ColumnData> columnDatas = new ArrayList<ColumnData>();
        if(columnEntities!=null&&!columnEntities.isEmpty()) {
            for (int i = 0; i < columnEntities.size(); i++) {
                for (int j = 0; j < tabColumns.size(); j++) {
                    if (columnEntities.get(i).getFieldName().equals(tabColumns.get(j).getColumnName())) {
                        ColumnData columnData = new ColumnData(
                                columnEntities.get(i).getFieldName(),
                                columnEntities.get(i).getTitle(),
                                columnEntities.get(i).getWidth());
                        columnDatas.add(columnData);
                    }
                }
            }
        }else {
            for (int i = 0; i < tabColumns.size(); i++) {
                ColumnData columnData = new ColumnData(
                        tabColumns.get(i).getColumnName(),
                        tabColumns.get(i).getColumnName(),
                        100);
                columnDatas.add(columnData);
            }
        }
        List<List<ColumnData>> columns = new ArrayList<List<ColumnData>>();
        columns.add(columnDatas);
        return columns;
    }

    public static PageBean getQueryData(String tableName,Integer page,Integer rows){
        int start = (page-1) * rows+1;
        int end = page * rows;
        String sql ="SELECT * FROM (SELECT A.*, ROWNUM RN  FROM (SELECT * FROM "+tableName+") A WHERE ROWNUM <= ?) WHERE RN >= ?";
        JdbcTemplate jdbcTemplate = (JdbcTemplate) SpringContextUtil.getBean("jdbcTemplate");
        String countSql = "select count(*) from "+tableName;
        List<Map<String,Object>> list = jdbcTemplate.queryForList(sql,new Object[]{end,start},
                new int[]{Types.INTEGER,Types.INTEGER});
        Integer count = jdbcTemplate.queryForObject(countSql,Integer.class);
        PageBean pageBean = new PageBean();
        pageBean.setTotal(count);
        pageBean.setRows(list);
        return pageBean;
    }

}
