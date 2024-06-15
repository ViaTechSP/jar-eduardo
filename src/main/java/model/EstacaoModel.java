package model;

import banco.SqlServerBancoConexao;
import entidade.Estacao;
import entidade.Funcionario;
import entidade.Maquina;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.util.ArrayList;
import java.util.List;

public class EstacaoModel {

    public List<Estacao> listaEstacoesDisponiveis (){
        SqlServerBancoConexao sqlServerBancoConexao = new SqlServerBancoConexao();
        JdbcTemplate connSqlServer = sqlServerBancoConexao.getJdbcTemplate();
        try {
            String query = "SELECT e.nome, e.idEstacao FROM estacao AS e " +
                    "LEFT JOIN maquina AS m ON m.fkEstacao = e.idEstacao " +
                    "WHERE m.idMaquina IS NULL";
            RowMapper<Estacao> rowMapper = new BeanPropertyRowMapper<>(Estacao.class);
            return connSqlServer.query(query, rowMapper);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public String exibirEstacaoPorMaquina(String dominio){
        SqlServerBancoConexao sqlServerBancoConexao = new SqlServerBancoConexao();
        JdbcTemplate connSqlServer = sqlServerBancoConexao.getJdbcTemplate();

        String query = "SELECT estacao.nome FROM estacao JOIN maquina ON idEstacao = fkEstacao WHERE maquina.dominio = ?";
        return connSqlServer.queryForObject(query, new BeanPropertyRowMapper<>(Estacao.class), dominio).getNome();
    }
}
