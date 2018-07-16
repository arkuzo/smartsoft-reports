/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.smartsoft.application.entities.rowmappers;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import ru.smartsoft.application.entities.FormRequest;

/**
 *
 * @author arseniy
 */
public class FormRequestRowMapper implements RowMapper<FormRequest> {

    @Override
    public FormRequest mapRow(ResultSet rs, int i) throws SQLException {
        return new FormRequest(rs.getString("ssoid"), rs.getString("formid"),
                rs.getString("ymdh"), rs.getString("subtype"));
    }
    
}
