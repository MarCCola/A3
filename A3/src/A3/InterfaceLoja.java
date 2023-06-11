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
				 System.out.print("Digite o ID do produto a ser alterado: ");
				    int idAlterar = scanner.nextInt();
				    scanner.nextLine();

				    Produto produtoExistente = loja.consultarProduto(idAlterar);
				    if (produtoExistente != null) {
				        System.out.println("Produto encontrado:");
				        System.out.println(produtoExistente);

				        boolean sair = false;
				        while (!sair) {
				            System.out.println("\nOpções de alteração:");
				            System.out.println("1 - Alterar nome");
				            System.out.println("2 - Alterar marca");
				            System.out.println("3 - Alterar preço");
				            System.out.println("4 - Alterar quantidade");
				            System.out.println("5 - Alterar categoria");
				            System.out.println("0 - Sair");
				            System.out.print("Escolha uma opção: ");
				            int opcaoAlteracao = scanner.nextInt();
				            scanner.nextLine();

				            switch (opcaoAlteracao) {
				                case 0:
				                    sair = true;
				                    break;
				                case 1:
				                    System.out.print("Digite o novo nome do produto: ");
				                    String novoNome = scanner.nextLine();
				                    produtoExistente.setNome(novoNome);
				                    break;
				                case 2:
				                    System.out.print("Digite a nova marca do produto: ");
				                    String novaMarca = scanner.nextLine();
				                    produtoExistente.setMarca(novaMarca);
				                    break;
				                case 3:
				                    System.out.print("Digite o novo preço do produto: ");
				                    double novoPreco = scanner.nextDouble();
				                    produtoExistente.setPreco(novoPreco);
				                    break;
				                case 4:
				                    System.out.print("Digite a nova quantidade do produto: ");
				                    int novaQuantidade = scanner.nextInt();
				                    produtoExistente.setQuantidade(novaQuantidade);
				                    break;
				                case 5:
				                    System.out.print("Digite a nova categoria do produto: ");
				                    String novaCategoria = scanner.nextLine();
				                    produtoExistente.setCategoria(novaCategoria);
				                    break;
				                default:
				                    System.out.println("Opção inválida para a alteração!");
				                    break;
				            }

				            if (!sair) {
				                System.out.println("Produto alterado com sucesso:");
				                System.out.println(produtoExistente);
				            }
				        }
				    } else {
				        System.out.println("Produto não encontrado!");
				    }
				    break;
			case 3:
			    boolean sairConsulta = false;
			    while (!sairConsulta) {
			        System.out.println("1 - Consultar por nome");
			        System.out.println("2 - Consultar por ID");
			        System.out.println("0 - Sair");
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
			                    for (Produto Produto : produtosEncontrados) {
			                        System.out.println(Produto);
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
			            case 0:
			                sairConsulta = true;
			                break;
			            default:
			                System.out.println("Opção inválida para a consulta!");
			                break;
			        }
			    }
			    break;
			case 4:  // Opção excluir produto.
				 System.out.print("Digite o ID do produto a ser excluído: ");
				    int IDExcluir = scanner.nextInt();
				    scanner.nextLine();

				    Produto produtoExcluir = loja.consultarProduto(IDExcluir);
				    if (produtoExcluir != null) {
				        System.out.println("Produto encontrado:");
				        System.out.println(produtoExcluir);

				        System.out.print("Deseja confirmar a exclusão do produto? (Sim/Não): ");
				        String confirmacao = scanner.nextLine();

				        if (confirmacao.equalsIgnoreCase("Sim")) {
				            loja.excluirProduto(IDExcluir);
				            System.out.println("Produto excluído com sucesso!");
				        } else {
				            System.out.println("Exclusão cancelada.");
				        }
				    } else {
				        System.out.println("Produto não encontrado!");
				    }
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
