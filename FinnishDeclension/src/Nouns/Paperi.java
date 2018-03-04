package Nouns;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Paperi {
	
	public HashMap<String, String> generateForms(String INVSTEM, String HARVOW, boolean i0){
		HashMap<String, String> forms = new HashMap();
		String ENDVOW="i";
		//---------------------SG Forms---------------------------
		if (i0 == true) {
			forms.put("NOM SG", INVSTEM);
		}
		else {
			forms.put("NOM SG", INVSTEM+"i");
		}
		forms.put("AKK SG", INVSTEM+"in");
		forms.put("AKK2 SG", forms.get("NOM SG"));
		forms.put("GEN SG", INVSTEM+"in");
		forms.put("PAR SG", INVSTEM+"i"+HARVOW);
		forms.put("INE SG", INVSTEM+"iss"+HARVOW);
		forms.put("ILL SG", INVSTEM+"iin");
		forms.put("ELA SG", INVSTEM+"ist"+HARVOW);
		forms.put("ADE SG", INVSTEM+"ill"+HARVOW);
		forms.put("ALL SG", INVSTEM+"ille");
		forms.put("ABL SG", INVSTEM+"ilt"+HARVOW);
		forms.put("ESS SG", INVSTEM+"in"+HARVOW);
		forms.put("TRA SG", INVSTEM+"iksi");
		forms.put("ABE SG", INVSTEM+"itt"+HARVOW);
		
		//----------------------PL Forms--------------------------
		forms.put("NOM PL", INVSTEM+"it");
		forms.put("AKK PL", forms.get("NOM PL"));
		forms.put("AKK2 PL",forms.get("NOM PL"));
		forms.put("GEN PL", INVSTEM+"ien" + "|" + INVSTEM+"eiden"+"|"+INVSTEM+"eitten");
		forms.put("PAR PL", INVSTEM+"eit"+HARVOW);
		forms.put("INE PL", INVSTEM+"eiss"+HARVOW);
		forms.put("ILL PL", INVSTEM+"eihin");
		forms.put("ELA PL", INVSTEM+"eist"+HARVOW);
		forms.put("ADE PL", INVSTEM+"eill"+HARVOW);
		forms.put("ALL PL", INVSTEM+"eille");
		forms.put("ABL PL", INVSTEM+"eilt"+HARVOW);
		forms.put("ESS PL", INVSTEM+"ein"+HARVOW);
		forms.put("TRA PL", INVSTEM+"eiksi");
		forms.put("INS PL", INVSTEM+"ein");
		forms.put("ABE PL", INVSTEM+"eitt"+HARVOW);
		forms.put("COM PL", INVSTEM+"eineen");

		return forms;
				
	}
	
	public List<HashMap<String, String>> generatePossesiveForms(HashMap<String, String>basicforms, String INVSTEM, String STRONG, String HARVOW ){
		String x = "i";
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
	//decl(paperi, thomsoningasell, a)
	//thomsoningaselli
	//decl(paperi, Jeltsin, ä, i=0)
	//decl(paperi, paper, a)
	//decl(paperi, Eerin, ä, i=0)
	Paperi p = new Paperi();
	HashMap<String, String> forms = p.generateForms("Eerin", "ä", true);
	for (String key: forms.keySet()) {
		System.out.println(key + " :");
		System.out.println(forms.get(key));
	}


}
}
