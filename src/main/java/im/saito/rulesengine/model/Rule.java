package im.saito.rulesengine.model;

import java.util.Map;

import org.mvel2.MVEL;


public class Rule implements Comparable<Rule>{
	
	public String describe;

	public String action;

	public String condition;
	
	public Integer priority;
	
	public Rule(String describe){
		this.describe = describe;
	}
	
	public Rule action(String action){
		this.action = action;
		return this;
	}
	
	public Rule condition(String condition){
		this.condition = condition;
		return this;
	}
	
	public Rule priority(Integer priority){
		this.priority = priority;
		return this;
	}

	public Boolean judge(String condition, Map<String, Object> facts){
		return MVEL.evalToBoolean(condition, facts);
	}
	
	public void implement(String action, Map<String, Object> facts){
		MVEL.eval(action, facts);
	}

	@Override
	public int compareTo(Rule o) {
		Integer result = 0;
		if (o.priority != null && this.priority != null) {
			result = o.priority.compareTo(this.priority);
		}
		return result;
	}
}
