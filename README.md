# Monty-Hall
Summary: This is Tek Systems home assignment project. Monty Hall is well known game, is a brain teaser, a probability puzzle  . In this game and a statisticall illusion.

Scope: Game is with 3 doors, behind one of the door is prize. Game host let gamer to choose prize door to find probabilistic of choosing prize.

Design:
1. Game host let Gamer to choose any door out of the number of doors configured (here is 3 doors)
2. Game host open non prized door and let one non prize door and one prized door to continue game.
3. Game host let Gamer to change his decision to change his winning probability.
4. Gamer may change his previous decision or let the prvious decision to keep.
5. Finally Game host open all the doors, to decide Gamer win the prize.

The following decisions are taken while developing:
 1. In my design Game host and Gamer decisions are replaced by random generator to choose. 
 2. This project is extendable. Application configuration is kept in JSON document, sothat application can be extendable based on JSON configuration. Ex: a. behind the door items can be changed. b. Number of doors can be changed.
 3. Thymeleaf templates are used for display.
 4. Iterations and choice values are passed through browser calling link. ex. http:// localhost:8080/api/play/{iterations}/{choice}
 5. For results - end table of values display - Array of Array elements data structure is used and displayed with Thymeleaf template.
 



Results:

The number of iterations are less than 1000, the following is the result:
http://localhost:8080/api/play/10/y/    for choice: pass y or n 

Win Percentage: 38.0%

Iteration	Door 0	Door 1	Door 2	Original	Selected	Win                                                                                  1	        🐐	    🚓	    🐐	     2	       1	    true                                                                                 
2	         🚓	     🐐	     🐐	      1	        1	     false
3	        🐐	    🚓	    🐐	     2	       1	    true
4	        🐐  	  🐐	    🚓	     0	       2	    true
5	        🐐	    🚓	    🐐	     0	       2	    false
6	        🐐	    🚓	    🐐	     2	       2	    false
7	        🚓	    🐐	    🐐	     2	       1	    false
8	        🐐	    🐐	    🚓	     2	       1	    false
9	        🚓	    🐐	    🐐	     2	       1	    false
10	      🐐	    🚓	    🐐	     0	       1	    true


The number of iterations are more than 1000, the following is the result:

http://localhost:8080/api/play/1500/y/   for choice: pass y or n 

Win Percentage: 33.0%

Adding comments for testing purpose.
