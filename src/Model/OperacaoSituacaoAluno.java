package Model;

public enum OperacaoSituacaoAluno {
    ATIVO,
    IRREGULAR,
    ATENDIMENTO,
    INATIVO;


     public static OperacaoSituacaoAluno obterPeloCodigoAluno(int codigo) {
        OperacaoSituacaoAluno[] operacoesAluno = OperacaoSituacaoAluno.values();
        return operacoesAluno[codigo - 1];
    }
}