package com.avalanches.interfaceadapters.gateways;


import com.avalanches.enterprisebusinessrules.entities.Cliente;
import com.avalanches.frameworksanddrivers.databases.ClienteNotFoundException;
import com.avalanches.interfaceadapters.gateways.interfaces.ClienteGatewayInterface;
import jakarta.inject.Inject;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class ClienteGateway implements ClienteGatewayInterface {

    // TODO: pesquisar como fazer no springboot via interface
    @Inject
    private JdbcTemplate jdbcTemplate;

    @Override
    public void cadastrar(Cliente cliente) {
        jdbcTemplate.update("INSERT INTO cliente (nome, cpf, email) VALUES (?, ?, ?);",
                cliente.nome,
                cliente.cpf,
                cliente.email);
    }

    @Override
    public Cliente identificar(String cpf) {
        try {
            return jdbcTemplate.queryForObject("SELECT * FROM cliente WHERE cpf = ?",
                    new Object[]{cpf},
                    (rs, rowNum) -> new Cliente(
                            rs.getInt("id"),
                            rs.getString("nome"),
                            rs.getString("cpf"),
                            rs.getString("email")
                    )
            );
        } catch (EmptyResultDataAccessException e) {
            throw new ClienteNotFoundException(cpf);
        }
    }

    @Override
    public boolean verificaCpfExistente(String cpf) {
        String sql = "SELECT COUNT(*) FROM cliente WHERE cpf = ?";
        Integer count = jdbcTemplate.queryForObject(sql, new Object[]{cpf}, Integer.class);
        return count != null && count > 0;
    }

    @Override
    public void deletar(String cpf) {
        try {
            int rowsAffected = jdbcTemplate.update("DELETE FROM cliente WHERE cpf = ?", cpf);
            if (rowsAffected == 0) {
                throw new ClienteNotFoundException(cpf);
            }
        } catch (EmptyResultDataAccessException e) {
            throw new ClienteNotFoundException(cpf);
        }
    }

}
