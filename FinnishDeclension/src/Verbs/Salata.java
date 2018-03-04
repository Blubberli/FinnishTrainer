package Verbs;

import java.util.HashMap;

public class Salata {
	
	public HashMap<String, String> getForms(String stem, String strong, String weak, String harvow){
		HashMap <String, String> forms  = new HashMap<String, String>();
		//------------------present tense-------------------------------
		forms.put("PRS 1 SG", stem+weak+harvow+harvow+"n");
		forms.put("PRS 2 SG", stem+weak+harvow+harvow+"t");
		forms.put("PRS 3 SG", stem+weak+harvow+harvow);
		forms.put("PRS 1 PL", stem+weak+harvow+harvow+"mme");
		forms.put("PRS 2 PL", stem+weak+harvow+harvow+"tte");
		forms.put("PRS 3 PL", stem+weak+harvow+harvow+"v"+harvow+"t");
		forms.put("PRS passive", stem+strong+harvow+"t"+harvow+harvow+"n");
		
		
		return forms;
	}
	
	public static void main(String[] args) {
		//conj(salata, lis, , , ä)
		Salata sa = new Salata();
		HashMap <String, String>lisätä = sa.getForms("lis", "","", "ä");
		HashMap <String, String>ladata = sa.getForms("la", "d","t", "a");

		for (String key: lisätä.keySet()) {
			System.out.println(key + " " + lisätä.get(key));
		}
		for (String key: ladata.keySet()) {
			System.out.println(key + " " + ladata.get(key));
		}
		
	}

}
