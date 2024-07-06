package util;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InterfaceUsuario {
    private Scanner scanner;

    public InterfaceUsuario() {
        scanner = new Scanner(System.in);
    }

    public String solicitarTipoFinanciamento() {
        String tipoFinanciamento = "";
        boolean entradaValida = false;
        do {
            try {
                System.out.print("Digite o tipo de financiamento (casa/apartamento/terreno): ");
                tipoFinanciamento = scanner.next().toLowerCase();
                if (!tipoFinanciamento.equals("casa") && !tipoFinanciamento.equals("apartamento") && !tipoFinanciamento.equals("terreno")) {
                    throw new IllegalArgumentException("Erro 08: Tipo Inválido! Digite 'casa', 'apartamento' ou 'terreno'.");
                }
                entradaValida = true;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        } while (!entradaValida);
        return tipoFinanciamento;
    }

    public double solicitarValorImovel() {
        double valorImovel = 0;
        boolean entradaValida = false;
        do {
            try {
                System.out.print("Digite o valor do imóvel: ");
                valorImovel = scanner.nextDouble();
                if (valorImovel <= 0) {
                    throw new IllegalArgumentException("Erro 01: Valor Inválido! O valor do imóvel deve ser positivo.");
                }
                entradaValida = true;
            } catch (InputMismatchException e) {
                System.out.println("Erro: Entrada inválida. Por favor, digite um número válido.");
                scanner.next(); // Limpa a entrada inválida
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        } while (!entradaValida);
        return valorImovel;
    }

    public int solicitarPrazoFinanciamento() {
        int prazoFinanciamento = 0;
        boolean entradaValida = false;
        do {
            try {
                System.out.print("Digite o prazo do financiamento (em anos): ");
                prazoFinanciamento = scanner.nextInt();
                if (prazoFinanciamento <= 0 || prazoFinanciamento > 30) {
                    throw new IllegalArgumentException("Erro 02: Valor Inválido! O prazo do financiamento deve ser positivo e não mais que 30 anos.");
                }
                entradaValida = true;
            } catch (InputMismatchException e) {
                System.out.println("Erro: Entrada inválida. Por favor, digite um número válido.");
                scanner.next(); // Limpa a entrada inválida
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        } while (!entradaValida);
        return prazoFinanciamento;
    }

    public double solicitarTaxaJurosAnual() {
        double taxaJurosAnual = 0;
        boolean entradaValida = false;
        do {
            try {
                System.out.print("Digite a taxa de juros anual (%): ");
                taxaJurosAnual = scanner.nextDouble();
                if (taxaJurosAnual <= 0 || taxaJurosAnual > 100) {
                    throw new IllegalArgumentException("Erro 03: Valor Inválido! A taxa de juros deve ser positiva e razoável.");
                }
                entradaValida = true;
            } catch (InputMismatchException e) {
                System.out.println("Erro: Entrada inválida. Por favor, digite um número válido.");
                scanner.next(); // Limpa a entrada inválida
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        } while (!entradaValida);
        return taxaJurosAnual;
    }

    public double solicitarTamanhoAreaConstruida() {
        double tamanhoAreaConstruida = 0;
        boolean entradaValida = false;
        do {
            try {
                System.out.print("Digite o tamanho da área construída (em m²): ");
                tamanhoAreaConstruida = scanner.nextDouble();
                if (tamanhoAreaConstruida <= 0) {
                    throw new IllegalArgumentException("Erro 04: Valor Inválido! O tamanho da área construída deve ser positivo.");
                }
                entradaValida = true;
            } catch (InputMismatchException e) {
                System.out.println("Erro: Entrada inválida. Por favor, digite um número válido.");
                scanner.next(); // Limpa a entrada inválida
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        } while (!entradaValida);
        return tamanhoAreaConstruida;
    }

    public double solicitarTamanhoTerreno() {
        double tamanhoTerreno = 0;
        boolean entradaValida = false;
        do {
            try {
                System.out.print("Digite o tamanho do terreno (em m²): ");
                tamanhoTerreno = scanner.nextDouble();
                if (tamanhoTerreno <= 0) {
                    throw new IllegalArgumentException("Erro 05: Valor Inválido! O tamanho do terreno deve ser positivo.");
                }
                entradaValida = true;
            } catch (InputMismatchException e) {
                System.out.println("Erro: Entrada inválida. Por favor, digite um número válido.");
                scanner.next(); // Limpa a entrada inválida
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        } while (!entradaValida);
        return tamanhoTerreno;
    }

    public int solicitarNumeroVagasGaragem() {
        int numeroVagasGaragem = 0;
        boolean entradaValida = false;
        do {
            try {
                System.out.print("Digite o número de vagas da garagem: ");
                numeroVagasGaragem = scanner.nextInt();
                if (numeroVagasGaragem < 0) {
                    throw new IllegalArgumentException("Erro 06: Valor Inválido! O número de vagas da garagem deve ser não negativo.");
                }
                entradaValida = true;
            } catch (InputMismatchException e) {
                System.out.println("Erro: Entrada inválida. Por favor, digite um número válido.");
                scanner.next(); // Limpa a entrada inválida
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        } while (!entradaValida);
        return numeroVagasGaragem;
    }

    public int solicitarNumeroAndar() {
        int numeroAndar = 0;
        boolean entradaValida = false;
        do {
            try {
                System.out.print("Digite o número do andar: ");
                numeroAndar = scanner.nextInt();
                if (numeroAndar <= 0) {
                    throw new IllegalArgumentException("Erro 07: Valor Inválido! O número do andar deve ser positivo.");
                }
                entradaValida = true;
            } catch (InputMismatchException e) {
                System.out.println("Erro: Entrada inválida. Por favor, digite um número válido.");
                scanner.next(); // Limpa a entrada inválida
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        } while (!entradaValida);
        return numeroAndar;
    }

    public String solicitarTipoZona() {
        String tipoZona = "";
        boolean entradaValida = false;
        do {
            try {
                System.out.print("Digite o tipo de zona (residencial/comercial): ");
                tipoZona = scanner.next().toLowerCase();
                if (!tipoZona.equals("residencial") && !tipoZona.equals("comercial")) {
                    throw new IllegalArgumentException("Erro 08: Tipo de Zona Inválido! Digite 'residencial' ou 'comercial'.");
                }
                entradaValida = true;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        } while (!entradaValida);
        return tipoZona;
    }
}