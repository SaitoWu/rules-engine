package im.saito.rulesengine;

import java.util.HashMap;
import java.util.Map;

import junit.framework.Assert;
import junit.framework.TestCase;

import im.saito.rulesengine.model.Rule;
import im.saito.rulesengine.model.RuleBook;

public class EngineTest extends TestCase{

	public RuleBook rulebook;
	
	public Map<String, Object> facts;
	
	public void setUp(){
		rulebook = new RuleBook("book");
		facts = new HashMap<String, Object>();
		
		Rule rule1 = new Rule("rule1")
				.condition("color.equals(\"red\")")
				.action("System.out.println(\"color is \" + color); color = \"blue\"; System.out.println(\"change color to \" + color)")
				.priority(1);
		
		Rule rule2 = new Rule("rule2")
				.condition("color.equals(\"blue\")")
				.action("System.out.println(\"color is \" + color); color = \"red\"; System.out.println(\"change color to \" + color)");
		
		Rule rule3 = new Rule("rule3")
				.condition("color.equals(\"red\")")
				.action("System.out.println(\"color is \" + color); color = \"yellow\"; System.out.println(\"change color to \" + color)")
				.priority(2);
		
		rulebook.addRules(rule1, rule2, rule3);
		
		facts.put("color", "blue");
	}
	
	public void testRun(){
		Engine engine = new Engine(rulebook);
		engine.run(facts);
		Assert.assertEquals("red", facts.get("color"));
	}
	
	public void testRunWithPriority(){
		Engine engine = new Engine(rulebook);
		facts.put("color", "red");
		engine.run(facts);
	}
	
}
