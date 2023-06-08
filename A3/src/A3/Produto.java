package A3;
import java.util.Random;

public class Produto {
        private Random R =  new Random();
		private String nome;
		private String marca;
		private double preco;
		private int quantidade;
		private String categoria;
		private int ID;

		public Produto(String nome, String marca, double preco, int quantidade, String categoria) {
			this.nome = nome;
			this.marca = marca;
			this.preco = preco;
			this.quantidade = quantidade;
			this.categoria = categoria;
			this.ID = R.nextInt(9999);
		}

		public int getID() {
			return ID;
		}

		public void setID(int iD) {
			ID = iD;
		}

		public String getNome() {
			return nome;
		}

		public void setNome(String nome) {
			this.nome = nome;
		}

		public String getMarca() {
			return marca;
		}

		public void setMarca(String marca) {
			this.marca = marca;
		}

		public double getPreco() {
			return preco;
		}

		public void setPreco(double preco) {
			this.preco = preco;
		}

		public int getQuantidade() {
			return quantidade;
		}

		public void setQuantidade(int quantidade) {
			this.quantidade = quantidade;
		}

		public String getCategoria() {
			return categoria;
		}

		public void setCategoria(String categoria) {
			this.categoria = categoria;
		}

		public String toString() {
			return "Produto [nome=" + nome + ", marca=" + marca + ", preco=" + preco + ", quantidade=" + quantidade
					+ ", categoria=" + categoria + ", ID=" + ID +" ] ";
		}
	}