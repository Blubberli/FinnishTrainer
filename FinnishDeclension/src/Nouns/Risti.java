package Nouns;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Risti {
	
	public HashMap<String, String> generateForms(String INVSTEM, boolean i0, String STRONG, String WEAK, String HARVOW){
		HashMap<String, String> forms = new HashMap();
		String ENDVOW="i";
		//---------------------SG Forms---------------------------
		if (i0 == true) {
			forms.put("NOM SG", INVSTEM+STRONG);
		}
		else {
			forms.put("NOM SG", INVSTEM+STRONG+"i");
		}
		forms.put("GEN SG", INVSTEM+WEAK+"in");
		forms.put("AKK SG", INVSTEM+WEAK+"in");
		forms.put("AKK2 SG", forms.get("NOM SG"));
		forms.put("PAR SG", INVSTEM+STRONG+ENDVOW+HARVOW);
		forms.put("INE SG", INVSTEM+WEAK+"iss"+HARVOW);
		forms.put("ILL SG", INVSTEM+STRONG+ENDVOW+"in");
		forms.put("ELA SG", INVSTEM+WEAK+"ist"+HARVOW);
		forms.put("ADE SG", INVSTEM+WEAK+"ill"+HARVOW);
		forms.put("ALL SG", INVSTEM+WEAK+"ille");
		forms.put("ABL SG", INVSTEM+WEAK+"ilt"+HARVOW);
		forms.put("ESS SG", INVSTEM+STRONG+"in"+HARVOW);
		forms.put("TRA SG", INVSTEM+WEAK+"iksi");
		forms.put("ABE SG", INVSTEM+WEAK+"itt"+HARVOW);
		
		//----------------------PL Forms--------------------------
		forms.put("NOM PL", INVSTEM+WEAK+"it");
		forms.put("AKK PL", forms.get("NOM PL"));
		forms.put("AKK2 PL",forms.get("NOM PL"));
		forms.put("GEN PL", INVSTEM+STRONG+"ien" + "|" + INVSTEM+STRONG+"eiden"+"|"+INVSTEM+STRONG+"eitten");
		forms.put("PAR PL", INVSTEM+STRONG+"ej"+HARVOW);
		forms.put("INE PL", INVSTEM+WEAK+"eiss"+HARVOW);
		forms.put("ILL PL", INVSTEM+STRONG+"eihin");
		forms.put("ELA PL", INVSTEM+WEAK+"eist"+HARVOW);
		forms.put("ADE PL", INVSTEM+WEAK+"eill"+HARVOW);
		forms.put("ALL PL", INVSTEM+WEAK+"eille");
		forms.put("ABL PL", INVSTEM+WEAK+"eilt"+HARVOW);
		forms.put("ESS PL", INVSTEM+STRONG+"ein"+HARVOW);
		forms.put("TRA PL", INVSTEM+WEAK+"eiksi");
		forms.put("INS PL", INVSTEM+"ein");
		forms.put("ABE PL", INVSTEM+WEAK+"eitt"+HARVOW);
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
		//decl(risti, tuol, , , a)
		//decl(risti, ajokilometr, , , ä)

		Risti r = new Risti();
		HashMap<String, String> forms = r.generateForms("ajokilometr",false, "",  "", "ä");
		for (String key: forms.keySet()) {
			System.out.println(key + " :");
			System.out.println(forms.get(key));
		}

	}

}
