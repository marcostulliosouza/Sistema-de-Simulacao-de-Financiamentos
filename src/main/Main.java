package main;

import modelo.Casa;
import modelo.Terreno;
import modelo.Apartamento;
import modelo.Financiamento;
import util.InterfaceUsuario;
import util.DescontoMaiorDoQueJurosException;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        InterfaceUsuario interfaceUsuario = new InterfaceUsuario();

        // Solicita a quantidade de financiamentos
        int quantidadeFinanciamentos = interfaceUsuario.solicitarQuantidadeFinanciamentos();

        // Criação de Array para Armazenar os Financiamentos
        List<Financiamento> listaDeFinanciamentos = new ArrayList<>();

        // Loop para criar cada financiamento
        for (int i = 0; i < quantidadeFinanciamentos; i++) {
            System.out.println("************************************************************************************************");
            System.out.printf("Inserindo dados para o financiamento %d:%n", i + 1);
            String tipoFinanciamento = interfaceUsuario.solicitarTipoFinanciamento();
            double valorImovel = interfaceUsuario.solicitarValorImovel();
            int prazoFinanciamento = interfaceUsuario.solicitarPrazoFinanciamento();
            double taxaJurosAnual = interfaceUsuario.solicitarTaxaJurosAnual();

            switch (tipoFinanciamento) {
                case "casa":
                    double tamanhoAreaConstruida = interfaceUsuario.solicitarTamanhoAreaConstruida();
                    double tamanhoTerreno = interfaceUsuario.solicitarTamanhoTerreno();
                    Casa casa = new Casa(valorImovel, prazoFinanciamento, taxaJurosAnual, tamanhoAreaConstruida, tamanhoTerreno);
                    listaDeFinanciamentos.add(casa);
                    try {
                        casa.aplicarDesconto(1000); // Exemplo de aplicação de desconto
                    } catch (DescontoMaiorDoQueJurosException e) {
                        System.out.println(e.getMessage());
                    }
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
        }

        // Calculando e exibindo os totais
        double totalImoveis = 0;
        double totalFinanciamentos = 0;
        int contador = 0;

        System.out.println("************************************************************************************************");
        for (Financiamento financiamento : listaDeFinanciamentos) {
            contador++;
            financiamento.mostrarInformacoes();
            totalImoveis += financiamento.getValorImovel();
            totalFinanciamentos += financiamento.pagamentoTotal();
        }

        System.out.printf("Total de todos os imóveis: R$ %.2f, total de todos os financiamentos: R$ %.2f%n",
                totalImoveis, totalFinanciamentos);
    }
}
