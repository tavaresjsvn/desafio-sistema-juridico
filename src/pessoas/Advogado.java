package pessoas;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Advogado extends Pessoa {

	private String oab;

	public Advogado(String nome, String cpf, String telefone, String email, String oab) {
		super(nome, cpf, telefone, email);
		
		this.setOab(oab);
	}

	@Override
	public String getTipo() {
		return "Advogado";
	}

	public String getOab() {
		return oab;
	}

	public void setOab(String oab) {
		 String regex = "^OAB/[A-Z]{2}-\\d{5}$";
	     Pattern pattern = Pattern.compile(regex);
	     Matcher matcher = pattern.matcher(oab);
	     
	     if(!matcher.matches()) {
	    	 this.oab = "";
	    	 throw new IllegalArgumentException("OAB inválida! Campo ficou vázio. Preencha imediatamente com um documento válido ou isso impedirá sua participação em qualquer processo.");
	     }
 
		this.oab = oab;
	}
	
}
