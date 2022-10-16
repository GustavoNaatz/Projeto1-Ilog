package Model;

public enum OperacaoExperienciaProfessor {
    FRONT_END,
    BACK_END,
    FULL_STACK;


    public static OperacaoExperienciaProfessor obterPeloCodigoProfessorEx(int codigo) {
        OperacaoExperienciaProfessor[] operacoesProfessorEX = OperacaoExperienciaProfessor.values();
        return operacoesProfessorEX[codigo - 1];
    }

}
