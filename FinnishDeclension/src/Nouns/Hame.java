package Nouns;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Hame {
	
	public HashMap<String, String> generateForms(String INVSTEM, String STRONG, String WEAK, String HARVOW){
		HashMap<String, String> forms = new HashMap();
		//---------------------SG Forms---------------------------
		forms.put("NOM SG", INVSTEM+STRONG+"e");
		forms.put("AKK SG", INVSTEM+WEAK+"een");
		forms.put("AKK2 SG", forms.get("NOM SG"));
		forms.put("GEN SG", INVSTEM+WEAK+"een");
		forms.put("PAR SG", INVSTEM+STRONG+"ett"+HARVOW);
		forms.put("INE SG", INVSTEM+WEAK+"eess"+HARVOW);
		forms.put("ELA SG", INVSTEM+WEAK+"eest"+HARVOW);
		forms.put("ILL SG", INVSTEM+WEAK+"eeseen");
		forms.put("ADE SG", INVSTEM+WEAK+"eell"+HARVOW);
		forms.put("ABL SG", INVSTEM+WEAK+"eelt"+HARVOW);
		forms.put("ALL SG", INVSTEM+WEAK+"eelle");
		forms.put("ESS SG", INVSTEM+WEAK+"een"+HARVOW);
		forms.put("TRA SG", INVSTEM+WEAK+"eeksi");
		forms.put("ABE SG", INVSTEM+WEAK+"eett"+HARVOW);
		
		//----------------------PL Forms--------------------------
		forms.put("NOM PL", INVSTEM+WEAK+"eet");
		forms.put("AKK PL", forms.get("NOM PL"));
		forms.put("AKK2 PL",forms.get("NOM PL"));
		forms.put("GEN PL", INVSTEM+WEAK+"eiden" + "|" + INVSTEM + WEAK + "eitten");
		forms.put("PAR PL", INVSTEM+WEAK+"eit"+HARVOW);
		forms.put("INE PL", INVSTEM+WEAK+"eiss"+HARVOW);
		forms.put("ELA PL", INVSTEM+WEAK+"eist"+HARVOW);
		forms.put("ILL PL", INVSTEM+WEAK+"eisiin" + "|" +INVSTEM+WEAK+"eihin");
		forms.put("ADE PL", INVSTEM+WEAK+"eill"+HARVOW);
		forms.put("ABL PL", INVSTEM+WEAK+"eilt"+HARVOW);
		forms.put("ALL PL", INVSTEM+WEAK+"eille");
		forms.put("ESS PL", INVSTEM+WEAK+"ein"+HARVOW);
		forms.put("TRA PL", INVSTEM+WEAK+"eiksi");
		forms.put("INST PL", INVSTEM+WEAK+"ein");
		forms.put("ABE PL", INVSTEM+WEAK+"eitt"+HARVOW);
		forms.put("COM PL", INVSTEM+WEAK+"eineen");
		//COM ist immer mit possessivsuffix
		
		return forms;
		
		
	}
	public List<HashMap<String, String>> generatePossesiveForms(HashMap<String, String>basicforms, String INVSTEM, String STRONG, String HARVOW ){
		String x = "ee";
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
		//decl(hame, törmä, nn, nt, ä)
		String sade = "hame, sa, d, t, a";
		String hame = "hame, ham, , , a";
		String sähke = "decl(hame, sähk, , , ä";
		Hame h = new Hame();
		HashMap<String, String> forms = h.generateForms("sa", "d", "t", "a");
		for (String key: forms.keySet()) {
			System.out.println(key + " : ");
			System.out.println(forms.get(key));
		}
	}

}
