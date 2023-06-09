package A3;

import java.util.Scanner;

public class InterfaceLoja {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Loja loja = new Loja();

		int opcao = 0;
		do {
			System.out.println("===== Loja =====");
			System.out.println("1 - Incluir produto");
			System.out.println("2 - Alterar produto");
			System.out.println("3 - Consultar produto");
			System.out.println("4 - Excluir produto");
			System.out.println("5 - Listar produtos");
			System.out.println("6 - Sair");
			System.out.print("Escolha uma opção: ");
			opcao = scanner.nextInt();
			scanner.nextLine();

			switch (opcao) {
			case 1:
				System.out.print("Digite o nome do produto: ");
				String nome = scanner.nextLine();
				System.out.print("Digite a marca do produto: ");
				String marca = scanner.nextLine();
				System.out.print("Digite o preço do produto: ");
				double preco = scanner.nextDouble();
				System.out.print("Digite a quantidade do produto: ");
				int quantidade = scanner.nextInt();
				scanner.nextLine(); 
				System.out.print("Digite a categoria do produto: ");
				String categoria = scanner.nextLine();
				Produto produto = new Produto(nome, marca, preco, quantidade, categoria);
				loja.incluirProduto(produto);
				break;
			case 2:
				System.out.print("Digite o nome do produto a ser alterado: ");
				String nomeAlterar = scanner.nextLine();
				Produto novoProduto = new Produto("", "", 0, 0, "");
				System.out.print("Digite o novo nome do produto: ");
				novoProduto.setNome(scanner.nextLine());
				System.out.print("Digite a nova marca do produto: ");
				novoProduto.setMarca(scanner.nextLine());
				System.out.print("Digite o novo preço do produto: ");
				novoProduto.setPreco(scanner.nextDouble());
				System.out.print("Digite a nova quantidade do produto: ");
				novoProduto.setQuantidade(scanner.nextInt());
				scanner.nextLine(); 
				System.out.print("Digite a nova categoria do produto: ");
				novoProduto.setCategoria(scanner.nextLine());
				loja.alterarProduto(nomeAlterar, novoProduto);
				break;
			case 3:
				System.out.print("Digite o nome do produto a ser consultado: ");
				String nomeConsultar = scanner.nextLine();
				Produto produtoConsultado = loja.consultarProduto(nomeConsultar);
				if (produtoConsultado != null) {
					System.out.println(produtoConsultado);
				} else {
					System.out.println("Produto não encontrado!");
				}
				break;
			case 4:
				System.out.print("Digite o nome do produto a ser excluído: ");
				String nomeExcluir = scanner.nextLine();
				loja.excluirProduto(nomeExcluir);
				break;
			case 5:
				loja.listarProdutos();
				break;
			case 6:
				System.out.println("Encerrando o programa...");
				break;
			default:
				System.out.println("Opção inválida!");
			}

			System.out.println();
		} while (opcao != 6);

		scanner.close();
	}
}
