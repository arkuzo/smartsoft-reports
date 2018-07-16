/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.smartsoft.application.entities.dao;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import ru.smartsoft.application.entities.FormRequest;
import ru.smartsoft.application.entities.rowmappers.FormRequestRowMapper;

/**
 *
 * @author arseniy
 */
@Repository
public class FormRequestDao {
    
    @Autowired
    private JdbcTemplate jdbcTemplate;
    private final RowMapper<FormRequest> rowMapper = new FormRequestRowMapper();
    
    public List<FormRequest> getLastHourRequests(){
        String query;
        query = "SELECT ssoid, formid, ymdh FROM smartsoft "
                + "WHERE ts>= now() - interval'1 hour' "
                + "ORDER BY ts DESC";
        return jdbcTemplate.query(query, rowMapper);
    }
    
    public List<FormRequest> getUncompletedRequests(){
        String query;
        query = "SELECT s.ssoid, s.subtype, s.ymdh, s.formid\n" +
                "FROM smartsoft AS s, \n" +
                "\n" +
                "			(SELECT ssoid, MAX(ts) FROM smartsoft\n" +
                "			WHERE grp LIKE 'dszn_%'\n" +
                "			GROUP BY ssoid) AS l, --Selecting last form usage for each user\n" +
                "			" +
                "			(SELECT s.ssoid\n" +
                "				FROM smartsoft AS s, \n" +
                "				(SELECT ssoid, MIN(ts) FROM smartsoft\n" +
                "				WHERE grp LIKE 'dszn_%'\n" +
                "				GROUP BY ssoid) AS l --Selecting first form usage for each user\n" +
                "			WHERE s.ssoid = l.ssoid\n" +
                "			AND s.ts = l.min\n" +
                "			AND s.subtype = 'start') AS f --Selecting users that has to start activity\n" +
                "			" +
                "WHERE s.ssoid = l.ssoid\n" +
                "AND s.ssoid = f.ssoid\n" +
                "AND s.ts = l.max\n" +
                "AND s.subtype != 'send'";
        return jdbcTemplate.query(query, rowMapper);
    }
}
