package Verbs;

import java.util.HashMap;

public class Tulla {
	
	public HashMap<String, String> getForms(String stem, String weak, String strong,String classvowel, String harvow){
		HashMap <String, String> forms  = new HashMap<String, String>();
		//------------------present tense-------------------------------
		forms.put("PRS 1 SG", stem+weak+classvowel+"en");
		forms.put("PRS 2 SG", stem+weak+classvowel+"et");
		forms.put("PRS 3 SG", stem+strong+classvowel+"ee");
		forms.put("PRS 1 PL", stem+weak+classvowel+"emme");
		forms.put("PRS 2 PL", stem+weak+classvowel+"ette");
		forms.put("PRS 3 PL", stem+strong+classvowel+"ev"+harvow+"t");
		forms.put("PRS passive", stem+weak+classvowel + classvowel.charAt(classvowel.length()-1)+harvow+harvow+"n");
		
		
		return forms;
	}
	
	public static void main(String[] args) {
		//conj(tulla, t, , , ul, a)
		//conj(tulla, käv, , , el, ä)
		//conj(tulla, p, , , an, a)

		Tulla tu = new Tulla();
		HashMap <String, String>tulla = tu.getForms("t", "","", "ul","a");
		HashMap <String, String>kävellä = tu.getForms("käv", "","", "el","ä");
		HashMap <String, String>panna = tu.getForms("p", "","", "an","a");

		for (String key: tulla.keySet()) {
			System.out.println(key + " " + tulla.get(key));
		}
		for (String key: kävellä.keySet()) {
			System.out.println(key + " " + kävellä.get(key));
		}
		for (String key: panna.keySet()) {
			System.out.println(key + " " + panna.get(key));
		}
		

	}
}
