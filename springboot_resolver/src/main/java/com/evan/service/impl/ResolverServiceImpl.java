package com.evan.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.evan.dao.ResolverDao;
import com.evan.entity.DataBase;
import com.evan.entity.OprData;
import com.evan.service.ResolverService;
import com.evan.utils.JsonToJava;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResolverServiceImpl implements ResolverService {

    @Autowired
    ResolverDao resolverDao;

    @Override
    public String query(String question) {
        String query = resolverDao.query(question);
        /*String task = "{\n" +
                "\t\"task\":{\n" +
                "\t\t\"format\":[\"text\"],\n" +
                "\t\t\"opr\":[\n" +
                "\t\t\t{\n" +
                "\t\t\t\t\"agg\":\"inner_hits\",\n" +
                "\t\t\t\t\"agg_as\":\"\",\n" +
                "\t\t\t\t\"agg_column\":\"\",\n" +
                "\t\t\t\t\"agg_con\":\"\",\n" +
                "\t\t\t\t\"agg_group_by\":[\"instrument_id\"],\n" +
                "\t\t\t\t\"agg_order_by\":[\"declare_date DESC\"],\n" +
                "\t\t\t\t\"agg_size\":1,\n" +
                "\t\t\t\t\"task_con\":\"(operating_profit > 100000000)\",\n" +
                "\t\t\t\t\"return_columns\":[\n" +
                "\t\t\t\t\t\"instrument_id\",\n" +
                "\t\t\t\t\t\"operating_profit\",\n" +
                "\t\t\t\t\t\"declare_date\"\n" +
                "\t\t\t\t],\n" +
                "\t\t\t\t\"table\":[\"dds_pyxis_stock_finance_newsflash\"],\n" +
                "\t\t\t\t\"task_order_by\":[\"operating_profit DESC\"],\n" +
                "\t\t\t\t\"task_size\":-1,\n" +
                "\t\t\t\t\"type\":\"query_entity\"\n" +
                "\t\t\t}\n" +
                "\t\t],\n" +
                "\t\t\"result\":[\"@1\"],\n" +
                "\t\t\"triple\":\"\"\n" +
                "\t},\n" +
                "\t\"template\":\"function()\"\n" +
                "}";*/

        String task="{\n" +
                "\t\"task\":{\n" +
                "\t\t\"format\":[\"text\"],\n" +
                "\t\t\"opr\":[\n" +
                "\t\t\t{\n" +
                "\t\t\t\t\"agg\":\"MAX\",\n" +
                "\t\t\t\t\"agg_as\":[\"new_instrument_id\",\"new_declare_date\"],\n" +
                "\t\t\t\t\"agg_column\":[\"instrument_id\",\"declare_date\"],\n" +
                "\t\t\t\t\"agg_con\":\"\",\n" +
                "\t\t\t\t\"agg_group_by\":[\"instrument_id\"],\n" +
                "\t\t\t\t\"agg_order_by\":[\"declare_date DESC\"],\n" +
                "\t\t\t\t\"agg_size\":1,\n" +
                "\t\t\t\t\"task_con\":\"(operating_profit > 1000000)\",\n" +
                "\t\t\t\t\"return_columns\":[\n" +
                "\t\t\t\t\t\"instrument_id\",\n" +
                "\t\t\t\t\t\"operating_profit\",\n" +
                "\t\t\t\t\t\"declare_date\"\n" +
                "\t\t\t\t],\n" +
                "\t\t\t\t\"table\":[\"dds_pyxis_stock_finance_newsflash\"],\n" +
                "\t\t\t\t\"task_order_by\":[\"operating_profit DESC\"],\n" +
                "\t\t\t\t\"task_size\":-1,\n" +
                "\t\t\t\t\"type\":\"query_entity\"\n" +
                "\t\t\t}\n" +
                "\t\t],\n" +
                "\t\t\"result\":[\"@1\"],\n" +
                "\t\t\"triple\":\"\"\n" +
                "\t},\n" +
                "\t\"template\":\"function()\"\n" +
                "}";

        String sql=null;
        JSONObject parseObject = JSONObject.parseObject(task);
        String taskJson = parseObject.getString("task");
        String templateJson = parseObject.getString("template");
        //DataBase dataBase = new DataBase();
        //OprData oprData = new OprData();
        DataBase dataBase = JSONObject.parseObject(taskJson, DataBase.class);
        List<OprData> oprDataList = JsonToJava.parseArray(dataBase.getOpr(), OprData.class);
        for (OprData oprData : oprDataList) {
            List format = dataBase.getFormat();
            List result = dataBase.getResult();
            String triple = dataBase.getTriple();
            String agg = oprData.getAgg();
            List agg_as = oprData.getAgg_as();
            List agg_column = oprData.getAgg_column();
            String agg_con = oprData.getAgg_con();
            List agg_group_by = oprData.getAgg_group_by();
            List agg_order_by = oprData.getAgg_order_by();
            Integer agg_size = oprData.getAgg_size();
            List return_columns = oprData.getReturn_columns();
            List table = oprData.getTable();
            String task_con = oprData.getTask_con();
            List task_order_by = oprData.getTask_order_by();
            Integer task_size = oprData.getTask_size();
            String type = oprData.getType();
            System.out.println(dataBase + ", , " + oprData);
            sql = getSql(agg, agg_as, agg_column, agg_con, agg_group_by, agg_order_by, agg_size, return_columns, table, task_con, task_order_by, task_size, type);

        }
        return sql;
    }

    public String getCondition(String task_con){
      return null;
    }

    public String getSql(String agg, List agg_as, List agg_column, String agg_con, List agg_group_by, List agg_order_by, Integer agg_size,
                         List return_columns, List table, String task_con, List task_order_by, Integer taske_size, String type) {
        StringBuffer buffer = new StringBuffer("");
        if (agg_group_by != null || agg_group_by.size() != 0) {
            buffer.append("SELECT ");
            for (int i = 0; i < return_columns.size(); i++) {
                buffer.append(return_columns.get(i)).append(", ");
            }
            buffer.delete(buffer.length() - 2, buffer.length());
            buffer.append(" FROM ");
            for (int i = 0; i < table.size(); i++) {
                buffer.append(table.get(i)).append(", ");
            }
            buffer.append("( SELECT ");
            for (int i = 0; i < agg_column.size() && agg_column.size() == agg_as.size(); i++) {
                buffer.append(agg).append("(").append(agg_column.get(i)).append(")").append(" ").append(agg_as.get(i)).append(", ");
            }
            buffer.delete(buffer.length() - 2, buffer.length());
            buffer.append(" FROM ");
            for (int i = 0; i < table.size(); i++) {
                buffer.append(table.get(i)).append(", ");
            }
            buffer.delete(buffer.length() - 2, buffer.length());
            if (agg_group_by != null || agg_group_by.size() != 0) {
                buffer.append(" GROUP BY ");
                for (int i = 0; i < agg_group_by.size(); i++) {
                    buffer.append(agg_group_by.get(i)).append(", ");
                }
            }
            buffer.delete(buffer.length() - 2, buffer.length());
            if (agg_size != -1) {
                buffer.append(" LIMIT ").append(agg_size);
            } else {
                buffer.append(" LIMIT 10000");
            }
            buffer.append(") s ");
            buffer.append("WHERE ");
            for (int i = 0; i < agg_as.size(); i++) {
                buffer.append(agg_column.get(i)).append(" = ").append(agg_as.get(i)).append(" AND ");
            }
            buffer.append(task_con);
            if (task_order_by != null || task_order_by.size() != 0) {
                for (Object taskOrderBy : task_order_by) {
                    buffer.append(" GROUP BY ").append(taskOrderBy);
                }
            }
            if (taske_size != -1) {
                buffer.append(" LIMIT ").append(taske_size);
            } else {
                buffer.append(" LIMIT 10000");
            }
        }
        System.out.println(buffer.toString());
        return buffer.toString();
    }

}
