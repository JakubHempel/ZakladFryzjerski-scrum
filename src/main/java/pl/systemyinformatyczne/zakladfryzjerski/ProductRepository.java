package pl.systemyinformatyczne.zakladfryzjerski;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductRepository
{
    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<Product> getAll()
    {
        return jdbcTemplate.query("SELECT *, count(*) AS numberOf FROM product group by model;", BeanPropertyRowMapper.newInstance(Product.class));
    }
}
