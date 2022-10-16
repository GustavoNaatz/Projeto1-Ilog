package Model;

public enum OperacoesParaCadastro {
    CADASTRO_DE_ALUNO,                                  //0
    ATUALIZACAO_DA_SITUACAO_DA_MATRICULA_DE_ALUNO,      //1
    CADASTRO_DE_PROFESSOR,                              //2 ...
    CADASTRO_DE_PEDAGOGO,
    REALIZACAO_DE_ATENDIMENTO_PEDAGOGO,
    LISTAGEM_DE_PESSOAS,
    RELATORIO_DOS_ALUNOS,
    RELATORIO_DOS_PROFESSORES,
    RELATORIO_DE_ALUNOS_COM_MAIS_ATENDIMENTO_PEDAGOGICOS,

    PEDAGOGOS_COM_MAIS_ATENDIMENTOS_PEDAGOGICOS,
    SAIR;
//CONVERTER INT PARA OS VALORES DO CADASTRO
    public  static OperacoesParaCadastro obterPeloCodigo(int codigo){
    OperacoesParaCadastro[] operacoes= OperacoesParaCadastro.values();
    return operacoes[codigo-1];     //Codigo começa em 1, (1-1=0 -->CADASTRO_DE_ALUNO)

    }
}
