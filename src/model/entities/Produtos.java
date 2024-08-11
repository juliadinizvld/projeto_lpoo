package model.entities;

public class Produtos {


	    private int id; 
	    private String nome;
	    private int quantidade;
	    private int valorUnitario; 
	    
	    
	    public Produtos (int id, String nome, int quantidade, int valorUnitario) {
	        this.id = id;
	        this.nome = nome;
	        this.quantidade = quantidade;
	        this.valorUnitario = valorUnitario ;
	    }


		public int getId() {
			return id;
		}


		public void setId(int id) {
			this.id = id ;
		}


		public String getNome() {
			return nome;
		}


		public void setNome(String nome) {
			this.nome = nome;
		}


		public int getQuantidade() {
			return quantidade;
		}


		public void setQuantidade(int quantidade) {
			this.quantidade =  quantidade;
		}


		public int getValorUnitario() {
			return valorUnitario;
		}


		public void setValorUnitario(int valorUnitario) {
			this.valorUnitario = valorUnitario ;
		}

	    
	}


