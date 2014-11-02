Candidate: Neamah S. Hussein

This is my answer to Code Challenge #2 given by Pinterest for interested internship applicants. 

Two users, A and B, are said to have a cross-source second degree connection, if there exists another user, C that is connected
to user A by source S1 and user B by source S2 and S1 is not equal to S2. 

Write a function that, given two Pinterest user ID's, outputs all corss-sourced second degree connection combinations for these
to users. 

Room for improvement:

If I were to work on this further, I'd find a way to optimize the list generated for A's connections to 
eliminate connections previously compared to all of B's networks with negative results. So, if 
E, F and G on A's Pinterest network happen to not be in any of B's networks, then if E, F and G are 
present on A's OTHER networks, they shouldn't be compared to B's networks again. 

