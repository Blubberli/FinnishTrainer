package Nouns;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Kalleus {
	public HashMap<String, String> generateForms(String INVSTEM, String HARVOW){
		HashMap<String, String> forms = new HashMap();
		//---------------------SG Forms---------------------------
		forms.put("NOM SG", INVSTEM + "s");
		forms.put("AKK2 SG", forms.get("NOM SG"));
		forms.put("AKK SG", INVSTEM+"den");
		forms.put("GEN SG", INVSTEM+"den");
		forms.put("PAR SG", INVSTEM+"tta"+HARVOW);
		forms.put("INE SG", INVSTEM+"dess"+HARVOW);
		forms.put("ELA SG", INVSTEM+"dest"+HARVOW);
		forms.put("ILL SG", INVSTEM+"teen");
		forms.put("ADE SG", INVSTEM+"dell"+HARVOW);
		forms.put("ALL SG", INVSTEM+"delle");
		forms.put("ABL SG", INVSTEM+"delt"+HARVOW);
		forms.put("ESS SG", INVSTEM+"ten"+HARVOW);
		forms.put("TRA SG", INVSTEM+"deksi");
		forms.put("ABE SG", INVSTEM+"dett"+HARVOW);
		
		//----------------------PL Forms--------------------------
		forms.put("NOM PL", INVSTEM+"det");
		forms.put("AKK PL", forms.get("NOM PL"));
		forms.put("AKK2 PL",forms.get("NOM PL"));
		forms.put("GEN PL", INVSTEM+"ksien");
		forms.put("PAR PL", INVSTEM+"ksi"+HARVOW);
		forms.put("INE PL", INVSTEM+"ksiss"+HARVOW);
		forms.put("ILL PL", INVSTEM+"ksiin");
		forms.put("ELA PL", INVSTEM+"ksist"+HARVOW);
		forms.put("ADE PL", INVSTEM+"ksill"+HARVOW);
		forms.put("ALL PL", INVSTEM+"ksille");
		forms.put("ABL PL", INVSTEM+"ksilt"+HARVOW);
		forms.put("ESS PL", INVSTEM+"ksin"+HARVOW);
		forms.put("TRA PL", INVSTEM+"ksiksi");
		forms.put("INS PL", INVSTEM+"ksin");
		forms.put("ABE PL", INVSTEM+"ksitt"+HARVOW);
		forms.put("COM PL", INVSTEM+"ksineen");
		
		return forms;
		
		
	}
	
	public List<HashMap<String, String>> generatePossesiveForms(HashMap<String, String>basicforms, String INVSTEM, String STRONG, String HARVOW ){
		String x = "de";
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
		//kaksiavioisuus
		//decl(kalleus, laihuu, a)
		//terveys decl(kalleus, tervey, ä)

		Kalleus k = new Kalleus();
		HashMap<String, String>forms = k.generateForms("tervey", "ä");
		for (String key: forms.keySet()) {
			System.out.println(key + ": ");
			System.out.println(forms.get(key));
		}
		//decl(kalleus, kaksiavioisuu, a)

	}

}
