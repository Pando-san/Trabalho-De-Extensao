package com.org.sistemagerenciamento;

public class SistemaGerenciamento {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");

        // Criando categorias
        Categoria tipo = new Categoria(2, "tampa");
        Categoria embalagem = new Categoria(3, "embalagem");

        // Criando produtos
        Produto produto1 = new Produto(01, "Tampa", tipo.getNome(), 10);
        Produto produto2 = new Produto(02, "Embalagem", embalagem.getNome(), 10);
        Produto produto3 = new Produto(03, "Caixa", embalagem.getNome(), 50);

        // Criando estoque e adicionando produto
        Estoque estoque = new Estoque();
        estoque.adicionarProduto(produto1);
        estoque.adicionarProduto(produto2);
        estoque.adicionarProduto(produto3);

        // Listando produtos no estoque
        System.out.println("\nProdutos no estoque:");
        estoque.listarProdutos();

        // Atualizando quantidade de um produto
        estoque.atualizarQuantidade(01, 50000);
        System.out.println("\nApos a atualização:");
        estoque.listarProdutos();

        // Buscando por nome
        Produto encontrado = estoque.buscarProdutoPorNome("Tampa");
        if (encontrado != null) {
            System.out.println("\nProduto encontrado: " + encontrado);
        } else {
            System.err.println("\nProduto não encontrado.");
        }

        // Verificando produtos em falta
        estoque.verificarProdutosEmfalta(10);


        // Removendo um produto
        estoque.removerProduto(2);
        System.out.println("\nApós a remoção:");
        estoque.listarProdutos();

        // Exibe histórico de movimentação
        estoque.exbibirHistorico();
    }
}