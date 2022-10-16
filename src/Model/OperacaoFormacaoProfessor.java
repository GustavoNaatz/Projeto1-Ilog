package Model;

public enum OperacaoFormacaoProfessor {
    GRADUACAO_INCOMPLETA,
    GRADUACAO_COMPLETA,
    MESTRADO,
    DOUTORADO;

    public static OperacaoFormacaoProfessor obterPeloCodigoProfessor(int codigo) {
        OperacaoFormacaoProfessor[] operacoesProfessor = OperacaoFormacaoProfessor.values();
        return operacoesProfessor[codigo - 1];
    }

}