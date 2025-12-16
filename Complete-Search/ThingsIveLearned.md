Creating Strings
- Equation for distinct number of permutations in a multiset: 
$n! / (n1! * n2! * ... * nk!)$
- Visualize building possible solutions as a tree with each node representing an addition to the solution

Apple Division
- Subsets of a list can be generated recursively, with if i == n as a base case signifying all elements have been accounted for

Chessboard and Queens
- Permutations: reordering of a list of elements. If n ≤ 10, brute force is OK

Bovine Genomics
- Using sets can be helpful for comparing elements.
- Collections.disjoint(setA, setB)
- Set<T> mySet = new HashSet<>();

Why Did The Cow Cross the Road II
- Override equals and hashCode to use custom class in HashSet
- For example:
  '''@Override
	public boolean equals(Object obj) {
		return (obj instanceof Pair && cow1 == ((Pair)obj).cow1 && cow2 == ((Pair)obj).cow2);	
	}
	@Override
	public int hashCode() {
	    return 31 * cow1 + cow2;
	}'''
