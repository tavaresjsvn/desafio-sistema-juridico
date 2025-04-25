package processos;

public enum Status {

	EM_ANDAMENTO("Em Andamento"),
	ARQUIVADO("Arquivado"),
	ENCERRADO("Encerrado");

	private final String nome;
	
	private Status(String nome) {
		this.nome = nome;
	}
	
	public String getNome() {
		return nome;
	}
	
	@Override
    public String toString() {
        return nome;
    }
}
