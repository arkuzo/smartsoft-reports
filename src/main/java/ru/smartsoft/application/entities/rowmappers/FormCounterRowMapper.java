/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.smartsoft.application.entities.rowmappers;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import ru.smartsoft.application.entities.FormCounter;

/**
 *
 * @author arseniy
 */
public class FormCounterRowMapper implements RowMapper<FormCounter> {

    @Override
    public FormCounter mapRow(ResultSet rs, int i) throws SQLException {
        return new FormCounter(rs.getInt("count"), rs.getString("formid"));
    }
    
}
