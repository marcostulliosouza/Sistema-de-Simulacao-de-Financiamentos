package util;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InterfaceUsuario {
    private Scanner scanner;

    // Método Construtor
    public InterfaceUsuario() {
        scanner = new Scanner(System.in);
    }

    public String solicitarTipoFinanciamento() {
        String tipoFinanciamento = "";
        boolean valido = false;
        while (!valido) {
            try {
                System.out.print("Digite o tipo de financiamento (casa/apartamento/terreno): ");
                tipoFinanciamento = scanner.next();
                if (!tipoFinanciamento.equalsIgnoreCase("casa") &&
                        !tipoFinanciamento.equalsIgnoreCase("apartamento") &&
                        !tipoFinanciamento.equalsIgnoreCase("terreno")) {
                    throw new IllegalArgumentException("Erro: Tipo de financiamento inválido.");
                }
                valido = true;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return tipoFinanciamento;
    }

    public double solicitarValorImovel() {
        double valorImovel = 0;
        boolean valido = false;
        while (!valido) {
            try {
                System.out.print("Digite o valor do imóvel: ");
                valorImovel = scanner.nextDouble();
                if (valorImovel <= 0) {
                    throw new IllegalArgumentException("Erro: O valor do imóvel deve ser positivo.");
                }
                valido = true;
            } catch (InputMismatchException e) {
                System.out.println("Erro: Entrada inválida. Por favor, insira um número.");
                scanner.next();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return valorImovel;
    }

    public int solicitarPrazoFinanciamento() {
        int prazoFinanciamento = 0;
        boolean valido = false;
        while (!valido) {
            try {
                System.out.print("Digite o prazo do financiamento (em anos): ");
                prazoFinanciamento = scanner.nextInt();
                if (prazoFinanciamento <= 0 || prazoFinanciamento > 30) {
                    throw new IllegalArgumentException("Erro: O prazo do financiamento deve ser positivo e não mais que 30 anos.");
                }
                valido = true;
            } catch (InputMismatchException e) {
                System.out.println("Erro: Entrada inválida. Por favor, insira um número.");
                scanner.next();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return prazoFinanciamento;
    }

    public double solicitarTaxaJurosAnual() {
        double taxaJurosAnual = 0;
        boolean valido = false;
        while (!valido) {
            try {
                System.out.print("Digite a taxa de juros anual (%): ");
                taxaJurosAnual = scanner.nextDouble();
                if (taxaJurosAnual <= 0 || taxaJurosAnual > 100) {
                    throw new IllegalArgumentException("Erro: A taxa de juros deve ser positiva e razoável.");
                }
                valido = true;
            } catch (InputMismatchException e) {
                System.out.println("Erro: Entrada inválida. Por favor, insira um número.");
                scanner.next();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return taxaJurosAnual;
    }

    public int solicitarQuantidadeFinanciamentos() {
        int qtdFinanciamentos = 0;
        boolean valido = false;
        while (!valido) {
            try {
                System.out.print("Quantos financiamentos deseja realizar? ");
                qtdFinanciamentos = scanner.nextInt();
                if (qtdFinanciamentos <= 0) {
                    throw new IllegalArgumentException("Erro: O valor deve ser positivo e maior que zero.");
                }
                valido = true;
            } catch (InputMismatchException e) {
                System.out.println("Erro: Entrada inválida. Por favor, insira um número.");
                scanner.next();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return qtdFinanciamentos;
    }

    public double solicitarTamanhoAreaConstruida() {
        double tamanhoAreaConstruida = 0;
        boolean valido = false;
        while (!valido) {
            try {
                System.out.print("Digite o tamanho da área construída (em m²): ");
                tamanhoAreaConstruida = scanner.nextDouble();
                if (tamanhoAreaConstruida <= 0) {
                    throw new IllegalArgumentException("Erro: O tamanho da área construída deve ser positivo.");
                }
                valido = true;
            } catch (InputMismatchException e) {
                System.out.println("Erro: Entrada inválida. Por favor, insira um número.");
                scanner.next();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return tamanhoAreaConstruida;
    }

    public double solicitarTamanhoTerreno() {
        double tamanhoTerreno = 0;
        boolean valido = false;
        while (!valido) {
            try {
                System.out.print("Digite o tamanho do terreno (em m²): ");
                tamanhoTerreno = scanner.nextDouble();
                if (tamanhoTerreno <= 0) {
                    throw new IllegalArgumentException("Erro: O tamanho do terreno deve ser positivo.");
                }
                valido = true;
            } catch (InputMismatchException e) {
                System.out.println("Erro: Entrada inválida. Por favor, insira um número.");
                scanner.next();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return tamanhoTerreno;
    }

    public int solicitarNumeroVagasGaragem() {
        int numeroVagasGaragem = 0;
        boolean valido = false;
        while (!valido) {
            try {
                System.out.print("Digite o número de vagas na garagem: ");
                numeroVagasGaragem = scanner.nextInt();
                if (numeroVagasGaragem < 0) {
                    throw new IllegalArgumentException("Erro: O número de vagas na garagem não pode ser negativo.");
                }
                valido = true;
            } catch (InputMismatchException e) {
                System.out.println("Erro: Entrada inválida. Por favor, insira um número.");
                scanner.next();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return numeroVagasGaragem;
    }

    public int solicitarNumeroAndar() {
        int numeroAndar = 0;
        boolean valido = false;
        while (!valido) {
            try {
                System.out.print("Digite o número do andar: ");
                numeroAndar = scanner.nextInt();
                if (numeroAndar < 0) {
                    throw new IllegalArgumentException("Erro: O número do andar não pode ser negativo.");
                }
                valido = true;
            } catch (InputMismatchException e) {
                System.out.println("Erro: Entrada inválida. Por favor, insira um número.");
                scanner.next();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return numeroAndar;
    }

    public String solicitarTipoZona() {
        String tipoZona = "";
        boolean valido = false;
        while (!valido) {
            try {
                System.out.print("Digite o tipo de zona (residencial/comercial): ");
                tipoZona = scanner.next();
                if (!tipoZona.equalsIgnoreCase("residencial") && !tipoZona.equalsIgnoreCase("comercial")) {
                    throw new IllegalArgumentException("Erro: Tipo de zona inválido.");
                }
                valido = true;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return tipoZona;
    }
}
