package Model;

public enum OperacaoEstadoProfessor {
    ATIVO,
    INATIVO;

    public static OperacaoEstadoProfessor obterPeloCodigoProfessorEst(int codigo) {
        OperacaoEstadoProfessor[] operacoesProfessorEst = OperacaoEstadoProfessor.values();
        return operacoesProfessorEst[codigo - 1];
    }

}