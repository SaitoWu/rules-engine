package im.saito.rulesengine;

import im.saito.rulesengine.model.Rule;
import im.saito.rulesengine.model.RuleBook;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class Engine {
	
	public Boolean recursive;
	
	public RuleBook rulebook;
	
	public List<Rule> agenda;

	public Engine(RuleBook ruleBook){
		this.recursive = false;
		this.rulebook = ruleBook;
		this.agenda = new ArrayList<Rule>();
	}
	
	public void run(Map<String, Object> facts){
		

		for (Rule rule : rulebook.rules) {
			if (rule.judge(rule.condition, facts)) {
				agenda.add(rule);
			}
		}
		
		Collections.sort(agenda);
		
		for (Rule rule : agenda) {
			rule.implement(rule.action, facts);
		}
	}
	
}
