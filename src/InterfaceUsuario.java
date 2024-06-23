import java.util.Scanner;

public class InterfaceUsuario {
    private Scanner scanner;

    // Método Construtor
    public  InterfaceUsuario(){
        scanner = new Scanner(System.in);
    }

    // Método para Solicitar o Valor do Imóvel
    public double solicitarValorImovel(){
        System.out.print("Digite o valor do imóvel: ");
        return scanner.nextDouble();
    }
    // Método para Soliciar o Prazo do Financiamento
    public int solicitarPrazoFinanciamento(){
        System.out.print("Digite o prazo do financiamento (em anos): ");
        return scanner.nextInt();
    }
    // Método para Solicitar a Taza de Juros Anual
    public double solicitarTaxaJurosAnual(){
        System.out.print("Digite a taxa de juros anual (%): ");
        return scanner.nextDouble();
    }
}
