package A3;

import java.util.ArrayList;
import java.util.List;

public class Loja {
	private ArrayList<Produto> produtos;

	public Loja() {
		this.produtos = new ArrayList<>();
	}

	public void incluirProduto(Produto produto) {

		produtos.add(produto);
		System.out.println("Produto incluído com sucesso!");
		System.out.println("ID atriubido= " + produto.getID());
	}

	public void alterarProduto(String nome, Produto novoProduto) {
		for (int i = 0; i < produtos.size(); i++) {
			Produto produto = produtos.get(i);              
			if (produto.getNome().equals(nome)) {    // Pecorrendo a lista para encontrar um
				                                    //produto com nome igual ao solicitado e ap�s encontrar                           
				produtos.set(i, novoProduto);      // o progama faz a altera��o, se n�o informa como produto n�o encontrado.

				System.out.println("Produto alterado com sucesso!");
				return;
			}
		}
		System.out.println("Produto não encontrado!");
	}

	public Produto consultarProduto(int id) {
		for (Produto produto : produtos) {
			if (produto.getID() == id) {        // Pecorre a lista para encontrar um produto com o mesmo ID do paramentro.
				return produto;
			}
		}
		return null;
	}


		public List <Produto> consultarProduto(String nomeConsultar) {
	        List <Produto> produtosEncontrados = new ArrayList<>();
	        for (Produto produto : produtos) {
	            if (produto.getNome().equalsIgnoreCase(nomeConsultar)) {
	                produtosEncontrados.add(produto);
	            }
	        }
	        return produtosEncontrados;
	    }

	public void excluirProduto(int id) {
		for (int i = 0; i < produtos.size(); i++) {
			Produto produto = produtos.get(i); // Comando para pegar o index da ArrayList.
			if (produto.getID() == id) {
				produtos.remove(i);     // Comando para remover index do ArrayList.
				System.out.println("Produto excluído com sucesso!");
				return;
			}
		}
		System.out.println("Produto não encontrado!");
	}

	public void listarProdutos() {
		if (produtos.isEmpty()) { // Comando para verificar se o ArrayList esta vazio.
			System.out.println("Não há produtos cadastrados!");
		} else {
			for (Produto produto : produtos) {
				System.out.println(produto);
			}
		}
	}
}