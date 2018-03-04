package Nouns;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Kala {
	
	public HashMap<String, String> generateForms(String INVSTEM, String STRONG, String WEAK, String HARVOW){
		HashMap<String, String> forms = new HashMap();
		//---------------------SG Forms---------------------------
		forms.put("NOM SG", INVSTEM+STRONG+"a");
		forms.put("AKK SG", INVSTEM+WEAK+"an");
		forms.put("AKK2 SG", forms.get("NOM SG"));
		forms.put("GEN SG", INVSTEM+WEAK+"an");
		forms.put("PAR SG", INVSTEM+STRONG+"a"+HARVOW);
		forms.put("INE SG", INVSTEM+WEAK+"ass"+HARVOW);
		forms.put("ELA SG", INVSTEM+WEAK+"ast"+HARVOW);
		forms.put("ILL SG", INVSTEM+STRONG+"aan");
		forms.put("ADE SG", INVSTEM+WEAK+"all"+HARVOW);
		forms.put("ALL SG", INVSTEM+WEAK+"alle");
		forms.put("ABL SG", INVSTEM+WEAK+"alt"+HARVOW);
		forms.put("ESS SG", INVSTEM+STRONG+"an"+HARVOW);
		forms.put("TRA SG", INVSTEM+WEAK+"aksi");
		forms.put("ABE SG", INVSTEM+WEAK+"att"+HARVOW);
		
		//----------------------PL Forms--------------------------
		forms.put("NOM PL", INVSTEM+WEAK+"at");
		forms.put("AKK PL", forms.get("NOM PL"));
		forms.put("AKK2 PL",forms.get("NOM PL"));
		forms.put("GEN PL", INVSTEM+STRONG+"ojen");
		forms.put("PAR PL", INVSTEM+STRONG+"oj"+HARVOW);
		forms.put("INE PL", INVSTEM+WEAK+"oiss"+HARVOW);
		forms.put("ILL PL", INVSTEM+STRONG+"oihin");
		forms.put("ELA PL", INVSTEM+WEAK+"oist"+HARVOW);
		forms.put("ADE PL", INVSTEM+WEAK+"oill"+HARVOW);
		forms.put("ALL PL", INVSTEM+WEAK+"oille");
		forms.put("ABL PL", INVSTEM+WEAK+"oilt"+HARVOW);
		forms.put("ESS PL", INVSTEM+STRONG+"oin"+HARVOW);
		forms.put("TRA PL", INVSTEM+WEAK+"oiksi");
		forms.put("INS PL", INVSTEM+WEAK+"oin");
		forms.put("ABE PL", INVSTEM+WEAK+"oitt"+HARVOW);
		forms.put("COM PL", INVSTEM+STRONG+"oineen");

		return forms;
		
		
	}
	public List<HashMap<String, String>> generatePossesiveForms(HashMap<String, String>basicforms, String INVSTEM, String STRONG, String HARVOW ){
		String x = "a";
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
		//decl(kala, kal, , , a)
		//checke die harvow (ob es auch ä gibt) 
		//väylä
	}

}
