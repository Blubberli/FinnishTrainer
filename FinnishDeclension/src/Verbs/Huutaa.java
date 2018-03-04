package Verbs;
import java.util.HashMap;

public class Huutaa {
	public HashMap<String, String> getForms(String stem, String weak, String strong, String harvow){
		HashMap <String, String> forms  = new HashMap<String, String>();
		//------------------present tense-------------------------------
		forms.put("PRS 1 SG", stem+weak+harvow+'n');
		forms.put("PRS 2 SG", stem+weak+harvow+'t');
		forms.put("PRS 3 SG", stem+strong+harvow+harvow);
		forms.put("PRS 1 PL", stem+weak+harvow+"mme");
		forms.put("PRS 2 PL", stem+weak+harvow+"tte");
		forms.put("PRS 3 PL", stem+strong+harvow+"v"+harvow+"t");
		forms.put("PRS passive", stem+"et"+strong+harvow+harvow+"n");
		
		
		return forms;
	}
	
	public static void main(String[] args) {
		Huutaa hut = new Huutaa();
		HashMap<String, String>huutaa = hut.getForms("löy","","","ä");
		for (String key: huutaa.keySet()) {
			System.out.println(key + " " + huutaa.get(key));
		}
	}
}
