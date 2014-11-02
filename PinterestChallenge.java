/* Neamah S. Hussein
Pinterest Coding Challenge. 

This program takes an input of two users, A and B, finds any cross-sources second degree connections and
prints out what networks they have these connections on. 

So, if A is connected to some C on Facebook and B is connected to C on Twitter, output should read:

[FACEBOOK, TWITTER].

-getConnections() is in an unspecified class. 
-assuming no maximum number of friends a person can have
-assuming a list can be empty, since people might not have friends on a certain network if they're 
not active on it.

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

	if (b_Connections.size() == 0 || a_Connections.size() == 0)
		return false;

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
	boolean FacebookConnection = IsConnection(B, a_Connections, SocialNetwork.FACEBOOK);
	boolean TwitterConnection = IsConnection(B, a_Connections, SocialNetwork.TWITTER);
	if (FacebookConnection)
		System.out.println("[PINTEREST, FACEBOOK]");
	if (TwitterConnection)
		System.out.println("[PINTEREST, TWITTER]");

/* A on Facebook. */
	a_Connections = getConnections(A, SocialNetwork.FACEBOOK);
	boolean PinterestConnection = IsConnection(B, a_Connections, SocialNetwork.PINTEREST);
	TwitterConnection = IsConnection(B, a_Connections, SocialNetwork.TWITTER);
	if (PinterestConnection)
		System.out.println("[FACEBOOK, PINTEREST]");
	if (TwitterConnection)
		System.out.println("[FACEBOOK, TWITTER]");

/* A on Facebook. */
	a_Connections = getConnections(A, SocialNetwork.TWITTER);
	PinterestConnection = IsConnection(B, a_Connections, SocialNetwork.PINTEREST);
	FacebookConnection = IsConnection(B, a_Connections, SocialNetwork.FACEBOOK);
	if (PinterestConnection)
		System.out.println("[TWITTER, PINTEREST]");
	if (FacebookConnection)
		System.out.println("[TWITTER, FACEBOOK]");
}
}

