package pessoas;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class Pessoa {

	protected String nome;
	protected String cpf;
	protected String telefone;
	protected String email;
	
	protected static ArrayList<String> listadeCpfs = new ArrayList<>();
	
	
	public Pessoa(String nome, String cpf, String telefone, String email) {
		
		this.nome = nome;

		try { 
			this.setCpf(cpf);
		} catch(Exception e) {
			System.out.println("Erro: " + e);
		}
		
		try {
			this.setTelefone(telefone);
		} catch (Exception e) {
			System.out.println("Erro: " + e);
		}
		
		try {
			this.setEmail(email);
		} catch (Exception e) {
			System.out.println("Erro: " + e);
		}
		
	}


	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		
		if (cpf.length() != 11 && !cpf.matches("\\d+")) {
			this.cpf = "";
			throw new IllegalArgumentException("CPF inválido! Campo ficou vázio. Preencha imediatamente com um documento válido ou isso impedirá sua participação em qualquer processo.");
		}
		
		for(int i = 0; i < listadeCpfs.size(); i++) {
			if (cpf.equals(listadeCpfs.get(i))) {
				this.cpf = "";
				throw new IllegalArgumentException("CPF já cadastrado! Campo ficou vázio. Preencha imediatamente com um documento válido ou isso impedirá sua participação em qualquer processo.");
			}
		}
		
		listadeCpfs.add(cpf);
		this.cpf = cpf;
	}
	
	public String getTelefone() {
		return telefone;
	}


	public void setTelefone(String telefone) {
		 String regex = "\\(\\d{2}\\) \\d{4}-\\d{4}";
	     Pattern pattern = Pattern.compile(regex);
	     Matcher matcher = pattern.matcher(telefone);
	     
	     if (!matcher.matches()) {
	    	 this.telefone = "";
	    	 throw new IllegalArgumentException("Telefone inválido! Campo ficou vázio. Preencha imediatamente com um telefone válido ou isso impedirá sua participação em qualquer processo.");
	     }
	     
		this.telefone = telefone;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		if (!email.contains("@") || !email.contains(".")) {
			this.email = "";
			throw new IllegalArgumentException("Email inválido! Campo ficou vázio. Preencha imediatamente com um email válido ou isso impedirá sua participação em qualquer processo.");
		}
		
		this.email = email;
	}


	public abstract String getTipo();
	
	
}
