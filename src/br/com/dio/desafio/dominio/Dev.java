package br.com.dio.desafio.dominio;

import java.time.LocalDate;
import java.util.*;

public class Dev {
    private String nome;
    private Set<Conteudo> conteudosInscritos = new LinkedHashSet<>();
    private Set<Conteudo> conteudosConcluidos = new LinkedHashSet<>();
    private Map<Conteudo, LocalDate> dataInscricao = new HashMap<>();
    private Map<Conteudo, LocalDate> dataConclusao = new HashMap<>();
    private List<String> habilidades = new ArrayList<>();
    private List<Conteudo> historico = new ArrayList<>();

    public void inscreverBootcamp(Bootcamp bootcamp) {
        this.conteudosInscritos.addAll(bootcamp.getConteudos());
        bootcamp.getDevsInscritos().add(this);
        
        // Registra a data de inscrição para cada conteúdo do bootcamp
        for (Conteudo conteudo : bootcamp.getConteudos()) {
            dataInscricao.put(conteudo, LocalDate.now());
        }
    }

    public void progredir() {
        Optional<Conteudo> conteudo = this.conteudosInscritos.stream().findFirst();
        if(conteudo.isPresent()) {
            this.conteudosConcluidos.add(conteudo.get());
            this.historico.add(conteudo.get()); // Adiciona ao histórico
            this.conteudosInscritos.remove(conteudo.get());
            
            // Registra a data de conclusão e remove do conjunto de inscritos
            dataConclusao.put(conteudo.get(), LocalDate.now());
            
            // Adiciona uma habilidade após a conclusão do conteúdo (caso aplicável)
            adicionarHabilidade(conteudo.get().getTitulo());

            // Verifica se todos os conteúdos foram concluídos
            verificarConclusao();
        } else {
            System.err.println("Você não está matriculado em nenhum conteúdo!");
        }
    }

    public double calcularTotalXp() {
        // Simplificado usando stream
        return conteudosConcluidos.stream().mapToDouble(Conteudo::calcularXp).sum();
    }

    public String exibirProgresso() {
        return "Progresso: " + conteudosConcluidos.size() + "/" + (conteudosInscritos.size() + conteudosConcluidos.size());
    }

    public void verificarConclusao() {
        if (conteudosInscritos.isEmpty()) {
            System.out.println("Parabéns, " + nome + "! Você concluiu todos os conteúdos do Bootcamp!");
        }
    }

    public Optional<Conteudo> recomendarProximoConteudo() {
        return conteudosInscritos.stream().findFirst();
    }

    public void adicionarHabilidade(String habilidade) {
        habilidades.add(habilidade);
    }

    // Getters e Setters

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Set<Conteudo> getConteudosInscritos() {
        return conteudosInscritos;
    }

    public void setConteudosInscritos(Set<Conteudo> conteudosInscritos) {
        this.conteudosInscritos = conteudosInscritos;
    }

    public Set<Conteudo> getConteudosConcluidos() {
        return conteudosConcluidos;
    }

    public void setConteudosConcluidos(Set<Conteudo> conteudosConcluidos) {
        this.conteudosConcluidos = conteudosConcluidos;
    }

    public List<String> getHabilidades() {
        return habilidades;
    }

    public Map<Conteudo, LocalDate> getDataInscricao() {
        return dataInscricao;
    }

    public Map<Conteudo, LocalDate> getDataConclusao() {
        return dataConclusao;
    }

    public List<Conteudo> getHistorico() {
        return historico;
    }

    // Métodos de comparação e hash

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dev dev = (Dev) o;
        return Objects.equals(nome, dev.nome) &&
            Objects.equals(conteudosInscritos, dev.conteudosInscritos) &&
            Objects.equals(conteudosConcluidos, dev.conteudosConcluidos);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, conteudosInscritos, conteudosConcluidos);
    }
}
