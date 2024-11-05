package br.com.dio.desafio.dominio;

public abstract class Conteudo {

    protected static final double XP_PADRAO = 10d;

    private String titulo;
    private String descricao;

    public Conteudo() {
    }

    public Conteudo(String titulo, String descricao) {
        this.setTitulo(titulo);
        this.setDescricao(descricao);
    }

    public abstract double calcularXp();

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        if (titulo == null || titulo.trim().isEmpty()) {
            System.err.println("O título não pode ser nulo ou vazio.");
        } else {
            this.titulo = titulo;
        }
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        if (descricao == null || descricao.trim().isEmpty()) {
            System.err.println("A descrição não pode ser nula ou vazia.");
        } else {
            this.descricao = descricao;
        }
    }

    public static double getXpPadrao() {
        return XP_PADRAO;
    }

    public String exibirInformacoes() {
        return "Título: " + titulo + "\nDescrição: " + descricao;
    }
}
