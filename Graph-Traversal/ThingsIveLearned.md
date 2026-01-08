Birthday Party
- If a graph is small enough, it can be represented as a boolean[n][n] where [a][b] and[b][a] are set to true if there is an edge between a and b

Rank
- Trying to detect cycles. Since the graph is small, we can run a DFS from each node and increment the answer PER CYCLIC NODE. The other nodes in the cycle will be detected separately.
