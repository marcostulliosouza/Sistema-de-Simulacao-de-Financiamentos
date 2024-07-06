/*
* Nome do Aluno: Marcos Tullio Silva de Souza
* Disciplina: Fundamentos de Programação Orientado a Objetos
* Atividade Somativa 2: Múltiplos Financiamentos
* */

package main;

import modelo.Casa;
import modelo.Terreno;
import modelo.Apartamento;
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

            // Solicita os dados p/ um financiamento
            String tipoFinancimento = interfaceUsuario.solicitarTipoFinanciamento();
            double valorImovel = interfaceUsuario.solicitarValorImovel();
            int prazoFinanciamento = interfaceUsuario.solicitarPrazoFinanciamento();
            double taxaJurosAnual = interfaceUsuario.solicitarTaxaJurosAnual();
            System.out.println("\n");

            // Adiciona o financiamento com base no tipo
            switch (tipoFinancimento){
                case "casa":
                    listaDeFinanciamentos.add(new Casa(valorImovel, prazoFinanciamento, taxaJurosAnual));
                    break;
                case "apartamento":
                    listaDeFinanciamentos.add(new Apartamento(valorImovel, prazoFinanciamento, taxaJurosAnual));
                    break;
                case "terreno":
                    listaDeFinanciamentos.add(new Terreno(valorImovel, prazoFinanciamento, taxaJurosAnual));
                    break;
            }
        }

        // Calculando e exibindo os totais
        double totalImoveis = 0;
        double totalFinanciamentos = 0;
        int contador = 0;

        System.out.println("************************************************************************************************");
        for (Financiamento financiamento : listaDeFinanciamentos) {
            contador++;
            String tipo = financiamento.getClass().getSimpleName();
            System.out.printf("Financiamento %d [%s] - valor do imóvel: R$ %.2f, valor mensal: R$ %.2f, valor total do financiamento: R$ %.2f%n",
                    contador, tipo, financiamento.getValorImovel(), financiamento.pagamentoMensal(), financiamento.pagamentoTotal());
            totalImoveis += financiamento.getValorImovel();
            totalFinanciamentos += financiamento.pagamentoTotal();
        }

        System.out.printf("Total de todos os imóveis: R$ %.2f, total de todos os financiamentos: R$ %.2f%n",
                totalImoveis, totalFinanciamentos);
    }
}