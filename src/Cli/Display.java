package Cli;

import Model.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Display {
    public void exibirMenu() {
        System.out.println();
        System.out.println("======== MENU ========");
        System.out.println("1 - Cadastro de Aluno");
        System.out.println("2 - Atualização da Situação da matrícula de Aluno");
        System.out.println("3 - Cadastro de Professor");
        System.out.println("4 - Cadastro de Pedagogo");
        System.out.println("5 - Realização de Atendimento Pedagógico");
        System.out.println("6 - Listagem de Pessoas");
        System.out.println("7 - Relatório dos Alunos");
        System.out.println("8 - Relatório dos Professores");
        System.out.println("9 - Relatório de Alunos com mais atendimentos pedagógicos");
        System.out.println("10 -Pedagogos com mais atendimentos pedagógicos");
        System.out.println("11 -Sair");
        System.out.println();
    }

    public OperacoesParaCadastro ObterOpcao() {
        System.out.println("Digite a opção desejada: ");
        Scanner scanner = new Scanner(System.in);
        int entradaOpcao = scanner.nextInt();
        OperacoesParaCadastro operacoesParaCadastro = OperacoesParaCadastro.obterPeloCodigo(entradaOpcao);
        return operacoesParaCadastro;
    }

    public void exibirMenuAluno() {
        System.out.println();
        System.out.println("== Cadastro aluno ==");
        System.out.println("1 - Ativo");
        System.out.println("2 - Irregular");
        System.out.println("3 - Atedimento Pedagogico");
        System.out.println("4 - Inativo");
    }

    public OperacaoSituacaoAluno ObterOpcaoAluno() {
        System.out.println(OperacaoSituacaoAluno.values());
        System.out.println("Digite a opcão desejada");
        Scanner scanner = new Scanner(System.in);
        int entradaOpcaoAluno = scanner.nextInt();
        OperacaoSituacaoAluno operacaoSituacaoAluno = OperacaoSituacaoAluno.obterPeloCodigoAluno(entradaOpcaoAluno);
        return operacaoSituacaoAluno;
    }

    public void exibirFormacaoProfessor() {
        System.out.println();
        System.out.println("== Cadastro professor ==");
        System.out.println("1 - Graduação incompleta");
        System.out.println("2 - Graduação completa");
        System.out.println("3 - Mestrado");
        System.out.println("4 - Doutorado");
    }

    public OperacaoFormacaoProfessor ObterFormacaoProfessor() {
        System.out.println(OperacaoFormacaoProfessor.values());
        System.out.println("Digite a opcão desejada");
        Scanner scanner = new Scanner(System.in);
        int entradaFormacaoProfessor = scanner.nextInt();
        OperacaoFormacaoProfessor operacaoFormacaoProfessor = OperacaoFormacaoProfessor.obterPeloCodigoProfessor(entradaFormacaoProfessor);
        return operacaoFormacaoProfessor;
    }

    public void exibirExperienciaProfessor() {
        System.out.println();
        System.out.println("== Cadastro professor ==");
        System.out.println("1 - Front End");
        System.out.println("2 - Back End");
        System.out.println("3 - Full Stack");
    }

    public OperacaoExperienciaProfessor ObterExperienciaProfessor() {
        System.out.println(OperacaoExperienciaProfessor.values());
        System.out.println("Digite a opcão desejada");
        Scanner scanner = new Scanner(System.in);
        int entradaExperienciaProfessor = scanner.nextInt();
        OperacaoExperienciaProfessor operacaoExperienciaProfessor = OperacaoExperienciaProfessor.obterPeloCodigoProfessorEx(entradaExperienciaProfessor);
        return operacaoExperienciaProfessor;
    }

    public void exibirEstadoProfessor() {
        System.out.println();
        System.out.println("== Cadastro professor ==");
        System.out.println("1 - Ativo");
        System.out.println("2 - Inativo");
    }

    public OperacaoEstadoProfessor ObterEstadoProfessor() {
        System.out.println(OperacaoEstadoProfessor.values());
        System.out.println("Digite a opcão desejada");
        Scanner scanner = new Scanner(System.in);
        int entradaEstadoProfessor = scanner.nextInt();
        OperacaoEstadoProfessor operacaoEstadoProfessor = OperacaoEstadoProfessor.obterPeloCodigoProfessorEst(entradaEstadoProfessor);
        return operacaoEstadoProfessor;

    }


    public Pessoa cadastrar(TipoPessoa tipo, int codigo) {               //Lista de cadastro de professor , aluno
        Scanner scanner = new Scanner(System.in);
        System.out.println("Registre seu nome: ");
        String nome = scanner.nextLine();
        System.out.println();
        System.out.println("Registre seu telefone: ");
        Integer telefone = Integer.valueOf(scanner.nextLine());
        System.out.println();
        System.out.println("Registre sua data de nascimento: ");
        String nascimento = scanner.nextLine();
        DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate dataDeNascimento = LocalDate.parse(nascimento, formatador);
        System.out.println();
        System.out.println("Seu codigo de inscrição é :" + codigo);
        System.out.println();
        System.out.println("Registre seu cpf: ");
        Long cpf = scanner.nextLong();
        System.out.println();
        Pessoa pessoa;
        if (tipo == TipoPessoa.ALUNO) {
            System.out.println("Digite a nota do processo seletivo de 0 a 10 : ");
            Double nota = scanner.nextDouble();
            System.out.println();
            System.out.println("Escolha a situação atual do aluno ");
            this.exibirMenuAluno();
            int codigoSituacao = scanner.nextInt();
            String situacao = OperacaoSituacaoAluno.obterPeloCodigoAluno(codigoSituacao).name();
            int atendimento = 0;
            pessoa = new Aluno(nome, telefone, dataDeNascimento, cpf, codigo, nota, atendimento, situacao);

        } else if (tipo == TipoPessoa.PROFESSOR) {
            System.out.println("Escolha uma opção da formação do professor");
            this.exibirFormacaoProfessor();
            int codigoFormacao = scanner.nextInt();
            String situacaoFormacao = OperacaoFormacaoProfessor.obterPeloCodigoProfessor(codigoFormacao).name();

            System.out.println("Escolha uma opção da experiencia do professor");
            this.exibirExperienciaProfessor();
            int codigoExperiencia = scanner.nextInt();
            String situacaoExperiencia = OperacaoExperienciaProfessor.obterPeloCodigoProfessorEx(codigoExperiencia).name();

            System.out.println("Escolha uma opção de Estado do professor");
            this.exibirEstadoProfessor();
            int codigoEstado = scanner.nextInt();
            String situacaoEstado = OperacaoEstadoProfessor.obterPeloCodigoProfessorEst(codigoEstado).name();

            pessoa = new Professor(nome, telefone, dataDeNascimento, cpf, codigo, situacaoEstado, situacaoExperiencia, situacaoFormacao);


        } else {
            int numeroAtendimento = 0;
            pessoa = new Pedagogo(nome, telefone, dataDeNascimento, cpf, codigo, numeroAtendimento);
        }
        return pessoa;
    }

    public void aguardar() {                                                     //Necessario um tecla para continuar rodando o codigo.
        System.out.println("Pressione qualquer tecla para continuar... ");
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
        System.out.println();
    }

    public void exibirmensagem(String msg) {

        System.out.println(msg);
    }

    public void listar(List<Pessoa> pessoas, int opcao) {   //Listagem de "Pessoas" atravez da ecolha do usuario.
        if (opcao == 1) {

            for (Pessoa pessoa : pessoas) {
                if (pessoa instanceof Aluno) {
                    Aluno aluno = (Aluno) pessoa;
                    System.out.println(aluno.relatorio());
                }

            }
        }
        if (opcao == 2) {
            for (Pessoa pessoa : pessoas) {
                if (pessoa instanceof Professor) {
                    Professor professor = (Professor) pessoa;
                    System.out.println(professor.relatorio());
                }

            }
        }
        if (opcao == 3) {
            for (Pessoa pessoa : pessoas) {
                if (pessoa instanceof Pedagogo) {
                    Pedagogo pedagogo = (Pedagogo) pessoa;
                    System.out.println(pedagogo.relatorio());
                }

            }
        }
        if (opcao == 4) {
            for (Pessoa pessoa : pessoas) {


                System.out.println(pessoa.relatorio());

            }
        }
    }

    public void listarRelatorioAlunos(List<Pessoa> alunos, int opcao2) {  //Relatorio do aluno atravez da "Situação".
        if (opcao2 == 1) {
            for (Pessoa pessoa : alunos) {
                if (pessoa instanceof Aluno) {
                    Aluno aluno = (Aluno) pessoa;
                    if (aluno.getSituacao().compareTo("ATIVO") == 0) {
                        System.out.println(aluno.relatorioAlunos());
                    }
                }
            }
        }
        if (opcao2 == 2) {
            for (Pessoa pessoa : alunos) {
                if (pessoa instanceof Aluno) {
                    Aluno aluno = (Aluno) pessoa;
                    if (aluno.getSituacao().compareTo("IRREGULAR") == 0) {
                        System.out.println(aluno.relatorioAlunos());
                    }
                }
            }
        }
        if (opcao2 == 3) {
            for (Pessoa pessoa : alunos) {
                if (pessoa instanceof Aluno) {
                    Aluno aluno = (Aluno) pessoa;
                    if (aluno.getSituacao().compareTo("ATENDIMENTO PEDAGÓGICO") == 0) {
                        System.out.println(aluno.relatorioAlunos());
                    }
                }
            }
        }
        if (opcao2 == 4) {
            for (Pessoa pessoa : alunos) {
                if (pessoa instanceof Aluno) {
                    Aluno aluno = (Aluno) pessoa;
                    if (aluno.getSituacao().compareTo("INATIVO") == 0) {
                        System.out.println(aluno.relatorioAlunos());
                    }
                }
            }
        }
        if (opcao2 == 5) {
            for (Pessoa pessoa : alunos) {
                if (pessoa instanceof Aluno) {
                    Aluno aluno = (Aluno) pessoa;
                    System.out.println(aluno.relatorio());
                }
            }
        }
    }

    public void listarRelatorioProfessores(List<Pessoa> professores, int opcao3) {   //Relatorio dos professores atravez da "Experiencia"
        if (opcao3 == 1) {
            for (Pessoa pessoa : professores) {
                if (pessoa instanceof Professor) {
                    Professor professor = (Professor) pessoa;
                    if (professor.getSituacaoExperiencia().compareTo("FRONT_END") == 0) {
                        System.out.println(professor.relatorioProfessor());
                    }
                }
            }
        }
        if (opcao3 == 2) {
            for (Pessoa pessoa : professores) {
                if (pessoa instanceof Professor) {
                    Professor professor = (Professor) pessoa;
                    if (professor.getSituacaoExperiencia().compareTo("BACK_END") == 0) {
                        System.out.println(professor.relatorioProfessor());
                    }
                }
            }
        }
        if (opcao3 == 3) {
            for (Pessoa pessoa : professores) {
                if (pessoa instanceof Professor) {
                    Professor professor = (Professor) pessoa;
                    if (professor.getSituacaoExperiencia().compareTo("FULL_STACK") == 0) {
                        System.out.println(professor.relatorioProfessor());
                    }
                }
            }
        }
        if (opcao3 == 4) {
            for (Pessoa pessoa : professores) {
                if (pessoa instanceof Professor) {
                    Professor professor = (Professor) pessoa;
                    System.out.println(professor.relatorioProfessor());
                }
            }
        }
    }


    public Pessoa alterarSituacao(List<Pessoa> pessoas) {     //Aqui ele podera alterar no cadastro atraves do codigo do aluno.
        for (Pessoa pessoa : pessoas) {
            if (pessoa instanceof Aluno) {
                Aluno aluno = (Aluno) pessoa;
                System.out.println(aluno.relatorio());
                System.out.println();
            }
        }
        System.out.println("Selecione o aluno atraves do codigo para realizar a alteracão: ");
        Scanner scanner = new Scanner(System.in);
        int codAlterado = (scanner.nextInt());
        System.out.println("Escolha a situação atual do aluno: ");
        exibirMenuAluno();
        int situacaoAluno = scanner.nextInt();
        String situacao = String.valueOf(OperacaoSituacaoAluno.obterPeloCodigoAluno(situacaoAluno));
        for (Pessoa pessoa : pessoas) {
            if (pessoa.getCod() == codAlterado) {
                Aluno aluno = (Aluno) pessoa;
                aluno.setSituacao(situacao);
            }
        }
        return null;
    }

    public Pessoa atendimentoPedagogico(List<Pessoa> atendimento) {   //Selecionar o pedagogo e o aluno para realizar um atendimento.

        for (Pessoa pessoa : atendimento) {
            if (pessoa instanceof Aluno) {
                Aluno aluno = (Aluno) pessoa;
                System.out.println(aluno.relatorio());
            }
        }
        System.out.println("Selecione o aluno  atravez do codigo para o atendimento pedagogico  :");
        Scanner scanner = new Scanner(System.in);
        int codigo = scanner.nextInt();
        for (Pessoa pessoa : atendimento) {
            if (pessoa.getCod() == codigo) {
                Aluno aluno = (Aluno) pessoa;
                aluno.setAtendimento(aluno.getAtendimento() + 1);
            }
        }
        for (Pessoa pessoa : atendimento) {
            if (pessoa instanceof Pedagogo) {
                Pedagogo pedagogo = (Pedagogo) pessoa;
                System.out.println(pedagogo.relatorio());
            }
        }
        System.out.println("Selecione o pedagogo atravez do codigo para o atendimento pedagogico :");
        int codigo2 = scanner.nextInt();
        for (Pessoa pessoa : atendimento) {
            if (pessoa.getCod() == codigo2) {
                Pedagogo pedagogo = (Pedagogo) pessoa;
                pedagogo.setNumeroAtendimento(pedagogo.getNumeroAtendimento() + 1);
            }

        }
        return null;
    }


    public Pessoa relatorioDeAlunosComMaisAtendimentos(List<Aluno> alunosOrdem) {
        for (Aluno aluno : alunosOrdem) {
                System.out.println(aluno.relatorioDeAlunosPedagogicos());

            }
        return null;
    }

    private List<Aluno> alunosOrdem = new ArrayList<>();

    public Pessoa relatorioDePedagogosComMaisAtendimentos(List<Pedagogo> pedagogosOrdem) {
        for (Pedagogo pedagogo : pedagogosOrdem) {
                System.out.println(pedagogo.relatorioDePedagogosPedagogicos());
            }

        return null;   }
    private List<Aluno> pedagogoOrdem = new ArrayList<>();
}