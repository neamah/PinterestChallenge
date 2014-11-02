/* Neamah S. Hussein
Pinterest Coding Challenge. 

This program takes an input of two users, A and B, finds any cross-sources second degree connections and
prints out what networks they have these connections on. 

So, if A is connected to some C on Facebook and B is connected to C on Twitter, output should read:

[FACEBOOK, TWITTER]

Room for improvement:

If I were to work on this further, I'd find a way to optimize the list generated for A's connections to 
eliminate connections previously compared to all of B's networks with negative results. So, if 
E, F and G on A's Pinterest network happen to not be in any of B's networks, then if E, F and G are 
present on A's OTHER networks, they shouldn't be compared to B's networks again. 

*/

import java.util.List;
import java.lang.Math;

public enum SocialNetwork {
	PINTEREST, FACEBOOK, TWITTER
}

public class ConnectionFinder{

/* given A's connections on some network, does B have a common connection on "network"? */
public static boolean IsConnection(int B, List<Integer> a_Connections, SocialNetwork network){

	List<Integer> b_Connections = getConnections(B, network);

	int ListSizeA = a_Connections.size();
	int ListSizeB = b_Connections.size();
	List<Integer> smaller;
	List<Integer> larger;

/* Iterate over the smaller list. More efficient for large-scale comparisons */
	int min;
	if (ListSizeA != ListSizeB) {
		min = min(ListSizeA, ListSizeB);
		if (min == ListSizeA) {
			smaller = a_Connections;
			larger = b_Connections;
		}
		else {
			smaller = b_Connections;
			larger = a_Connections;
		}
	}
	/* reptetitive, but just for clarity */
	else {
		min = ListSizeB;
		smaller = b_Connections;
		larger = a_Connections;
	}

/* assuming unordered list of ID's, because listed in order of time of friendship */
	for (int i = 0; i < min; i++){
		int id = smaller.get(i);
		if (larger.contains(id))
			return true;
	}
	return false;
}

public static void main(int A, int B){

/* A on Pinterest. */
	List<Integer> a_Connections = getConnections(A, SocialNetwork.PINTEREST);
	boolean PinterestConnection = IsConnection(B, a_Connections, SocialNetwork.PINTEREST);
	boolean FacebookConnection = IsConnection(B, a_Connections, SocialNetwork.FACEBOOK);
	boolean TwitterConnection = IsConnection(B, a_Connections, SocialNetwork.TWITTER);
	if (PinterestConnection)
		System.out.println("[PINTEREST, PINTEREST]");
	if (FacebookConnection)
		System.out.println("[PINTEREST, FACEBOOK]");
	if (TwitterConnection)
		System.out.println("[PINTEREST, TWITTER]");

/* A on Facebook. */
	a_Connections = getConnections(A, SocialNetwork.FACEBOOK);
	PinterestConnection = IsConnection(B, a_Connections, SocialNetwork.PINTEREST);
	FacebookConnection = IsConnection(B, a_Connections, SocialNetwork.FACEBOOK);
	TwitterConnection = IsConnection(B, a_Connections, SocialNetwork.TWITTER);
	if (PinterestConnection)
		System.out.println("[FACEBOOK, PINTEREST]");
	if (FacebookConnection)
		System.out.println("[FACEBOOK, FACEBOOK]");
	if (TwitterConnection)
		System.out.println("[FACEBOOK, TWITTER]");

/* A on Facebook. */
	a_Connections = getConnections(A, SocialNetwork.TWITTER);
	PinterestConnection = IsConnection(B, a_Connections, SocialNetwork.PINTEREST);
	FacebookConnection = IsConnection(B, a_Connections, SocialNetwork.FACEBOOK);
	TwitterConnection = IsConnection(B, a_Connections, SocialNetwork.TWITTER);
	if (PinterestConnection)
		System.out.println("[TWITTER, PINTEREST]");
	if (FacebookConnection)
		System.out.println("[TWITTER, FACEBOOK]");
	if (TwitterConnection)
		System.out.println("[TWITTER, TWITTER]");
}
}

