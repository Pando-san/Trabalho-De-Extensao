package com.org.sistemagerenciamento;

import java.util.*;

public class Estoque {
    private List<Produto> produtos;
    private List<HistoricoMovimentacao> historico;

    public Estoque(){
        this.produtos = new ArrayList<>();
        this.historico = new ArrayList<>();
    }

    //Adicionar produtos ao estoque
    public void adicionarProduto(Produto produto){
        produtos.add(produto);
        historico.add(new HistoricoMovimentacao("Adição", produto.getNome(), produto.getQuantidade()));

    }

    // Remover produtos do estoque
    public void removerProduto(int id){
        Produto produtoRemovido = buscarProdutoPorId(id);
        if (produtoRemovido !=  null) {
            historico.add(new HistoricoMovimentacao("Remoção", produtoRemovido.getNome(), produtoRemovido.getQuantidade()));
            produtos.remove(produtoRemovido);
        }
    }

    // Atualizar quantidade de um produto especifico
    public void atualizarQuantidade(int id, int novaQuantidade){
        for(Produto produto : produtos){
            if (produto.getId() == id) {
                int quantidadeAnterior = produto.getQuantidade();
                produto.setQuantidade(novaQuantidade);
                historico.add(new HistoricoMovimentacao("Atualização", produto.getNome(), 
                novaQuantidade - quantidadeAnterior));
                break;
            }
        }
    }

    // Exibir histórico de movimentação
    public void exbibirHistorico(){
        System.out.println("Histórico de movimentação:");
        for (HistoricoMovimentacao mov : historico){
            System.out.println(mov);
        }
    }

    // Buscar produto por ID
    public Produto buscarProdutoPorId(int id){
        for (Produto produto : produtos) {
            if (produto.getId() == id){
                return produto;
            }
        }
        return null;
    }

    // Buscar produto por Nome
    public Produto buscarProdutoPorNome(String nome){
        for (Produto produto : produtos){
            if (produto.getNome().equalsIgnoreCase(nome)){
                return produto;
            }
        }
        return null;
    }

    // Listar todos os produtos
    public void listarProdutos(){
        for (Produto produto : produtos) {
            System.out.println(produto);
        }
    }

    // Listar produtos oredenados por nome
    public void listarProdutosPorNome(){
        produtos.sort(Comparator.comparing(Produto::getNome));
        listarProdutos();
    }

    // Listar produtos oredenados por quantidade
    public void listarProdutosPorQuantidade(){
        produtos.sort(Comparator.comparing(Produto::getQuantidade));
        listarProdutos();
    }

    // Verificar produtos em falta
    public void verificarProdutosEmfalta(int limite){
        System.out.println("Produtos em falta (quantidade abaixo de "+ limite +")");
        for (Produto produto : produtos){
            if (produto.getQuantidade() < limite) {
                System.out.println(produto);
            }
        }
    }

    // Geração de relatórios - Resumo do Estoque
    public void gerarRelatoriosEstoque(){
        System.out.println("Relatório de estoque:");
        for (Produto produto : produtos){
            System.out.println(produto);
        }
    }

    // Geração de relatórios - Produtos em falta
    public void gerarRelatoriosProdutosEmFalta(int limite){
        for (Produto produto : produtos){
            if (produto.getQuantidade() < limite);
            System.out.println(produto);
        }
    }
}