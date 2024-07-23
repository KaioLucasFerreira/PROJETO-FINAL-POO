import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<Produto> produtos = new ArrayList<>();

        System.out.print("Digite a quantidade de produtos: ");
        int n = sc.nextInt();

        for (int i = 1; i <= n; i++) {
            System.out.println("Produto #" + i);
            System.out.print("Comum, usado ou importado (c/u/i)? ");
            char tipo = sc.next().charAt(0);

            System.out.print("Nome: ");
            sc.nextLine();
            String nome = sc.nextLine();

            System.out.print("Preço: ");
            double preco = sc.nextDouble();

            if (tipo == 'c') {
                produtos.add(new Produto(nome, preco));
            } else if (tipo == 'u') {
                System.out.print("Data de fabricação (DD/MM/YYYY): ");
                sc.nextLine();
                String dataFabricacao = sc.nextLine();
                produtos.add(new ProdutoUsado(nome, preco, dataFabricacao));
            } else if (tipo == 'i') {
                System.out.print("Taxa de alfândega: ");
                double taxaAlfandega = sc.nextDouble();
                produtos.add(new ProdutoImportado(nome, preco, taxaAlfandega));
            }
        }

        System.out.println("\nEtiquetas de preço:");
        for (Produto produto : produtos) {
            System.out.println(produto.etiquetaPreco());
        }

        sc.close();
    }
}

class Produto {
    private String nome;
    private double preco;

    public Produto(String nome, double preco) {
        this.nome = nome;
        this.preco = preco;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public String etiquetaPreco() {
        return nome + " R$" + String.format("%.2f", preco);
    }
}

class ProdutoUsado extends Produto {
    private String dataFabricacao;

    public ProdutoUsado(String nome, double preco, String dataFabricacao) {
        super(nome, preco);
        this.dataFabricacao = dataFabricacao;
    }

    public String getDataFabricacao() {
        return dataFabricacao;
    }

    public void setDataFabricacao(String dataFabricacao) {
        this.dataFabricacao = dataFabricacao;
    }

    @Override
    public String etiquetaPreco() {
        return getNome() + " (usado) R$" + String.format("%.2f", getPreco()) + " (Data de fabricação: " + dataFabricacao + ")";
    }
}

class ProdutoImportado extends Produto {
    private double taxaAlfandega;

    public ProdutoImportado(String nome, double preco, double taxaAlfandega) {
        super(nome, preco);
        this.taxaAlfandega = taxaAlfandega;
    }

    public double getTaxaAlfandega() {
        return taxaAlfandega;
    }

    public void setTaxaAlfandega(double taxaAlfandega) {
        this.taxaAlfandega = taxaAlfandega;
    }

    @Override
    public String etiquetaPreco() {
        return getNome() + " (importado) R$" + String.format("%.2f", getPreco() + taxaAlfandega) + " (Taxa de alfândega: " + taxaAlfandega + ")";
    }
}