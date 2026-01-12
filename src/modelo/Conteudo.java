package modelo;

public class Conteudo {
    private String nome;
    private int anoDeLancamento;

    public Conteudo(String nome, int anoDeLancamento) {
        this.nome = nome;
        this.anoDeLancamento = anoDeLancamento;

    }

    public Conteudo(ConteudoOmdb dto) {
        this.nome = dto.Title();

        try {
            this.anoDeLancamento =
                    Integer.parseInt(dto.Year().substring(0, 4));
        } catch (Exception e) {
            this.anoDeLancamento = 0;
        }
    }

    public String getNome() {
        return nome;
    }

    public int getAnoDeLancamento() {
        return anoDeLancamento;
    }

    @Override
    public String toString() {
        return "nome" + nome + " | " + "anoDeLancamento : " + anoDeLancamento;
    }
}
