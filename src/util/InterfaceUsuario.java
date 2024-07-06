package util;

import java.util.Scanner;

public class InterfaceUsuario {
    private Scanner scanner;

    public InterfaceUsuario() {
        scanner = new Scanner(System.in);
    }

    public String solicitarTipoFinanciamento() {
        System.out.print("Digite o tipo de financiamento (casa/apartamento/terreno): ");
        return scanner.next().toLowerCase();
    }

    public double solicitarValorImovel() {
        double valorImovel;
        do {
            System.out.print("Digite o valor do imóvel: ");
            valorImovel = scanner.nextDouble();
            if (valorImovel <= 0) {
                System.out.println("Erro 01: Valor Inválido! O valor do imóvel deve ser positivo.");
            }
        } while (valorImovel <= 0);
        return valorImovel;
    }

    public int solicitarPrazoFinanciamento() {
        int prazoFinanciamento;
        do {
            System.out.print("Digite o prazo do financiamento (em anos): ");
            prazoFinanciamento = scanner.nextInt();
            if (prazoFinanciamento <= 0 || prazoFinanciamento > 30) {
                System.out.println("Erro 02: Valor Inválido! O prazo do financiamento deve ser positivo e não mais que 30 anos.");
            }
        } while (prazoFinanciamento <= 0 || prazoFinanciamento > 30);
        return prazoFinanciamento;
    }

    public double solicitarTaxaJurosAnual() {
        double taxaJurosAnual;
        do {
            System.out.print("Digite a taxa de juros anual (%): ");
            taxaJurosAnual = scanner.nextDouble();
            if (taxaJurosAnual <= 0 || taxaJurosAnual > 100) {
                System.out.println("Erro 03: Valor Inválido! A taxa de juros deve ser positiva e razoável.");
            }
        } while (taxaJurosAnual <= 0 || taxaJurosAnual > 100);
        return taxaJurosAnual;
    }

    public double solicitarTamanhoAreaConstruida() {
        double tamanhoAreaConstruida;
        do {
            System.out.print("Digite o tamanho da área construída (em m²): ");
            tamanhoAreaConstruida = scanner.nextDouble();
            if (tamanhoAreaConstruida <= 0) {
                System.out.println("Erro 04: Valor Inválido! O tamanho da área construída deve ser positivo.");
            }
        } while (tamanhoAreaConstruida <= 0);
        return tamanhoAreaConstruida;
    }

    public double solicitarTamanhoTerreno() {
        double tamanhoTerreno;
        do {
            System.out.print("Digite o tamanho do terreno (em m²): ");
            tamanhoTerreno = scanner.nextDouble();
            if (tamanhoTerreno <= 0) {
                System.out.println("Erro 05: Valor Inválido! O tamanho do terreno deve ser positivo.");
            }
        } while (tamanhoTerreno <= 0);
        return tamanhoTerreno;
    }

    public int solicitarNumeroVagasGaragem() {
        int numeroVagasGaragem;
        do {
            System.out.print("Digite o número de vagas da garagem: ");
            numeroVagasGaragem = scanner.nextInt();
            if (numeroVagasGaragem < 0) {
                System.out.println("Erro 06: Valor Inválido! O número de vagas da garagem deve ser não negativo.");
            }
        } while (numeroVagasGaragem < 0);
        return numeroVagasGaragem;
    }

    public int solicitarNumeroAndar() {
        int numeroAndar;
        do {
            System.out.print("Digite o número do andar: ");
            numeroAndar = scanner.nextInt();
            if (numeroAndar <= 0) {
                System.out.println("Erro 07: Valor Inválido! O número do andar deve ser positivo.");
            }
        } while (numeroAndar <= 0);
        return numeroAndar;
    }

    public String solicitarTipoZona() {
        System.out.print("Digite o tipo de zona (residencial/comercial): ");
        return scanner.next();
    }
}
