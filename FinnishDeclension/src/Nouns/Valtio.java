package Nouns;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Valtio {
	public HashMap<String, String> generateForms(String INVSTEM, String HARVOW){
		HashMap<String, String> forms = new HashMap();
		String ENDVOW=String.valueOf(INVSTEM.charAt(INVSTEM.length() - 1));
		//---------------------SG Forms---------------------------
		forms.put("NOM SG", INVSTEM);
		forms.put("GEN SG", INVSTEM+"n");
		forms.put("AKK SG", INVSTEM+"n");
		forms.put("AKK2 SG", forms.get("NOM SG"));
		forms.put("PAR SG", INVSTEM+"t"+HARVOW);
		forms.put("INE SG", INVSTEM+"ss"+HARVOW);
		forms.put("ILL SG", INVSTEM+ENDVOW+"n");
		forms.put("ELA SG", INVSTEM+"st"+HARVOW);
		forms.put("ADE SG", INVSTEM+"ll"+HARVOW);
		forms.put("ALL SG", INVSTEM+"lle");
		forms.put("ABL SG", INVSTEM+"lt"+HARVOW);
		forms.put("ESS SG", INVSTEM+"n"+HARVOW);
		forms.put("TRA SG", INVSTEM+"ksi");
		forms.put("ABE SG", INVSTEM+"tt"+HARVOW);
		
		//----------------------PL Forms--------------------------
		forms.put("NOM PL", INVSTEM+"t");
		forms.put("GEN PL", INVSTEM+"iden" + "|" + INVSTEM+ "itten");
		forms.put("AKK PL", forms.get("NOM PL"));
		forms.put("AKK2 PL",forms.get("NOM PL"));
		forms.put("PAR PL", INVSTEM+"it"+HARVOW);
		forms.put("INE PL", INVSTEM+"iss"+HARVOW);
		forms.put("ILL PL", INVSTEM+"ihin");
		forms.put("ELA PL", INVSTEM+"ist"+HARVOW);
		forms.put("ADE PL", INVSTEM+"ill"+HARVOW);
		forms.put("ALL PL", INVSTEM+"ille");
		forms.put("ABL PL", INVSTEM+"ilt"+HARVOW);
		forms.put("ESS PL", INVSTEM+"in"+HARVOW);
		forms.put("TRA PL", INVSTEM+"iksi");
		forms.put("INS PL", INVSTEM+"in");
		forms.put("ABE PL", INVSTEM+"itt"+HARVOW);
		forms.put("COM PL", INVSTEM+"ineen");
		
		return forms;
		
		
	}
	public List<HashMap<String, String>> generatePossesiveForms(HashMap<String, String>basicforms, String INVSTEM, String STRONG, String HARVOW ){
		String x = "";
		List<HashMap<String, String>> possesiveforms = new ArrayList();
		possesiveforms.add(Possesiva.generateForms(basicforms, "ni", "1.SG", INVSTEM, STRONG, x, HARVOW));
		possesiveforms.add(Possesiva.generateForms(basicforms, "si", "2.SG", INVSTEM, STRONG, x, HARVOW));
		possesiveforms.add(Possesiva.generateForms(basicforms, "mme", "1.PL", INVSTEM, STRONG, x, HARVOW));
		possesiveforms.add(Possesiva.generateForms(basicforms, "nne", "2.PL", INVSTEM, STRONG, x, HARVOW));
		possesiveforms.add(Possesiva.generateForms(basicforms, "", "3.SG", INVSTEM, STRONG, x, HARVOW));
		possesiveforms.add(Possesiva.generateForms(basicforms, "", "3.PL", INVSTEM, STRONG, x, HARVOW));
		return possesiveforms;
	}
	public static void main(String[] args) {
		//decl(valtio, kahvio, a)
		//kahvio
		//decl(valtio, aaloe, a)
		Valtio v = new Valtio();
		HashMap<String, String> forms = v.generateForms("aaloe", "a");
		for (String key: forms.keySet()) {
			System.out.println(key + " :");
			System.out.println(forms.get(key));
		}
		

	}

}
