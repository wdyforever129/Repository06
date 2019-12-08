package com.evan.service;

import java.util.List;

public interface ElasticsearchService {
    String query(String agg, List agg_as, List agg_column, String agg_con, List agg_group_by, List agg_order_by, Integer agg_size,
                 List return_columns, List table, String task_con, List task_order_by, Integer taske_size, String type);
}
