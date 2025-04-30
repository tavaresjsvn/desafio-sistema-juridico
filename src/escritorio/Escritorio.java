package escritorio;

import java.util.ArrayList;
import java.util.HashMap;
import pessoas.Advogado;
import pessoas.Cliente;
import processos.Processo;
import processos.Status;


public class Escritorio {

	private ArrayList<Processo> processos = new ArrayList<>();
	private HashMap<String, Cliente> clientes = new HashMap<>();
	private HashMap<String, Advogado> advogados = new HashMap<>();
	
	public void adicionarCliente(Cliente novoCliente) {
		
		if (clientes.containsKey(novoCliente.getCpf())) {
			throw new IllegalArgumentException("Cliente já cadastrado!");
		}
		
		if (advogados.containsKey(novoCliente.getCpf())) {
			throw new IllegalArgumentException("Esse número de cpf consta como cadastrado para um advogado do escritório. Advogados não podem ser clientes do escritório!");
		}
		
		if (novoCliente.getCpf().isBlank() || novoCliente.getNome().isBlank() || 
		    novoCliente.getEmail().isBlank() || novoCliente.getTelefone().isBlank()) {
			
		   throw new IllegalArgumentException("Algum dos campos essenciais como Nome, Telefone, E-mail ou CPF estão vázios e é necessário o preenchimento antes de participar de um processo!");
		}
		
		clientes.put(novoCliente.getCpf(), novoCliente);
		
	}
	
	public void adicionarAdvogado(Advogado novoAdvogado) {
	
		
		if (advogados.containsKey(novoAdvogado.getCpf())) {
				throw new IllegalArgumentException("Advogado já cadastrado!");
		}
	
		for (Advogado advogado : advogados.values()) {
		    if (advogado.getOab().equals(novoAdvogado.getOab())) {
		        throw new IllegalArgumentException("Essa OAB já está cadastrada no sistema!");
		    }
		}
			
	    if (clientes.containsKey(novoAdvogado.getCpf())) {
				throw new IllegalArgumentException("Esse número de cpf consta como cadastrado para um cliente do escritório. Clientes não podem ser Advogados do escritório!");
		}
		
	    if (novoAdvogado.getCpf().isBlank() || novoAdvogado.getNome().isBlank() || novoAdvogado.getOab().isBlank() ||
			novoAdvogado.getEmail().isBlank() || novoAdvogado.getTelefone().isBlank()) {
				
			throw new IllegalArgumentException("Algum dos campos essenciais como Nome, Telefone, E-mail, Oab ou CPF estão vazios e é necessário o preenchimento antes de participar de um processo!");
		}
		
		advogados.put(novoAdvogado.getCpf(), novoAdvogado);
			
	}
	
	public void adicionarProcesso(Processo processo) {
		
		for (Processo p : processos) {
	        if (p.getNumeroProcesso().equals(processo.getNumeroProcesso())) {
	            throw new IllegalArgumentException("Processo já existe!");
	        }
	    }
		
		if (!clientes.containsKey(processo.getCliente().getCpf())) {
	        throw new IllegalArgumentException("Cliente não cadastrado no escritório!");
	    }
		
		if (!advogados.containsKey(processo.getAdvogadoResponsavel().getCpf())) {
	        throw new IllegalArgumentException("Advogado não cadastrado no escritório!");
	    }
		
		if (processo.prazoVencido() && processo.getStatus() == Status.EM_ANDAMENTO) {
	        processo.setStatus(Status.ARQUIVADO);
	    }
		processos.add(processo);
	}
	
	public ArrayList<Processo> listarProcessosPorStatus(Status status) {
		ArrayList<Processo> processosFiltrados = new ArrayList<>();
		
		for (Processo p : processos) {
	        if (p.getStatus() == status) {
	            processosFiltrados.add(p);
	        }
	    }
		
		return processosFiltrados;
	}
	
	
	public void notificarPrazosVencidos() {
		for (Processo p : processos) {
			if(p.getStatus() == Status.EM_ANDAMENTO && p.prazoVencido()) {
		            p.setStatus(Status.ARQUIVADO);
		            System.out.print("Notificação: Seu processo foi arquivado por estar vencido\n");
					System.out.print(p.resumoDoProcesso() + "\n");
		    
			}
		}
	}
	
	public Cliente getClientePorCpf(String cpf) {
	    return clientes.get(cpf);
	}

	public Advogado getAdvogadoPorCpf(String cpf) {
	    return advogados.get(cpf);
	}
}
