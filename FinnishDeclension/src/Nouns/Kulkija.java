package Nouns;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Kulkija {
	
	public HashMap<String, String> generateForms(String INVSTEM, String HARVOW){
		HashMap<String, String> forms = new HashMap();
		//---------------------SG Forms---------------------------
		forms.put("NOM SG", INVSTEM+"a");
		forms.put("AKK SG", INVSTEM+"an");
		forms.put("AKK2 SG", forms.get("NOM SG"));
		forms.put("GEN SG", INVSTEM+"an");
		forms.put("PAR SG", INVSTEM+"a"+HARVOW);
		forms.put("INE SG", INVSTEM+"ass"+HARVOW);
		forms.put("ILL SG", INVSTEM+"aan");
		forms.put("ELA SG", INVSTEM+"ast"+HARVOW);
		forms.put("ADE SG", INVSTEM+"all"+HARVOW);
		forms.put("ALL SG", INVSTEM+"alle");
		forms.put("ABL SG", INVSTEM+"alt"+HARVOW);
		forms.put("ESS SG", INVSTEM+"an"+HARVOW);
		forms.put("TRA SG", INVSTEM+"aksi");
		forms.put("ABE SG", INVSTEM+"att"+HARVOW);
		
		//----------------------PL Forms--------------------------
		forms.put("NOM PL", INVSTEM+"at");
		forms.put("AKK PL", forms.get("NOM PL"));
		forms.put("AKK2 PL",forms.get("NOM PL"));
		forms.put("GEN SG", INVSTEM+"oiden"+ "|" + INVSTEM+"oitten");
		forms.put("PAR PL", INVSTEM+"oit"+HARVOW);
		forms.put("INE PL", INVSTEM+"oiss"+HARVOW);
		forms.put("ILL PL", INVSTEM+"oihin");
		forms.put("ELA PL", INVSTEM+"oist"+HARVOW);
		forms.put("ADE PL", INVSTEM+"oill"+HARVOW);
		forms.put("ALL PL", INVSTEM+"oille");
		forms.put("ABL PL", INVSTEM+"oilt"+HARVOW);
		forms.put("ESS PL", INVSTEM+"oin"+HARVOW);
		forms.put("TRA PL", INVSTEM+"oiksi");
		forms.put("INS PL" ,INVSTEM+"oin");
		forms.put("ABE PL", INVSTEM+"oitt"+HARVOW);
		forms.put("COM PL", INVSTEM+"oineen");
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
		//decl(kulkija, kakofoni, a)
		Kulkija k = new Kulkija();
		HashMap<String, String> forms = k.generateForms("kakofoni", "a");
		for (String key: forms.keySet()) {
			System.out.println(key + " :");
			System.out.println(forms.get(key));
		}
		//kaitsija


	}

}
