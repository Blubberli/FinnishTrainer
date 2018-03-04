package Nouns;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Koira {
	public HashMap<String, String> generateForms(String INVSTEM, String STRONG, String WEAK, String HARVOW){
		HashMap<String, String> forms = new HashMap();
		//---------------------SG Forms---------------------------
		forms.put("NOM SG", INVSTEM +STRONG+ HARVOW);
		forms.put("AKK SG", INVSTEM+WEAK+ HARVOW +"n");
		forms.put("AKK2 SG", forms.get("NOM SG"));
		forms.put("GEN SG", INVSTEM+WEAK+HARVOW+"n");
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
		forms.put("GEN PL", INVSTEM+STRONG+"ien");
		forms.put("PAR PL", INVSTEM+STRONG+"i"+HARVOW);
		forms.put("INE PL", INVSTEM+WEAK+"iss"+HARVOW);
		forms.put("ELA PL", INVSTEM+WEAK+"ist"+HARVOW);
		forms.put("ILL PL", INVSTEM+STRONG+"iin");
		forms.put("ADE PL", INVSTEM+WEAK+"ill"+HARVOW);
		forms.put("ABL PL", INVSTEM+WEAK+"ilt"+HARVOW);
		forms.put("ALL PL", INVSTEM+WEAK+"ille");
		forms.put("ESS PL", INVSTEM+STRONG+"in"+HARVOW);
		forms.put("TRA PL", INVSTEM+WEAK+"iksi");
		forms.put("INS PL", INVSTEM+WEAK+"in");
		forms.put("ABE PL", INVSTEM+WEAK+"itt"+HARVOW);
		forms.put("COM PL", INVSTEM+STRONG+"ineen");
		
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
		Koira k = new Koira();
		//kahdeksan
		//decl(pron, type=koira, 1s='''kahdeksan''' (*), 2s='''kahdeksan''', 3s=kahdeksaa, 4s='''kahdeksan''', 5s=kahdeksassa, 6s=kahdeksasta, 7s=kahdeksaan, 8s=kahdeksalla, 9s=kahdeksalta, 10s=kahdeksalle, 11s=kahdeksana, 12s=kahdeksaksi, 14s=kahdeksatta, 1p=kahdeksat, 2p=kahdeksien  kahdeksain, 3p=kahdeksia, 4p=kahdeksat, 5p=kahdeksissa, 6p=kahdeksista, 7p=kahdeksiin, 8p=kahdeksilla, 9p=kahdeksilta, 10p=kahdeksille, 11p=kahdeksina, 12p=kahdeksiksi, 13p=kahdeksin, 14p=kahdeksitta, 15p=kahdeksine, a7s=kahdeksasti)
		//kahdeksantoista
		//decl(koira, pos=adj, kahdeks, , , a, suffix=toista, nom_sg=kahdeksan)
		//decl(koira, kes, , , ä) _ kesä
		//decl(koira, so, t, d, a) sota
		HashMap<String, String> forms = k.generateForms("so","t","d", "a");
		for (String key: forms.keySet()) {
			System.out.println(key + " : ");
			System.out.println(forms.get(key));
		}
	}
	

}
