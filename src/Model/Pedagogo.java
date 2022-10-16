package Model;

import java.time.LocalDate;
import java.util.Date;

public class Pedagogo extends Pessoa implements Comparable<Pedagogo> {
    private int numeroAtendimento ;


    public Pedagogo(String nome, Integer telefone, LocalDate dataDeNascimento, Long cpf, int cod, int numeroAtendimento) {
        super(nome, telefone, dataDeNascimento, cpf, cod);
        this.numeroAtendimento = numeroAtendimento;
    }

public String relatorioDePedagogosPedagogicos () {return " Codigo :"+ cod + " nome:" + nome + " Atendimentos Pedagógicos:" + numeroAtendimento;
    }

    @Override
    public String toString() {
        return "Pedagogo{" +
                "numeroAtendimento=" + numeroAtendimento +
                ", nome='" + nome + '\'' +
                ", telefone=" + telefone +
                ", dataDeNascimento=" + dataDeNascimento +
                ", cpf=" + cpf +
                ", cod=" + cod +
                '}';
    }
    public String relatorio(){
        return  "Pedagogo: Codigo: " + cod + " Nome: " + nome + " Cpf: " + cpf;
    }

    public int getNumeroAtendimento() {
        return numeroAtendimento;
    }

    public void setNumeroAtendimento(int numeroAtendimento) {
        this.numeroAtendimento = numeroAtendimento;
    }

    public int compareTo(Pedagogo o) {
        return (this.numeroAtendimento-o.numeroAtendimento);
    }

}
