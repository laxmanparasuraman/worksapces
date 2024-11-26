package com.laxman.demojdbcspringboot.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


@Component
public class AlienRepo {
   /* public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }*/

    @Autowired
    private JdbcTemplate jdbcTemplate=new JdbcTemplate();

    public  void save ( Alien alien){

  String  sql ="insert into  alien (id ,name ,tech )  values (?,?,?)";
      int row=  jdbcTemplate.update(sql,alien.getId(),alien.getName(),alien.getTech());

  System.out.println(row+" added");
    }
    public List<Alien> findAll(){

        String sql ="select *from alien";

        RowMapper<Alien> mapper=new RowMapper<Alien>() {
            @Override
            public Alien mapRow(ResultSet rs, int rowNum) throws SQLException {
               Alien alien=new Alien();
                 alien.setId(rs.getInt(1));
                alien.setName(rs.getString(2));
                alien.setTech(rs.getString(3));

                return alien;
            }
        };


        /*
        *    in fuction interface we use lamda
        *
        *  example

*
       RowMapper<Alien> mapper= ( rs ,row)->{

               Alien alien=new Alien();
                 alien.setId(rs.getInt(1));
                alien.setName(rs.getString(2));
                alien.setTech(rs.getString(3));

                return alien;

        };

        *
        * */
        List<Alien> res=jdbcTemplate.query(sql
        ,mapper);

        return res;
    }



}
