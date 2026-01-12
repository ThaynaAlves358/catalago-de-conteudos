package modelo;

import calculos.Classificavel;

public class Filme extends  Conteudo  implements Classificavel {

    private int duracaoEmMinutos;

    public Filme(String nome, int anoDeLancamento, int duracaoEmMinutos) {
        super(nome, anoDeLancamento);
        this.duracaoEmMinutos = duracaoEmMinutos;
    }
    public Filme(ConteudoOmdb dto) {
        super(dto);

        try {
            this.duracaoEmMinutos =
                    Integer.parseInt(dto.Runtime().substring(0, 2));
        } catch (Exception e) {
            this.duracaoEmMinutos = 0;
        }
    }

    @Override
    public int getClassificavel() {
        return 0;
    }
}
