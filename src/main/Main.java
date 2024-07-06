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

        // Solicita os dados p/ um financiamento do usuário
        System.out.println("Informe os dados para um financiamento:");
        String tipoFinancimento = interfaceUsuario.solicitarTipoFinanciamento();
        double valorImovel = interfaceUsuario.solicitarValorImovel();
        int prazoFinanciamento = interfaceUsuario.solicitarPrazoFinanciamento();
        double taxaJurosAnual = interfaceUsuario.solicitarTaxaJurosAnual();

        switch (tipoFinancimento){
            case "casa":
                double tamanhoAreaConstruida = interfaceUsuario.solicitarTamanhoAreaConstruida();
                double tamanhoTerreno = interfaceUsuario.solicitarTamanhoTerreno();
                listaDeFinanciamentos.add(new Casa(valorImovel, prazoFinanciamento, taxaJurosAnual, tamanhoAreaConstruida, tamanhoTerreno));
                break;
            case "apartamento":
                int numeroVagasGaragem = interfaceUsuario.solicitarNumeroVagasGaragem();
                int numeroAndar = interfaceUsuario.solicitarNumeroAndar();
                listaDeFinanciamentos.add(new Apartamento(valorImovel, prazoFinanciamento, taxaJurosAnual, numeroVagasGaragem, numeroAndar));
                break;
            case "terreno":
                String tipoZona = interfaceUsuario.solicitarTipoZona();
                listaDeFinanciamentos.add(new Terreno(valorImovel, prazoFinanciamento, taxaJurosAnual, tipoZona));
                break;
        }

//        // Adiciona financiamentos diretamente no código
//        listaDeFinanciamentos.add(new Casa(200000, 10, 4.5, 120, 200));
//        listaDeFinanciamentos.add(new Casa(300000, 15, 5.0, 150, 300));
//        listaDeFinanciamentos.add(new Apartamento(250000, 20, 3.5, 2, 10));
//        listaDeFinanciamentos.add(new Terreno(100000, 10, 6.0, "Residencial"));

        // Calculando e exibindo os totais
        double totalImoveis = 0;
        double totalFinanciamentos = 0;
        int contador = 0;

        System.out.println("************************************************************************************************");
        for (Financiamento financiamento : listaDeFinanciamentos) {
            contador++;
            System.out.printf("Financiamento %d - ", contador);
            financiamento.mostrarInformacoes();
            totalImoveis += financiamento.getValorImovel();
            totalFinanciamentos += financiamento.pagamentoTotal();
        }

        System.out.printf("Total de todos os imóveis: R$ %.2f, total de todos os financiamentos: R$ %.2f%n",
                totalImoveis, totalFinanciamentos);
    }
}
