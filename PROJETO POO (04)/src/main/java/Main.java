import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Informe o modelo do carro: ");
        String modelo = input.nextLine();

        System.out.println("Informe o valor por hora da locação: ");
        double valorHora = input.nextDouble();

        System.out.println("Informe o valor diário da locação: ");
        double valorDiario = input.nextDouble();

        System.out.println("Informe o instante inicial da locação (hora): ");
        int horaInicial = input.nextInt();

        System.out.println("Informe o instante final da locação (hora): ");
        int horaFinal = input.nextInt();

        int duracao = horaFinal - horaInicial;

        double valorLocacao;
        if (duracao <= 12) {
            valorLocacao = duracao * valorHora;
        } else {
            valorLocacao = valorDiario;
        }

        double imposto;
        if (valorLocacao <= 100.00) {
            imposto = valorLocacao * 0.20;
        } else {
            imposto = valorLocacao * 0.15;
        }

        double total = valorLocacao + imposto;

        System.out.println("\n--- Nota de Pagamento ---");
        System.out.println("Modelo do carro: " + modelo);
        System.out.println("Valor da locação: R$ " + String.format("%.2f", valorLocacao));
        System.out.println("Valor do imposto: R$ " + String.format("%.2f", imposto));
        System.out.println("Valor total do pagamento: R$ " + String.format("%.2f", total));

        input.close();
    }
}