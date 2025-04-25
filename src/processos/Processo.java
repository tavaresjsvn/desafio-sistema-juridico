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
		this.cliente = cliente;
		this.advogadoResponsavel = advogadoResponsavel;
		this.descricao = descricao;
		this.prazo = prazo;
		this.status = status;
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
		String statusPrazo = this.prazoVencido() ? "Sim" : "Não";
		
		return  "Resumo do Processo: \n" +
	            "------------------------------\n" +
			    "Número do processo: " + this.numeroProcesso + "\n" +
				"Cliente: " + this.cliente.getNome() + "\n" +
				"Advogado: " + this.advogadoResponsavel.getNome() + "\n" +
				"Descrição do Caso: " + this.descricao + "\n" +
				"Prazo vencido: " + statusPrazo + ", " + this.diasParaVencimento() + "(Data do Prazo: " + this.prazo + ")" + "\n" +
				"Status: " + this.getStatus() + "\n";
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
