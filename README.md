Rules Engine
============

an useless library for refactor ur messy if/else business logic.

Requirements
============

* Java 5+
* MVEL2
* JUnit 3.8

Mini DSL
========

```java
Rulebook rulebook = new Rulebook("book");
Map<String, Object> facts = new HashMap<String, Object>();

Rule rule1 = new Rule("rule1")
				.condition("color.equals(\"red\")")
				.action("System.out.println(\"color is \" + color); color = \"blue\"; System.out.println(\"change color to \" + color)")
				.priority(2);
		
Rule rule2 = new Rule("rule2")
				.condition("color.equals(\"blue\")")
				.action("System.out.println(\"color is \" + color); color = \"red\"; System.out.println(\"change color to \" + color)");
		
Rule rule3 = new Rule("rule3")
				.condition("color.equals(\"red\")")
				.action("System.out.println(\"color is \" + color); color = \"yellow\"; System.out.println(\"change color to \" + color)")
				.priority(1);
		
rulebook.addRules(rule1, rule2, rule3);

// normal mode
facts.put("color", "red");
Engine engine = new Engine(rulebook);
engine.run(facts);

// recursive mode
facts.put("color", "blue");
Engine engine = new Engine(rulebook);
engine.recursive = true;
engine.run(facts);

```

Tips
====

* rulesengine is not a "java like" java library. if u dont like this style. u can chage it by urself.

Author
======

* Saito Wu saitwu@gmail.com

License
=======

* rulesengine is licensed under the MIT License.(See License)
