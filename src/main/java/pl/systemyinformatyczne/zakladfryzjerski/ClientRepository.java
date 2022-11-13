package pl.systemyinformatyczne.zakladfryzjerski;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ClientRepository
{
    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<Client> getAll()
    {
        return jdbcTemplate.query("SELECT * FROM client", BeanPropertyRowMapper.newInstance(Client.class));
    }
}
