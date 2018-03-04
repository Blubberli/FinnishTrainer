package Nouns;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Ovi {
	
	public HashMap<String, String> generateForms(String INVSTEM, String STRONG, String WEAK, String ENDVOW, String HARVOW){
		HashMap<String, String> forms = new HashMap();
		
		//---------------------SG Forms---------------------------
		forms.put("NOM SG", INVSTEM+STRONG+"i");
		forms.put("GEN SG", INVSTEM+WEAK+"en");
		forms.put("AKK SG", INVSTEM+WEAK+"en");
		forms.put("AKK2 SG", forms.get("NOM SG"));
		forms.put("PAR SG", INVSTEM+STRONG+"e"+HARVOW);
		forms.put("INE SG", INVSTEM+WEAK+"ess"+HARVOW);
		forms.put("ILL SG", INVSTEM+STRONG+"een");
		forms.put("ELA SG", INVSTEM+WEAK+"est"+HARVOW);
		forms.put("ADE SG", INVSTEM+WEAK+"ell"+HARVOW);
		forms.put("ALL SG", INVSTEM+WEAK+"elle");
		forms.put("ABL SG", INVSTEM+WEAK+"elt"+HARVOW);
		forms.put("ESS SG", INVSTEM+STRONG+"en"+HARVOW);
		forms.put("TRA SG", INVSTEM+WEAK+"eksi");
		forms.put("ABE SG", INVSTEM+WEAK+"ett"+HARVOW);
		
		//----------------------PL Forms--------------------------
		forms.put("NOM PL", INVSTEM+WEAK+"et");
		forms.put("AKK PL", forms.get("NOM PL"));
		forms.put("AKK2 PL",forms.get("NOM PL"));
		forms.put("GEN PL", INVSTEM+STRONG+"ien");
		forms.put("PAR PL", INVSTEM+STRONG+"i"+HARVOW);
		forms.put("INE PL", INVSTEM+WEAK+"iss"+HARVOW);
		forms.put("ILL PL", INVSTEM+STRONG+"iin");
		forms.put("ELA PL", INVSTEM+WEAK+"ist"+HARVOW);
		forms.put("ADE PL", INVSTEM+WEAK+"ill"+HARVOW);
		forms.put("ALL PL", INVSTEM+WEAK+"ille");
		forms.put("ABL PL", INVSTEM+WEAK+"ilt"+HARVOW);
		forms.put("ESS PL", INVSTEM+STRONG+"in"+HARVOW);
		forms.put("TRA PL", INVSTEM+WEAK+"iksi");
		forms.put("INS PL", INVSTEM+WEAK+"in");
		forms.put("ABE PL", INVSTEM+WEAK+"itt"+HARVOW);
		forms.put("COM PL", INVSTEM+STRONG+"ineen");

		return forms;		
	}
	
	public List<HashMap<String, String>> generatePossesiveForms(HashMap<String, String>basicforms, String INVSTEM, String STRONG, String HARVOW ){
		String x = "e";
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
		Ovi o = new Ovi();
		HashMap<String, String>forms = o.generateForms("jo", "k", "", "", "a");
		for (String f : forms.keySet()) {
			System.out.println(f);
			System.out.println(forms.get(f));
		}
	}

}
