package pessoas;

public class Cliente extends Pessoa {
	
	private String profissao;

	public Cliente(String nome, String cpf, String telefone, String email, String profissao) {
		super(nome, cpf, telefone, email);
		
		if (profissao == null || profissao.isBlank()) {
			throw new IllegalArgumentException("Campo de profissão está vazio e é obrigatório.");
		}
		
		this.profissao = profissao;
	}

	public String getProfissao() {
		return profissao;
	}

	public void setProfissao(String profissao) {
		this.profissao = profissao;
	}

	@Override
	public String getTipo() {
		return "Cliente";
	}

}
