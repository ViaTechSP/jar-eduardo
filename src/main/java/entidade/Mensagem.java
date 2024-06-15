package entidade;

public class Mensagem {
    private String nomeEstacao;
    private String nomeLinha;
    private String nomeMaquina;

    public Mensagem(String nomeEstacao, String nomeLinha, String nomeMaquina) {
        this.nomeEstacao = nomeEstacao;
        this.nomeLinha = nomeLinha;
        this.nomeMaquina = nomeMaquina;
    }

    public Mensagem() {
    }

    public String getNomeEstacao() {
        return nomeEstacao;
    }

    public String getNomeLinha() {
        return nomeLinha;
    }

    public String getNomeMaquina() {
        return nomeMaquina;
    }
}
