package main;

import modelo.Casa;
import modelo.Terreno;
import modelo.Apartamento;
import modelo.Financiamento;
import util.InterfaceUsuario;
import util.DescontoMaiorDoQueJurosException;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Main {
    public static void main(String[] args) {
        InterfaceUsuario interfaceUsuario = new InterfaceUsuario();

        // Solicita a quantidade de financiamentos
        int quantidadeFinanciamentos = interfaceUsuario.solicitarQuantidadeFinanciamentos();

        // Criação de Array para Armazenar os Financiamentos
        List<Financiamento> listaDeFinanciamentos = new ArrayList<Financiamento>();

        // Solicita os dados para cada financiamento
        for (int i = 1; i <= quantidadeFinanciamentos; i++) {
            System.out.println("Inserindo dados para o financiamento " + i + ":");
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
                        casa.aplicarDesconto(500); // Exemplo de aplicação de desconto
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

        // Salvando os dados em um arquivo de texto
        salvarDadosTexto(listaDeFinanciamentos, "financiamentos.txt");

        // Lendo os dados do arquivo de texto
        List<Financiamento> financiamentosLidos = lerDadosTexto("financiamentos.txt");

        // Calculando e exibindo os totais
        double totalImoveis = 0;
        double totalFinanciamentos = 0;
        int contador = 0;

        System.out.println("************************************************************************************************");
        for (Financiamento financiamento : financiamentosLidos) {
            contador++;
            financiamento.mostrarInformacoes();
            totalImoveis += financiamento.getValorImovel();
            totalFinanciamentos += financiamento.pagamentoTotal();
        }

        System.out.printf("Total de todos os imóveis: R$ %.2f, total de todos os financiamentos: R$ %.2f%n",
                totalImoveis, totalFinanciamentos);

        // Serializando os dados
        serializarDados(listaDeFinanciamentos, "financiamentos.ser");

        // Desserializando os dados
        List<Financiamento> financiamentosDesserializados = desserializarDados("financiamentos.ser");

        // Verificando se os dados foram desserializados corretamente
        System.out.println("************************************************************************************************");
        for (Financiamento financiamento : financiamentosDesserializados) {
            financiamento.mostrarInformacoes();
        }
    }

    private static void salvarDadosTexto(List<Financiamento> financiamentos, String nomeArquivo) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(nomeArquivo))) {
            for (Financiamento financiamento : financiamentos) {
                if (financiamento instanceof Casa) {
                    Casa casa = (Casa) financiamento;
                    writer.write(String.format(Locale.US,"casa,%.2f,%d,%.2f,%.2f,%.2f%n",
                            casa.getValorImovel(), casa.getPrazoFinanciamento(), casa.getTaxaJurosAnual(),
                            casa.getTamanhoAreaConstruida(), casa.getTamanhoTerreno()));
                } else if (financiamento instanceof Apartamento) {
                    Apartamento apartamento = (Apartamento) financiamento;
                    writer.write(String.format(Locale.US,"apartamento,%.2f,%d,%.2f,%d,%d,%n",
                            apartamento.getValorImovel(), apartamento.getPrazoFinanciamento(), apartamento.getTaxaJurosAnual(),
                            apartamento.getNumeroVagasGaragem(), apartamento.getNumeroAndar()));
                } else if (financiamento instanceof Terreno) {
                    Terreno terreno = (Terreno) financiamento;
                    writer.write(String.format(Locale.US,"terreno,%.2f,%d,%.2f,%s,%n",
                            terreno.getValorImovel(), terreno.getPrazoFinanciamento(), terreno.getTaxaJurosAnual(),
                            terreno.getTipoZona()));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private static List<Financiamento> lerDadosTexto(String nomeArquivo) {
        List<Financiamento> financiamentos = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(nomeArquivo))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                String[] partes = linha.split(",");
                String tipo = partes[0];
                double valorImovel = Double.parseDouble(partes[1]);
                int prazoFinanciamento = Integer.parseInt(partes[2]);
                double taxaJurosAnual = Double.parseDouble(partes[3]);

                if (tipo.equals("casa")) {
                    double tamanhoAreaConstruida = Double.parseDouble(partes[4]);
                    double tamanhoTerreno = Double.parseDouble(partes[5]);
                    financiamentos.add(new Casa(valorImovel, prazoFinanciamento, taxaJurosAnual, tamanhoAreaConstruida, tamanhoTerreno));
                } else if (tipo.equals("apartamento")) {
                    int numeroVagasGaragem = Integer.parseInt(partes[4]);
                    int numeroAndar = Integer.parseInt(partes[5]);
                    financiamentos.add(new Apartamento(valorImovel, prazoFinanciamento, taxaJurosAnual, numeroVagasGaragem, numeroAndar));
                } else if (tipo.equals("terreno")) {
                    String tipoZona = partes[4];
                    financiamentos.add(new Terreno(valorImovel, prazoFinanciamento, taxaJurosAnual, tipoZona));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return financiamentos;
    }

    private static void serializarDados(List<Financiamento> financiamentos, String nomeArquivo) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(nomeArquivo))) {
            oos.writeObject(financiamentos);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static List<Financiamento> desserializarDados(String nomeArquivo) {
        List<Financiamento> financiamentos = null;
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(nomeArquivo))) {
            financiamentos = (List<Financiamento>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return financiamentos;
    }
}