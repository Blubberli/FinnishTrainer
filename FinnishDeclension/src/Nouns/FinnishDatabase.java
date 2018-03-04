package Nouns;
import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import javax.swing.plaf.synth.SynthSpinnerUI;

import java.util.Arrays;

public class FinnishDatabase implements java.io.Serializable {
	//ArrayList <String> caseclasse = new ArrayList()
	private static final long serialVersionUID = 2764686785633329356L;
	
	public HashMap<String, String> createDictionary(String path) throws IOException {
		String [] caseclasses = new String[] {"hame", "koira", "kala", "kalleus", "kulkjia", "valo", "risti", "paperi", "ovi", "palvelu", "nainen", "valtio"};
		List<String> cases = Arrays.asList(caseclasses);
		BufferedReader br = new BufferedReader(new FileReader(path));
		HashMap<String, String> database = new HashMap<String, String>();
		while (br.ready()) {
			String line = br.readLine();
			String [] cols = line.split("\t");
			String word = cols[0].trim();
			String pos = cols[1].trim();
			String info = cols[2].trim();
			String translation = cols[3].trim();
			String caseclass = info.split(",")[0].replace("decl(", "").trim();
			if (cases.contains(caseclass)){
				//System.out.println("case: " + caseclass);
				//System.out.println("word: " + word);
				HashMap<String,String>noundeclinations = generateNounForms(info);
				for (String form: noundeclinations.keySet()) {
					String declnoun = noundeclinations.get(form);
					//System.out.println(declnoun);
					if (database.containsKey(declnoun)) {
						String forminfo = database.get(declnoun);
						forminfo+="| " + form;
						database.put(declnoun, forminfo);
					}
					else {
						database.put(declnoun, form);
					}
				}
			}
		}
		br.close();
		return database;
	}
	
	public HashMap<String, String> generateNounForms(String info){
		HashMap<String, String> forms = new HashMap<String, String>();
		boolean i0 = false;
		if (info.contains("i=0")) {
			i0 = true;
			info = info.replace(" i=0,", "");
		}
		String [] parts = info.split(",");
		String caseclass = parts[0].replace("decl(", "").trim();
		String INVSTEM = parts[1].trim();
		String HARVOW = parts[parts.length-1].replace(")", "").trim();
		String STRONG = "";
		String WEAK = "";
		String ENDVOW = "";
		if (parts.length >= 4) {
			STRONG = parts[2].trim();
			WEAK = parts[3].trim();
		}
		if (parts.length == 5) {
			ENDVOW = parts[4].trim();
		}
		switch (caseclass) {
		case "valo":
			Valo v = new Valo();
			forms = v.generateForms(INVSTEM, STRONG, WEAK, ENDVOW, HARVOW);
			break;
		case "risti":
			Risti r = new Risti();
			forms = r.generateForms(INVSTEM, i0, STRONG, WEAK, HARVOW);
			break;
		case "paperi":
			Paperi p =  new Paperi();
			forms = p.generateForms(INVSTEM, HARVOW, i0);
			break;
		case "kala":
			Kala k = new Kala();
			forms = k.generateForms(INVSTEM, STRONG, WEAK, HARVOW);
			break;
		case "koira":
			Koira ko = new Koira();
			ko.generateForms(INVSTEM, STRONG, WEAK, HARVOW);
			break;
		case "kulkija":
			Kulkija ku = new Kulkija();
			forms = ku.generateForms(INVSTEM, HARVOW);
			break;
		case "palvelu":
			Palvelu pa = new Palvelu();
			forms = pa.generateForms(INVSTEM, HARVOW);
			break;
		case "nainen":
			Nainen n = new Nainen();
			forms = n.generateForms(INVSTEM, HARVOW);
			break;
		case "valtio":
			Valtio va = new Valtio();
			forms = va.generateForms(INVSTEM, HARVOW);
			break;
		case "hame":
			Hame ha = new Hame();
			forms = ha.generateForms(INVSTEM, STRONG, WEAK, HARVOW);
			break;
		case "kalleus":
			Kalleus ka = new Kalleus();
			forms  = ka.generateForms(INVSTEM, HARVOW);
			break;
		case "ovi":
			Ovi o = new Ovi();
			forms = o.generateForms(INVSTEM, STRONG, WEAK, ENDVOW, HARVOW);
			break;
	}
		return forms;
	}
	
	public static void main(String[] args) throws IOException {
		String path = "/home/neele/Dokumente/fi-wiki-preprocessed-20180110.tsv";
		FinnishDatabase db = new FinnishDatabase();
		HashMap<String, String> data = db.createDictionary(path);
		
		// Write to disk with FileOutputStream
		FileOutputStream f_out = new 
			FileOutputStream("FinnishDictionary");

		// Write object with ObjectOutputStream
		ObjectOutputStream obj_out = new
			ObjectOutputStream (f_out);

		// Write object out to disk
		obj_out.writeObject( data );
		System.out.println(data.get("ajokilometrille"));
		System.out.println(data.get("ajokki"));
		System.out.println(data.get("joki"));
	}

}
