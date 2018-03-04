package Nouns;
import java.util.HashMap;



public class Possesiva {

	public static HashMap<String, String> generateForms(HashMap<String, String> basicforms, String poss, String possinfo, String INVSTEM, String STRONG, String x, String HARVOW){
		HashMap<String, String> possesiveForms = new HashMap<String, String>();
		String strongstem = INVSTEM+STRONG;
		
		for (String form: basicforms.keySet()) {
			
			String posswordform = "";
			String wordform = basicforms.get(form);
			String possform = form+possinfo;
			
			if (possinfo.contains("3")) {
				if (form.startsWith("NOM") || form.startsWith("GEN") || form.startsWith("AKK") || form.startsWith("ILL")) {
					poss = "ns"+HARVOW;
				}
				else {
					char lastchar = wordform.charAt(wordform.length() - 1);
					poss = lastchar + "n";
				}
			}	

			if (form.startsWith("NOM") || form.startsWith("AKK")||form.equals("GEN SG")){
				posswordform = strongstem + x + poss;
				possesiveForms.put(possform, posswordform);
			}
			else if (form.startsWith("TRA")){
				wordform = wordform.replace("ksi", "kse");
				posswordform = wordform +=poss;
				possesiveForms.put(possform, posswordform);
			}
			else {
				if (wordform.endsWith("n")) {
					wordform = wordform.substring(0, wordform.length()-1);
				}
				posswordform = wordform+poss;
				possesiveForms.put(possform, posswordform);

			}
			
		}
		
		return possesiveForms;
	}
	
	public static void main(String[] args) {
		//decl(ovi, jo, k, , a)
		//decl(valo, tal, , , o, a)
		HashMap<String, String> possis = new HashMap<String, String>();
		HashMap<String, String> jokiforms = new Ovi().generateForms("jo", "k", "", "", "a");
		HashMap<String, String> taloforms = new Valo().generateForms("tal", "", "", "o", "a");
		HashMap<String, String> hameforms = new Hame().generateForms("sa", "d", "t", "a");
		HashMap<String, String> forms = Possesiva.generateForms(hameforms, "ni", "1.SG", "sa", "d", "t", "a");
		for (String form: forms.keySet()) {
			System.out.println(form);
			System.out.println(forms.get(form));
		}

	}

//	

//	jokeni < joki
//	jokeni < joen     
//	jokeni < joen
//	jokeani < jokea
//	joessani < joessa
//	joestani < joesta
//	jokeeni < jokeen
//	joellani < joella
//	joeltani < joelta
//	joelleni < joelle
//	jokenani < jokena
//	joekseni < joeksi
//	joetta < joetta
//
//	jokeni < joet
//	jokeni < joet
//	jokieni < jokien
//	jokiani < jokia
//	joissani < joissa
//	joistani < joista
//	jokiini < jokiin
//	joillani < joilla
//	joiltani < joilta
//	joilleni < joille
//	jokinani < jokina
//	joikseni < joiksi
//	joittani < joitta

}
