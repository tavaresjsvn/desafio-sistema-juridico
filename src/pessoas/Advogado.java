package pessoas;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Advogado extends Pessoa {

	private String oab;
	private static ArrayList<String> listadeOabs = new ArrayList<>();

	public Advogado(String nome, String cpf, String telefone, String email, String oab) {
		super(nome, cpf, telefone, email);
		
		try {
			this.setOab(oab);
		} catch (Exception e) {
			System.out.println("Erro: " + e);
		}
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
	     
	    for(int i = 0; i < listadeOabs.size(); i++) {
			if (cpf.equals(listadeOabs.get(i))) {
				this.oab = "";
				throw new IllegalArgumentException("OAB já cadastrada! Campo ficou vázio. Preencha imediatamente com um documento válido ou isso impedirá sua participação em qualquer processo.");
			}
		}
			
	    listadeOabs.add(oab); 
		this.oab = oab;
	}
	
}
