package processos;

import java.time.LocalDate;
import pessoas.Advogado;
import pessoas.Cliente;
import java.time.temporal.ChronoUnit;


public class Processo {

	private String numeroProcesso;
	private Cliente cliente;
	private Advogado advogadoResponsavel;
	private String descricao;
	private LocalDate prazo;
	private Status status;
	
	public Processo(String numeroProcesso, Cliente cliente, Advogado advogadoResponsavel, String descricao,
			LocalDate prazo, Status status) {

		this.numeroProcesso = numeroProcesso;
		
		if (numeroProcesso == null || numeroProcesso.isBlank()) {
			throw new IllegalArgumentException("Campo de número do processo está vazio e é obrigatório.");
		}
		
		this.cliente = cliente;
		this.advogadoResponsavel = advogadoResponsavel;
		this.descricao = descricao;
		this.prazo = prazo;
		this.setStatus(status);
	}
	
	public boolean prazoVencido() {
		LocalDate dataAtual = java.time.LocalDate.now(); 
		
		return dataAtual.isAfter(this.prazo);
	}
	
	public String diasParaVencimento() {
		LocalDate dataAtual = java.time.LocalDate.now();
		long diasEntre;

		if (dataAtual.isBefore(this.prazo)) {
		
		diasEntre = ChronoUnit.DAYS.between(dataAtual, this.prazo);
		return "Faltam " + diasEntre + " dias para o vencimento.";
		
		} else if (dataAtual.isEqual(this.prazo)) {

		return "O processo vence hoje!";
		}
		
		diasEntre = ChronoUnit.DAYS.between(this.prazo, dataAtual);
		return "O processo venceu há " + diasEntre + " dias.";
	}
	
	public String resumoDoProcesso() {
		
		return  "Processo: " + this.numeroProcesso + "\n" +
				"Cliente: " + this.cliente.getNome() + " (" + this.cliente.getProfissao() + ")" + "\n" +
				"Advogado: " + this.advogadoResponsavel.getNome() + " (" + this.advogadoResponsavel.getOab() + ")" + "\n" +
				"Status: " + this.getStatus() + "\n" +
				"Prazo: " + this.prazo  + " (" + this.diasParaVencimento() + ")" + "\n" +
				"Descrição do Caso: " + this.descricao + "\n";
				
	}

	public String getNumeroProcesso() {
		return numeroProcesso;
	}

	public void setNumeroProcesso(String numeroProcesso) {
		this.numeroProcesso = numeroProcesso;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Advogado getAdvogadoResponsavel() {
		return advogadoResponsavel;
	}

	public void setAdvogadoResponsavel(Advogado advogadoResponsavel) {
		this.advogadoResponsavel = advogadoResponsavel;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public LocalDate getPrazo() {
		return prazo;
	}

	public void setPrazo(LocalDate prazo) {
		this.prazo = prazo;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
	    this.status = status;
	}
}
