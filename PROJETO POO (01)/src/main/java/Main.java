import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Funcionario {
    String nome;
    int horasTrabalhadas;
    double valorHora;
    double despesaAdicional;

    public Funcionario(String nome, int horasTrabalhadas, double valorHora, double despesaAdicional) {
        this.nome = nome;
        this.horasTrabalhadas = horasTrabalhadas;
        this.valorHora = valorHora;
        this.despesaAdicional = despesaAdicional;
    }

    public double calcularPagamento() {
        if (despesaAdicional == 0) {
            return horasTrabalhadas * valorHora;
        } else {
            return horasTrabalhadas * valorHora + (despesaAdicional * 1.1);
        }
    }

    public String toString() {
        return "Nome: " + nome + " - Pagamento: R$" + calcularPagamento();
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Digite o número de funcionários: ");
        int n = input.nextInt();

        List<Funcionario> funcionarios = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            System.out.print("Digite o nome do funcionário: ");
            String nome = input.next();
            System.out.print("Digite as horas trabalhadas: ");
            int horasTrabalhadas = input.nextInt();
            System.out.print("Digite o valor por hora: ");
            double valorHora = input.nextDouble();
            System.out.print("Digite a despesa adicional (0 caso não seja terceirizado): ");
            double despesaAdicional = input.nextDouble();

            Funcionario funcionario = new Funcionario(nome, horasTrabalhadas, valorHora, despesaAdicional);
            funcionarios.add(funcionario);
        }

        System.out.println("\nPagamento dos funcionários:");
        for (Funcionario f : funcionarios) {
            System.out.println(f);
        }
    }
}