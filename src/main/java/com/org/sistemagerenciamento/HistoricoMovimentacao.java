package com.org.sistemagerenciamento;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class HistoricoMovimentacao {
    private String operacao;
    private String produto;
    private int quantidade;
    private String dataHora;

    public HistoricoMovimentacao(String operacao, String produto, int quantidade){
        this.operacao= operacao;
        this.produto= produto;
        this.quantidade= quantidade;
        this.dataHora= LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss"));

    }
    @Override
    public String toString() {
        return "[" + dataHora + "] Operação: " + operacao + ", Produto: " + produto + ", Quantidade: " + quantidade;
    }
}