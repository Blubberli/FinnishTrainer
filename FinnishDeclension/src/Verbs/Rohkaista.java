package Verbs;

import java.util.HashMap;

public class Rohkaista {
	

	public HashMap<String, String> getForms(String stem, String strong, String weak, String classvowel, String harvow){
		HashMap <String, String> forms  = new HashMap<String, String>();
		//------------------present tense-------------------------------
		forms.put("PRS 1 SG", stem+weak+classvowel+"sen");
		forms.put("PRS 2 SG", stem+weak+classvowel+"set");
		forms.put("PRS 3 SG", stem+weak+classvowel+"see");
		forms.put("PRS 1 PL", stem+weak+classvowel+"semme");
		forms.put("PRS 2 PL", stem+weak+classvowel+"sette");
		forms.put("PRS 3 PL", stem+weak+classvowel+"sev"+harvow+"t");
		forms.put("PRS passive", stem+strong+"ist"+harvow+harvow+"n");
		
		
		return forms;
	}
	
	public static void main(String[] args) {
		//conj(rohkaista, va, v, p, i, a)
		//conj(rohkaista, rohk, , , ai, a)
		Rohkaista rk = new Rohkaista();
		HashMap <String, String> vavista = rk.getForms("va", "v", "p", "i", "a");
		HashMap<String, String> rohkaista = rk.getForms("rohk", "", "", "ai", "a");
		for (String key: vavista.keySet()) {
			System.out.println(key + " " + vavista.get(key));
		}
		
		for (String key: rohkaista.keySet()) {
			System.out.println(key + " " + rohkaista.get(key));
		}
		
	}

}
