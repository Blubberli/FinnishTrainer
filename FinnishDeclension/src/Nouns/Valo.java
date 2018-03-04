package Nouns;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Valo {
	
	public HashMap<String, String> generateForms(String INVSTEM, String STRONG, String WEAK, String ENDVOW, String HARVOW){
		HashMap<String, String> forms = new HashMap();
		
		//---------------------SG Forms---------------------------
		forms.put("NOM SG", INVSTEM+STRONG+ENDVOW);
		forms.put("GEN SG", INVSTEM+WEAK+ENDVOW+"n");
		forms.put("AKK SG", INVSTEM+WEAK+ENDVOW+"n");
		forms.put("AKK2 SG", forms.get("NOM SG"));
		forms.put("PAR SG", INVSTEM+STRONG+ENDVOW+HARVOW);
		forms.put("INE SG", INVSTEM+WEAK+ENDVOW+"ss"+HARVOW);
		forms.put("ILL SG", INVSTEM+STRONG+ENDVOW+ENDVOW+"n");
		forms.put("ELA SG", INVSTEM+WEAK+ENDVOW+"st"+HARVOW);
		forms.put("ADE SG", INVSTEM+WEAK+ENDVOW+"ll"+HARVOW);
		forms.put("ALL SG", INVSTEM+WEAK+ENDVOW+"lle");
		forms.put("ABL SG", INVSTEM+WEAK+ENDVOW+"lt"+HARVOW);
		forms.put("ESS SG", INVSTEM+STRONG+ENDVOW+"n"+HARVOW);
		forms.put("TRA SG", INVSTEM+WEAK+ENDVOW+"ksi");
		forms.put("ABE SG", INVSTEM+WEAK+ENDVOW+"tt"+HARVOW);
		
		//----------------------PL Forms--------------------------
		forms.put("NOM PL", INVSTEM+WEAK+ENDVOW+"t");
		forms.put("GEN PL", INVSTEM+STRONG+ENDVOW+"jen");
		forms.put("AKK PL", forms.get("NOM PL"));
		forms.put("AKK2 PL",forms.get("NOM PL"));
		forms.put("PAR PL", INVSTEM+STRONG+ENDVOW+"j"+HARVOW);
		forms.put("INE PL", INVSTEM+WEAK+ENDVOW+"iss"+HARVOW);
		forms.put("ILL PL", INVSTEM+STRONG+ENDVOW+"ihin");
		forms.put("ELA PL", INVSTEM+WEAK+ENDVOW+"ist"+HARVOW);
		forms.put("ADE PL", INVSTEM+WEAK+ENDVOW+"ill"+HARVOW);
		forms.put("ALL PL", INVSTEM+WEAK+ENDVOW+"ille");
		forms.put("ABL PL", INVSTEM+WEAK+ENDVOW+"ilt"+HARVOW);
		forms.put("ESS PL", INVSTEM+STRONG+ENDVOW+"in"+HARVOW);
		forms.put("TRA PL", INVSTEM+WEAK+ENDVOW+"iksi");
		forms.put("INS PL", INVSTEM+"in");
		forms.put("ABE PL", INVSTEM+WEAK+ENDVOW+"itt"+HARVOW);
		forms.put("COM PL", INVSTEM+STRONG+"ineen");

		return forms;
		
		
	}
	public List<HashMap<String, String>> generatePossesiveForms(HashMap<String, String>basicforms, String INVSTEM, String STRONG, String HARVOW, String ENDVOW ){
		String x = ENDVOW;
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
		Valo v = new Valo();
		//decl(valo, sär, , , ö, ä)
		//decl(valo, sol, , , u, a)
		HashMap<String, String> täky = v.generateForms("sol", "", "", "u", "a");
		for (String key : täky.keySet()) {
			System.out.println(key + " : ");
			System.out.println(täky.get(key));
		}
	}

}
