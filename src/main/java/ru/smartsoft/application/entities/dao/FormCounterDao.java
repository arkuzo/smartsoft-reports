/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.smartsoft.application.entities.dao;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.*;
import org.springframework.stereotype.Repository;
import ru.smartsoft.application.entities.FormCounter;
import ru.smartsoft.application.entities.rowmappers.FormCounterRowMapper;

/**
 *
 * @author arseniy
 */
@Repository
public class FormCounterDao {
    
    @Autowired
    private JdbcTemplate jdbcTemplate;
    
    public List<FormCounter> getTop5forms(){
        String query;
        query = "SELECT formid, COUNT(formid) FROM smartsoft "
                + "WHERE formid !='' GROUP BY formid "
                + "ORDER BY COUNT(formid) DESC LIMIT 5";
        RowMapper<FormCounter> rowMapper = new FormCounterRowMapper();
        return jdbcTemplate.query(query, rowMapper);
    }
}
