import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        System.out.print("Número do contrato: ");
        int numeroContrato = sc.nextInt();

        System.out.print("Data do contrato (dd/MM/yyyy): ");
        Date dataContrato = null;
        try {
            dataContrato = sdf.parse(sc.next());
        } catch (Exception e) {
            System.out.println("Data inválida. Por favor, insira a data no formato dd/MM/yyyy.");
            return;
        }

        System.out.print("Valor total do contrato: ");
        double valorTotal = sc.nextDouble();

        System.out.print("Número de meses para parcelamento: ");
        int numMeses = sc.nextInt();

        double juros = 0.01;
        double taxaPagamento = 0.02;

        Date dataParcela = new Date(dataContrato.getTime());
        double valorParcela = valorTotal / numMeses;

        System.out.println("Parcelas a serem pagas:");
        for (int i = 1; i <= numMeses; i++) {
            System.out.println("Parcela " + i + ": Data - " + sdf.format(dataParcela) + ", Valor - R$ " + String.format("%.2f", valorParcela));

            dataParcela.setMonth(dataParcela.getMonth() + 1);

            double jurosParcela = valorParcela * juros;
            double totalParcela = valorParcela + jurosParcela;
            double taxaParcela = totalParcela * taxaPagamento;
            valorParcela = totalParcela + taxaParcela;
        }

        sc.close();
    }
}