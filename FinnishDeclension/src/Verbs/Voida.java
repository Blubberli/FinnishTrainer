package Verbs;

import java.util.HashMap;

public class Voida {
	
	public HashMap<String, String> getForms(String stem, String harvow){
		HashMap <String, String> forms  = new HashMap<String, String>();
		//------------------present tense-------------------------------
		forms.put("PRS 1 SG", stem+'n');
		forms.put("PRS 2 SG", stem+'t');
		forms.put("PRS 3 SG", stem);
		forms.put("PRS 1 PL", stem+"mme");
		forms.put("PRS 2 PL", stem+"tte");
		forms.put("PRS 3 PL", stem+"v"+harvow+"t");
		forms.put("PRS passive", stem+"d"+harvow+harvow+"n");
		
		
		return forms;
	}
	
	public static void main(String[] args) {
		Voida v  = new Voida();
		HashMap<String, String> voida = v.getForms("voi", "a");
		HashMap<String, String> epäröodä = v.getForms("epäröi", "ä");

		for (String key: voida.keySet()) {
			System.out.println(key + " " + voida.get(key));
		}
		
		for (String key: epäröodä.keySet()) {
			System.out.println(key + " " + epäröodä.get(key));
		}

	}

}
