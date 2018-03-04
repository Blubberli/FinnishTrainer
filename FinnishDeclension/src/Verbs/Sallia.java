package Verbs;

import java.util.HashMap;

public class Sallia {
	
	public HashMap<String, String> getForms(String stem, String weak, String strong, String harvow){
		HashMap <String, String> forms  = new HashMap<String, String>();
		//------------------present tense-------------------------------
		forms.put("PRS 1 SG", stem+weak+"in");
		forms.put("PRS 2 SG", stem+weak+"it");
		forms.put("PRS 3 SG", stem+strong+"ii");
		forms.put("PRS 1 PL", stem+weak+"imme");
		forms.put("PRS 2 PL", stem+weak+"itte");
		forms.put("PRS 3 PL", stem+strong+"iv"+harvow+"t");
		forms.put("PRS passive", stem+weak+"it"+harvow+harvow+"n");
		
		
		return forms;
	}
	public static void main(String[] args) {
		//conj(sallia, ron, kk, k, a)

		Sallia sl = new Sallia();
		HashMap <String, String>ronkkia = sl.getForms("ron", "k", "kk","a");
		for (String key: ronkkia.keySet()) {
			System.out.println(key + " " + ronkkia.get(key));
		}
	}

}
