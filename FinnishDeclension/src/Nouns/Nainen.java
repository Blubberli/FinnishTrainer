package Nouns;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Nainen {
	
	public HashMap<String, String> generateForms(String INVSTEM, String HARVOW){
		HashMap<String, String> forms = new HashMap<String, String>();
		//---------------------SG Forms---------------------------
		forms.put("NOM SG", INVSTEM+"nen");
		forms.put("AKK SG", INVSTEM+"sen");
		forms.put("AKK2 SG", forms.get("NOM SG"));
		forms.put("GEN SG", INVSTEM+"sen");
		forms.put("PAR SG", INVSTEM+"st"+HARVOW);
		forms.put("INE SG", INVSTEM+"sess"+HARVOW);
		forms.put("ELA SG", INVSTEM+"sest"+HARVOW);
		forms.put("ILL SG", INVSTEM+"seen");
		forms.put("ADE SG", INVSTEM+"sell"+HARVOW);
		forms.put("ALL SG", INVSTEM+"selle");
		forms.put("ABL SG", INVSTEM+"selt"+HARVOW);
		forms.put("ESS SG", INVSTEM+"sen"+HARVOW);
		forms.put("TRA SG", INVSTEM+"seksi");
		forms.put("ABE SG", INVSTEM+"sett"+HARVOW);
		
		//----------------------PL Forms--------------------------
		forms.put("NOM PL", INVSTEM+"set");
		forms.put("AKK PL", forms.get("NOM PL"));
		forms.put("AKK2 PL",forms.get("NOM PL"));
		forms.put("GEN PL", INVSTEM+"sten" + "|" +INVSTEM+"sien");
		forms.put("PAR PL", INVSTEM+"si"+HARVOW);
		forms.put("INE PL", INVSTEM+"siss"+HARVOW);
		forms.put("ELA PL", INVSTEM+"sist"+HARVOW);
		forms.put("ILL PL", INVSTEM+"siin");
		forms.put("ADE PL", INVSTEM+"sill"+HARVOW);
		forms.put("ALL PL", INVSTEM+"sille");
		forms.put("ABL PL", INVSTEM+"silt"+HARVOW);
		forms.put("ESS PL", INVSTEM+"sin"+HARVOW);
		forms.put("TRA PL", INVSTEM+"siksi");
		forms.put("INS PL", INVSTEM+"sin");
		forms.put("ABE PL", INVSTEM+"sitt"+HARVOW);
		forms.put("COM PL", INVSTEM+"sineen");

		
		return forms;
		
		
	}
	
	public List<HashMap<String, String>> generatePossesiveForms(HashMap<String, String>basicforms, String INVSTEM, String STRONG, String HARVOW ){
		String x = "se";
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
		//decl(nainen, todelli, a)
		//todellinen
		//nainen: decl(nainen, nai, a)
		//decl(nainen, ihmi, ä) (ihiminen
		Nainen n = new Nainen();
		HashMap<String, String> forms = n.generateForms("ihmi", "ä");
		for (String key: forms.keySet()) {
			System.out.println(key + " :");
			System.out.println(forms.get(key));
		}

	}

}
