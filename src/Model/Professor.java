package Model;

import java.time.LocalDate;

public class Professor extends Pessoa{
    private String situacaoEstado;
    private String situacaoExperiencia;
    private String situacaoFormacao;

    public Professor(String nome, Integer telefone, LocalDate dataDeNascimento, Long cpf, int cod, String situacaoEstado, String situacaoExperiencia, String situacaoFormacao) {
        super(nome, telefone, dataDeNascimento, cpf, cod);
        this.situacaoEstado = situacaoEstado;
        this.situacaoExperiencia = situacaoExperiencia;
        this.situacaoFormacao = situacaoFormacao;
    }



    @Override
    public String toString() {
        return "Professor{" +
                "nome='" + nome + '\'' +
                ", telefone=" + telefone +
                ", dataDeNascimento=" + dataDeNascimento +
                ", cpf=" + cpf +
                ", cod=" + cod +
                '}';
    }
    public String relatorio(){
        return  "Professor: Codigo: " + cod + " Nome: " + nome + " Cpf: " + cpf;
    }
    public String relatorioProfessor () { return " Codigo :" + cod + " Nome : " + nome + " Formação Academica: " +situacaoFormacao + " Experiencia: " + situacaoExperiencia + " Estado: " + situacaoEstado;}

    public String getSituacaoExperiencia() {
        return situacaoExperiencia;
    }

    public void setSituacaoExperiencia(String situacaoExperiencia) {
        this.situacaoExperiencia = situacaoExperiencia;
    }

    public String getSituacaoEstado() {
        return situacaoEstado;
    }

    public void setSituacaoEstado(String situacaoEstado) {
        this.situacaoEstado = situacaoEstado;
    }

    public String getSituacaoFormacao() {
        return situacaoFormacao;
    }

    public void setSituacaoFormacao(String situacaoFormacao) {
        this.situacaoFormacao = situacaoFormacao;
    }

}


