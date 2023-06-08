package A3;

import java.util.List;
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
			System.out.print("Escolha uma opÃ§Ã£o: ");
			opcao = scanner.nextInt();
			scanner.nextLine();

			switch (opcao) {
			case 1:     //  Opção incluir produto.
				System.out.print("Digite o nome do produto: ");
				String nome = scanner.nextLine(); 
				System.out.print("Digite a marca do produto: ");
				String marca = scanner.nextLine();
				System.out.print("Digite o preÃ§o do produto: ");
				double preco = scanner.nextDouble();
				System.out.print("Digite a quantidade do produto: ");
				int quantidade = scanner.nextInt();
				scanner.nextLine(); 
				System.out.print("Digite a categoria do produto: ");
				String categoria = scanner.nextLine();
				Produto produto = new Produto(nome, marca, preco, quantidade, categoria);
				loja.incluirProduto(produto); // Usando o metodo para incluir o produto com todas as informações a cima.
				break;
				
			case 2:    // Opção alterar produto.
				System.out.print("Digite o nome do produto a ser alterado: ");
				String nomeAlterar = scanner.nextLine();
				Produto novoProduto = new Produto("", "", 0, 0, "");
				System.out.print("Digite o novo nome do produto: ");
				novoProduto.setNome(scanner.nextLine()); // metodo alterando nome.
				System.out.print("Digite a nova marca do produto: ");
				novoProduto.setMarca(scanner.nextLine());// metodo alterando marca.
				System.out.print("Digite o novo preÃ§o do produto: ");
				novoProduto.setPreco(scanner.nextDouble());// metodo alterando preco.
				System.out.print("Digite a nova quantidade do produto: ");
				novoProduto.setQuantidade(scanner.nextInt());// metodo alterando quantidade.
				scanner.nextLine(); 
				System.out.print("Digite a nova categoria do produto: ");
				novoProduto.setCategoria(scanner.nextLine());  // metodo alterando categoria.
				loja.alterarProduto(nomeAlterar, novoProduto);// metodo de produto na loja.
				break;
			case 3:
                System.out.println("1 - Consultar por nome");
                System.out.println("2 - Consultar por ID");
                System.out.print("Escolha uma opção: ");
                int opcaoConsulta = scanner.nextInt();
                scanner.nextLine();

                switch (opcaoConsulta) {
                case 1:
                    System.out.print("Digite o nome do produto a ser consultado: ");
                    String nomeConsultar = scanner.nextLine();
                    List<Produto> produtosEncontrados = loja.consultarProduto(nomeConsultar);
                    if (!produtosEncontrados.isEmpty()) {
                        System.out.println("Produtos encontrados:");
                        for (Produto produto1 : produtosEncontrados) {
                            System.out.println(produto1);
                        }
                    } else {
                        System.out.println("Nenhum produto encontrado com o nome informado!");
                    }
                    break;
                    case 2:
                        System.out.print("Digite o ID do produto a ser consultado: ");
                        int idConsultar = scanner.nextInt();
                        scanner.nextLine();
                        Produto produtoConsultadoPorId = loja.consultarProduto(idConsultar);
                        if (produtoConsultadoPorId != null) {
                            System.out.println(produtoConsultadoPorId);
                        } else {
                            System.out.println("Produto não encontrado!");
                        }
                        break;
                    default:
                        System.out.println("Opção inválida para a consulta!");
                        break;
                       }
                break;
                
			case 4:  // Opção excluir produto.
				System.out.print("Digite o ID do produto a ser excluÃ­do: ");
				int IDExcluir = scanner.nextInt();
				loja.excluirProduto(IDExcluir);
				break;
			case 5: // Opção listar produto.
				loja.listarProdutos();
				break;
			case 6: // Opção finalizar o progamda.
				System.out.println("Encerrando o programa...");
				break;
			default:
				System.out.println("OpÃ§Ã£o invÃ¡lida!");
			}

			System.out.println();
		} while (opcao != 6); // modo para continuar o laço de repetição.

		scanner.close();
	}
}
