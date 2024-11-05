package br.com.dio.desafio.dominio;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

public class Bootcamp {
    private String nome;
    private String descricao;
    private final LocalDate dataInicial = LocalDate.now();
    private final LocalDate dataFinal = dataInicial.plusDays(45);
    private final Set<Dev> devsInscritos = new HashSet<>();
    private final Set<Conteudo> conteudos = new LinkedHashSet<>();

    public Bootcamp(String nome, String descricao) {
        this.setNome(nome);
        this.setDescricao(descricao);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        if (nome == null || nome.trim().isEmpty()) {
            System.err.println("O nome não pode ser nulo ou vazio.");
        } else {
            this.nome = nome;
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

    public LocalDate getDataInicial() {
        return dataInicial;
    }

    public LocalDate getDataFinal() {
        return dataFinal;
    }

    public Set<Dev> getDevsInscritos() {
        return devsInscritos;
    }

    public Set<Conteudo> getConteudos() {
        return conteudos;
    }

    public void adicionarConteudo(Conteudo conteudo) {
        this.conteudos.add(conteudo);
    }

    public void removerConteudo(Conteudo conteudo) {
        this.conteudos.remove(conteudo);
    }

    public void inscreverDev(Dev dev) {
        this.devsInscritos.add(dev);
    }

    public void desinscreverDev(Dev dev) {
        this.devsInscritos.remove(dev);
    }

    public long calcularDiasRestantes() {
        return ChronoUnit.DAYS.between(LocalDate.now(), dataFinal);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bootcamp bootcamp = (Bootcamp) o;
        return Objects.equals(nome, bootcamp.nome) && 
               Objects.equals(descricao, bootcamp.descricao) && 
               Objects.equals(dataInicial, bootcamp.dataInicial) && 
               Objects.equals(dataFinal, bootcamp.dataFinal) && 
               Objects.equals(devsInscritos, bootcamp.devsInscritos) && 
               Objects.equals(conteudos, bootcamp.conteudos);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, descricao, dataInicial, dataFinal, devsInscritos, conteudos);
    }
}
