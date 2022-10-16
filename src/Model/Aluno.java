package Model;

import java.time.LocalDate;
import java.util.Date;

public class Aluno  extends Pessoa implements Comparable<Aluno>  {
    private Double nota;
private int atendimento;
private String situacao;


    public Aluno(String nome, Integer telefone, LocalDate dataDeNascimento, Long cpf, int cod, Double nota, int atendimento, String situacao) {
        super(nome, telefone, dataDeNascimento, cpf, cod);
        this.nota = nota;
        this.atendimento = atendimento;
        this.situacao = situacao;
    }

    @Override
    public String toString() {
        return "Aluno{" +
                "nota=" + nota +
                ", nome='" + nome + '\'' +
                ", telefone=" + telefone +
                ", dataDeNascimento=" + dataDeNascimento +
                ", cpf=" + cpf +
                ", cod=" + cod +
                '}';

    }
   /* @Override public int compareTo(Aluno outroAluno) {
        if (this.atendimento > outroAluno.getAtendimento()) {
            return -1;
        } if (this.atendimento < outroAluno.getAtendimento()) {
            return 1;
        }
        return 0;
    }
*/


    public String relatorio(){
        return  " Aluno: Codigo:"+ cod + " Nome:"+ nome + " Cpf:"+ cpf + " Atendimentos Pedagógicos:";   //String utilizada no "atendimentoPedagogico" e "listar"
    }
    public String relatorioAlunos(){return " Codigo :"+ cod + " nome:" + nome + " Nota:" + nota + " Atendimentos Pedagógicos:" + atendimento;}   //String utilizada no "relatorioDeAlunosComMaisAtendimentos"

public String relatorioDeAlunosPedagogicos({return})
    public Double getNota() {
        return nota;
    }

    public void setNota(Double nota) {
        this.nota = nota;
    }

    public int getAtendimento() {
        return atendimento;
    }

    public void setAtendimento(int atendimento) {
        this.atendimento = atendimento;
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

    public int compareTo(Aluno o) {
        return (this.atendimento-o.atendimento);
    }
}





