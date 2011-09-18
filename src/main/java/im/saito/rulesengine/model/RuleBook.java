package im.saito.rulesengine.model;

import java.util.ArrayList;
import java.util.List;

public class RuleBook {

	public String name;
	
	public List<Rule> rules;
	
	public RuleBook(String name){
		this.rules = new ArrayList<Rule>();
	}
	
	public void addRule(Rule rule){
		this.rules.add(rule);
	}
	
	public void addRules(Rule... rules){
		for (Rule rule : rules) {
			this.rules.add(rule);
		}
	}
}
