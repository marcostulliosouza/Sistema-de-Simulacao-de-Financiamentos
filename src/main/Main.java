package main;

import modelo.Financiamento;
import util.InterfaceUsuario;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        InterfaceUsuario interfaceUsuario = new InterfaceUsuario();

        // Criação de Array para Armazenar os Financiamentos
        List<Financiamento> listaDeFinanciamentos = new ArrayList<Financiamento>();

        // Solicitando a Quantidade de Financiamentos
        int qtdFinanciamentos = interfaceUsuario.solicitarQuantidadeFinanciamentos();

        for (int i = 0; i < qtdFinanciamentos; i++){
            System.out.print("Financiamento " + (i + 1) +": ");
            double valorImovel = interfaceUsuario.solicitarValorImovel();
            int prazoFinanciamento = interfaceUsuario.solicitarPrazoFinanciamento();
            double taxaJurosAnual = interfaceUsuario.solicitarTaxaJurosAnual();
            System.out.println("\n");
            // Criando o Financiamento e Adicionando na Lista
            listaDeFinanciamentos.add(new modelo.Financiamento(valorImovel, prazoFinanciamento, taxaJurosAnual));
        }

        // Calculando e exibindo os totais
        double totalImoveis = 0;
        double totalFinanciamentos = 0;
        int contador = 0;

        System.out.println("************************************************************************************************");
        for (Financiamento financiamento : listaDeFinanciamentos) {
            contador++;
            System.out.printf("Financiamento %d - valor do imóvel: R$ %.2f, valor do financiamento: R$ %.2f%n", contador, financiamento.getValorImovel(), financiamento.pagamentoTotal());
//            financiamento.mostrarInformacoes();
            totalImoveis += financiamento.getValorImovel();
            totalFinanciamentos += financiamento.pagamentoTotal();
        }

        // Exibindo os resultados
        System.out.printf("Total de todos os imóveis: R$ %.2f, total de todos os financiamentos: R$ %.2f%n", totalImoveis, totalFinanciamentos);
    }
}