package Repository;

import Model.Aluno;
import Model.Pedagogo;
import Model.Pessoa;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PessoaRepository {
    private List<Pessoa> dados = new ArrayList<>();
    public void inserir(Pessoa pessoa){

        dados.add(pessoa);
    }
    public List<Pessoa> consultar(){

        return dados;
    }
    public List<Aluno> procurarAluno() {
        for (Pessoa pessoa : dados) {
            if (pessoa instanceof Aluno) {
                Aluno aluno = (Aluno) pessoa;
                alunosOrdem.add(aluno);
            }
        }
        Collections.sort(alunosOrdem,Collections.reverseOrder());
        return alunosOrdem;
    }
    private List<Aluno> alunosOrdem = new ArrayList<>();


    public List<Pedagogo> procurarPedagogo() {
        for (Pessoa pessoa : dados) {
            if (pessoa instanceof Pedagogo) {
                Pedagogo pedagogo = (Pedagogo) pessoa;
                pedagogoOrdem.add(pedagogo);
            }
        }
        Collections.sort(pedagogoOrdem,Collections.reverseOrder());
        return pedagogoOrdem;
    }

    private List<Pedagogo> pedagogoOrdem = new ArrayList<>();

}
