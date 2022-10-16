import Cli.Display;
import Model.*;

import Repository.PessoaRepository;

import java.io.OptionalDataException;
import java.util.List;
import java.util.Scanner;

public class Aplicacao {
    int cod = 0;


    private Display display = new Display();
    private PessoaRepository repo = new PessoaRepository();



    public void executar() throws OptionalDataException {
        OperacoesParaCadastro operacoesParaCadastro = null;

        while (operacoesParaCadastro != OperacoesParaCadastro.SAIR) {    //Manter o menu ate a opcao "sair"

            display.exibirMenu();
            operacoesParaCadastro = display.ObterOpcao();//Capiturar a operacao do ususario
            System.out.println(operacoesParaCadastro);


            if (operacoesParaCadastro.compareTo(OperacoesParaCadastro.CADASTRO_DE_ALUNO) == 0 || operacoesParaCadastro.compareTo(OperacoesParaCadastro.CADASTRO_DE_PROFESSOR) == 0 || operacoesParaCadastro.compareTo(OperacoesParaCadastro.CADASTRO_DE_PEDAGOGO) == 0) {
                cod = cod + 1;

            }
            if (operacoesParaCadastro.compareTo(OperacoesParaCadastro.CADASTRO_DE_ALUNO) == 0) {
                processar(operacoesParaCadastro);
            }
            if (operacoesParaCadastro.compareTo(OperacoesParaCadastro.ATUALIZACAO_DA_SITUACAO_DA_MATRICULA_DE_ALUNO) == 0) {
                processar(operacoesParaCadastro);
            }
            if (operacoesParaCadastro.compareTo(OperacoesParaCadastro.CADASTRO_DE_PROFESSOR) == 0) {
                processar(operacoesParaCadastro);
            }
            if (operacoesParaCadastro.compareTo(OperacoesParaCadastro.CADASTRO_DE_PEDAGOGO) == 0) {
                processar(operacoesParaCadastro);
            }
            if (operacoesParaCadastro.compareTo(OperacoesParaCadastro.LISTAGEM_DE_PESSOAS) == 0) {
                processar(operacoesParaCadastro);
            }
            if (operacoesParaCadastro.compareTo(OperacoesParaCadastro.RELATORIO_DOS_ALUNOS) == 0) {
                processar(operacoesParaCadastro);
            }
            if (operacoesParaCadastro.compareTo(OperacoesParaCadastro.RELATORIO_DOS_PROFESSORES) == 0) {
                processar(operacoesParaCadastro);
            }
            if (operacoesParaCadastro.compareTo(OperacoesParaCadastro.REALIZACAO_DE_ATENDIMENTO_PEDAGOGO) == 0) {
                processar(operacoesParaCadastro);
            }
            if (operacoesParaCadastro.compareTo(OperacoesParaCadastro.RELATORIO_DE_ALUNOS_COM_MAIS_ATENDIMENTO_PEDAGOGICOS) == 0) {
                processar(operacoesParaCadastro);
            }
            if (operacoesParaCadastro.compareTo(OperacoesParaCadastro.PEDAGOGOS_COM_MAIS_ATENDIMENTOS_PEDAGOGICOS) == 0) {
                processar(operacoesParaCadastro);
            }

        }
    }
    //  }

    private void processar(OperacoesParaCadastro operacao) throws OptionalDataException {
        switch (operacao) {
            case CADASTRO_DE_ALUNO:
                System.out.println();
                Pessoa aluno = display.cadastrar(TipoPessoa.ALUNO, cod);
                repo.inserir(aluno);
                display.aguardar();
                break;
            case ATUALIZACAO_DA_SITUACAO_DA_MATRICULA_DE_ALUNO:
                System.out.println();
            List<Pessoa> pessoa = repo.consultar();
                display.alterarSituacao(pessoa);
                display.aguardar();
                break;

            case CADASTRO_DE_PROFESSOR:
                System.out.println();
                Pessoa professor = display.cadastrar(TipoPessoa.PROFESSOR, cod);
                repo.inserir(professor);
                display.aguardar();
                break;

            case CADASTRO_DE_PEDAGOGO:
                System.out.println();
                Pessoa pedagogo = display.cadastrar(TipoPessoa.PEDAGOGO, cod);
                repo.inserir(pedagogo);
                display.aguardar();
                break;

            case REALIZACAO_DE_ATENDIMENTO_PEDAGOGO:

                List<Pessoa> atendimento = repo.consultar();
                display.atendimentoPedagogico(atendimento);

                break;

            case LISTAGEM_DE_PESSOAS:
                System.out.println();
                System.out.println("Selecione a categoria");
                System.out.println("1 - Alunos");
                System.out.println("2 - Professores");
                System.out.println("3 - Pedagogo");
                System.out.println("4 - Todos");

                Scanner scanner = new Scanner(System.in);
                int opcao = scanner.nextInt();

                List<Pessoa> pessoas = repo.consultar();
                if (pessoas.isEmpty()) {
                    display.exibirmensagem("Sem pessoas cadastradas");
                }

                display.listar(pessoas, opcao);
                display.aguardar();
                break;

            case RELATORIO_DOS_ALUNOS:
                System.out.println();
                System.out.println("Selecione a categoria");  //Arrumar
                System.out.println("1 - Ativo");
                System.out.println("2 - Irregular");
                System.out.println("3 - Atendimento pedagogo");
                System.out.println("4 - Inativo");
                System.out.println("5 - Todos");

                Scanner scanner2 = new Scanner(System.in);
                int opcao2 = scanner2.nextInt();
                List<Pessoa> alunos = repo.consultar();
                display.listarRelatorioAlunos(alunos, opcao2);
                display.aguardar();

                if (alunos.isEmpty()) {
                    display.exibirmensagem("Sem pessoas cadastradas");
                }

            case RELATORIO_DOS_PROFESSORES:
                System.out.println();
                System.out.println("Selecione a categoria");
                System.out.println("1 - Front-End");
                System.out.println("2 - Back-End");
                System.out.println("3 - Full-Stack");
                System.out.println("4 - Todos");

                Scanner scanner3 = new Scanner(System.in);
                int opcao3 = scanner3.nextInt();
                List<Pessoa> professores = repo.consultar();
                display.listarRelatorioProfessores(professores, opcao3);
                display.aguardar();
                if (professores.isEmpty()) {
                    display.exibirmensagem("Sem pessoas cadastradas");
                }

            case RELATORIO_DE_ALUNOS_COM_MAIS_ATENDIMENTO_PEDAGOGICOS:

                List<Aluno> alunosOrdem = repo.procurarAluno();
                display.relatorioDeAlunosComMaisAtendimentos(alunosOrdem);
                alunosOrdem.clear();
                display.aguardar();

                break;

            case PEDAGOGOS_COM_MAIS_ATENDIMENTOS_PEDAGOGICOS:
                List<Pedagogo> pedagogoOrdem = repo.procurarPedagogo();
                display.relatorioDePedagogosComMaisAtendimentos(pedagogoOrdem);
                pedagogoOrdem.clear();
                display.aguardar();
                break;
        }
    }
}

