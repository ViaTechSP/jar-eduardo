package model;

import banco.SqlServerBancoConexao;
import entidade.Linha;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

public class LinhaModel {

    public String exibirLinhaPorMaquina(String dominio){
        SqlServerBancoConexao sqlServerBancoConexao = new SqlServerBancoConexao();
        JdbcTemplate connSqlServer = sqlServerBancoConexao.getJdbcTemplate();

        String query = "SELECT linha.nome FROM maquina \n" +
                "JOIN estacao on maquina.fkEstacao = estacao.idEstacao\n" +
                "JOIN linha on linha.idLinha = estacao.fkLinha where dominio = ?";

        return connSqlServer.queryForObject(query, new BeanPropertyRowMapper<>(Linha.class), dominio).getNome();
    }
}
