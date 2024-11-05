package br.com.dio.desafio.dominio;

public class Curso extends Conteudo {

    private int cargaHoraria;
    private static final double XP_POR_HORA = XP_PADRAO;

    public Curso() {
    }

    public Curso(String titulo, String descricao, int cargaHoraria) {
        super.setTitulo(titulo);
        super.setDescricao(descricao);
        this.setCargaHoraria(cargaHoraria); // Usamos o setter para validar a carga horária
    }

    @Override
    public double calcularXp() {
        return XP_POR_HORA * cargaHoraria;
    }

    public int getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(int cargaHoraria) {
        if (cargaHoraria <= 0) {
            System.err.println("A carga horária deve ser maior que zero!");
        } else {
            this.cargaHoraria = cargaHoraria;
        }
    }

    @Override
    public String toString() {
        return "Curso{" +
                "titulo='" + getTitulo() + '\'' +
                ", descricao='" + getDescricao() + '\'' +
                ", cargaHoraria=" + cargaHoraria +
                ", XP=" + calcularXp() +
                '}';
    }
}
