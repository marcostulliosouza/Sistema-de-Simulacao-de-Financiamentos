package main;

import modelo.Financiamento;
import util.InterfaceUsuario;

public class Main {
    public static void main(String[] args) {
        InterfaceUsuario interfaceUsuario = new InterfaceUsuario();

        double valorImovel, taxaJurosAnual, pagamentoMensal, totalPagamento;
        int prazoFinanciamento;

        // Lendo os Dados
        valorImovel = interfaceUsuario.solicitarValorImovel();
        prazoFinanciamento = interfaceUsuario.solicitarPrazoFinanciamento();
        taxaJurosAnual = interfaceUsuario.solicitarTaxaJurosAnual();

        // Criando o Objeto modelo.Financiamento c/ os Dados Lidos
        Financiamento financiamento = new Financiamento(valorImovel, prazoFinanciamento, taxaJurosAnual);

        // Calculando e Resultados
        pagamentoMensal = financiamento.pagamentoMensal();
        totalPagamento = financiamento.pagamentoTotal();

        System.out.printf("Pagamento mensal: R$ %.2f%n", pagamentoMensal);
        System.out.printf("Total do pagamento: R$ %.2f%n", totalPagamento);
    }
}