# Bit operation
+ [L260](https://leetcode.com/problems/single-number-iii/) -- ^ and divide
+ [L477](https://leetcode.com/problems/total-hamming-distance/)

# Sort
+ [L406](https://leetcode.com/problems/queue-reconstruction-by-height/) -- like insertion sort

# Dynamic Programming
+ [L198](https://leetcode.com/problems/house-robber/) -- one dimension M(j)=max(M(j-1), M(j-2)+V[j])
+ [L357](https://leetcode.com/problems/count-numbers-with-unique-digits/) -- tricky, M(j)=M(j-1) * available_numbers
+ [L416](https://leetcode.com/problems/partition-equal-subset-sum/) -- M(i, j)=M(i-1,j)||M(i-1, j-V[i]), where i is ith num & j is value
+ [L337](https://leetcode.com/problems/house-robber-iii/) -- DP + Tree
+ [L474](https://leetcode.com/problems/ones-and-zeroes/) -- M(i, j) = max(M(i-a, j-b)+1, M(i, j))

# Greedy
+ [L406](https://leetcode.com/problems/queue-reconstruction-by-height/) -- like insertion sort
+ [L452](https://leetcode.com/problems/minimum-number-of-arrows-to-burst-balloons/)
+ [L475](https://leetcode.com/problems/heaters/)

# Backtracking
+ [L473](https://leetcode.com/problems/matchsticks-to-square/)

# Statistics
+ [L382](https://leetcode.com/problems/linked-list-random-node/) -- sampling, unknown size
+ [L398](https://leetcode.com/problems/random-pick-index/) -- sampling, unknown size

# Array
+ [L268](https://leetcode.com/problems/missing-number/) -- set negative to find, careful with corner case (=0)
+ [L119](https://leetcode.com/problems/pascals-triangle-ii/) -- save space

# Tree
+ [L94](https://leetcode.com/problems/binary-tree-inorder-traversal/) -- in order
+ [L145](https://leetcode.com/problems/binary-tree-postorder-traversal/) -- post order
+ [L337](https://leetcode.com/problems/house-robber-iii/) -- DP + Tree

# Stack
+ [L394](https://leetcode.com/problems/decode-string/) -- push by chuck

# Divide and Conquer
+ [L241](https://leetcode.com/problems/different-ways-to-add-parentheses/) -- calculate all possible values, divide by operators

# Number Process
+ [L9](https://leetcode.com/problems/palindrome-number/) -- reverse a number

# Heap
+ [L480](https://leetcode.com/problems/sliding-window-median/)
