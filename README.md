# Monty-Hall
Tek Systems Assignment



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
