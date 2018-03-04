package Verbs;
import java.util.HashMap;

public class sanoa {
	
	public HashMap<String, String> getForms(String stem, String strong, String weak,String classvowel, String harvow){
		HashMap <String, String> forms  = new HashMap<String, String>();
		//------------------present tense-------------------------------
		forms.put("PRS 1 SG", stem+weak+classvowel+'n');
		forms.put("PRS 2 SG", stem+weak+classvowel+'t');
		forms.put("PRS 3 SG", stem+strong+classvowel+classvowel);
		forms.put("PRS 1 PL", stem+weak+classvowel+"mme");
		forms.put("PRS 2 PL", stem+weak+classvowel+"tte");
		forms.put("PRS 3 PL", stem+strong+classvowel+"v"+harvow+"t");
		forms.put("PRS passive", stem+weak+classvowel+"t"+harvow+harvow+"n");
		
		
		return forms;
	}
public static void main(String[] args) {
	sanoa sb = new sanoa();
	HashMap <String, String> san =   sb.getForms("san", "", "", "o","a");
	HashMap<String, String>sälöa = sb.getForms("säil", "", "", "ö", "ä");
	HashMap<String, String>asua = sb.getForms("as", "", "", "u", "a");
	HashMap<String, String>rikkoa = sb.getForms("ri", "kk", "k", "o", "a");
	
	for (String key: san.keySet()) {
		System.out.println(key + " " + san.get(key));
	}
	
	for (String key: sälöa.keySet()) {
		System.out.println(key + " " + sälöa.get(key));
	}
	
	for (String key: asua.keySet()) {
		System.out.println(key+" " + asua.get(key));
	}
	
	for (String key: rikkoa.keySet()) {
		System.out.println(key+" " + rikkoa.get(key));
	}
}
}

