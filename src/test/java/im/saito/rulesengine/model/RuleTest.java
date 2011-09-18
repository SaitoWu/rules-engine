package im.saito.rulesengine.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import junit.framework.Assert;
import junit.framework.TestCase;

public class RuleTest extends TestCase {

	public Rule rule;

	public Map<String, Object> facts;

	public void setUp() {
		rule = new Rule("rule")
				.condition("color.equals(\"red\")")
				.action("System.out.println(\"color is red!\")");

		facts = new HashMap<String, Object>();
		facts.put("color", "red");
	}

	public void testJudge() {
		Assert.assertTrue(rule.judge(rule.condition, facts));

		facts.put("color", "blue");
		Assert.assertFalse(rule.judge(rule.condition, facts));
	}

	public void testImplement() {
		rule.implement(rule.action, facts);
	}
	
	public void testCompareRule(){
		Rule rule1 = new Rule("rule1").priority(1);
		Rule rule2 = new Rule("rule2").priority(2);
		
		List<Rule> list = new ArrayList<Rule>();
		list.add(rule1);
		list.add(rule2);
		
		Assert.assertSame(1, list.get(0).priority);
		
		Collections.sort(list);
		
		Assert.assertSame(2, list.get(0).priority);
	}
}
