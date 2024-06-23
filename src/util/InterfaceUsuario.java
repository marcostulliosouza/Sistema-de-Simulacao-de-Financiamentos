package util;

import java.util.Scanner;

public class InterfaceUsuario {
    private Scanner scanner;

    // Método Construtor
    public  InterfaceUsuario(){
        scanner = new Scanner(System.in);
    }

    // Método para Solicitar o Valor do Imóvel
    public double solicitarValorImovel(){
        double valorImovel;
        do{
            System.out.print("Digite o valor do imóvel: ");
            valorImovel = scanner.nextDouble();
            if (valorImovel <= 0){
                System.out.println("Erro 01: Valor Inválido! O valor do imóvel deve ser positivo.");
            }
        } while (valorImovel <= 0);
        return valorImovel;
    }
    // Método para Soliciar o Prazo do modelo.Financiamento
    public int solicitarPrazoFinanciamento(){
        int prazoFinanciamento;
        do{
            System.out.print("Digite o prazo do financiamento (em anos): ");
            prazoFinanciamento = scanner.nextInt();
            if (prazoFinanciamento <= 0 && prazoFinanciamento > 30){
                System.out.println("Erro 02: Valor Inválido! O prazo do financiamento deve ser positivo e não mais que 30 anos.");
            }
        } while(prazoFinanciamento <= 0 && prazoFinanciamento > 30);
        return prazoFinanciamento;
    }
    // Método para Solicitar a Taza de Juros Anual
    public double solicitarTaxaJurosAnual(){
        double taxaJurosAnual;
        do {
            System.out.print("Digite a taxa de juros anual (%): ");
            taxaJurosAnual = scanner.nextDouble();
            if (taxaJurosAnual <=0 || taxaJurosAnual > 100){
                System.out.println("Erro 03: Valor Inválido! A taxa de juros deve ser positiva e razoável.");
            }
        } while (taxaJurosAnual <=0 || taxaJurosAnual > 100);
        return taxaJurosAnual;
    }
}