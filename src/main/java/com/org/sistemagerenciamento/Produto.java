package com.org.sistemagerenciamento;

public class Produto {
    // Atributos
    public String nome;
    public int id;
    public String categoria;
    public double preco;
    public int quantidade;
  
    // Metodos
    public Produto (int id, String nome, String categoria, int quantidade){
      this.nome = nome;
      this.id = id;
      this.categoria = categoria;
      this.quantidade = quantidade;
    }
    // Getter e Setter
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public String getCategoria() { return categoria; }
    public void setCategoria(String categoria) { this.categoria = categoria; }
    public int getId() { return id;}
    public void setId(int id) { this.id = id; }
    public int getQuantidade() {return quantidade;}
    public void setQuantidade(int quantidade) {this.quantidade=quantidade;}

    @Override
    public String toString(){
        return "Produto [id=" + id + ", nome= " + nome + ", categoria=" + categoria
        + ", quantidade= " + quantidade +"]"; 
    }
}