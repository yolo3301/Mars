# Bit operation
+ [L260](https://leetcode.com/problems/single-number-iii/) -- ^ and divide
+ [L477](https://leetcode.com/problems/total-hamming-distance/)
+ [L318](https://leetcode.com/problems/maximum-product-of-word-lengths/) -- use bit as hash set

# Sort
+ [L406](https://leetcode.com/problems/queue-reconstruction-by-height/) -- like insertion sort

# Dynamic Programming
+ [L198](https://leetcode.com/problems/house-robber/) -- one dimension M(j)=max(M(j-1), M(j-2)+V[j])
+ [L357](https://leetcode.com/problems/count-numbers-with-unique-digits/) -- tricky, M(j)=M(j-1) * available_numbers
+ [L416](https://leetcode.com/problems/partition-equal-subset-sum/) -- M(i, j)=M(i-1,j)||M(i-1, j-V[i]), where i is ith num & j is value
+ [L337](https://leetcode.com/problems/house-robber-iii/) -- DP + Tree
+ [L474](https://leetcode.com/problems/ones-and-zeroes/) -- M(i, j) = max(M(i-a, j-b)+1, M(i, j))
+ [L188](https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iv/) -- M(i, j) = max(M(i, j-1), P[j] + max(M(i-1, k) - P[k]))
+ [L309](https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/) -- sell or no sell on a day
+ [L53](https://leetcode.com/problems/maximum-subarray/)
+ [L516](https://leetcode.com/problems/longest-palindromic-subsequence)

# Greedy
+ [L406](https://leetcode.com/problems/queue-reconstruction-by-height/) -- like insertion sort
+ [L452](https://leetcode.com/problems/minimum-number-of-arrows-to-burst-balloons/)
+ [L475](https://leetcode.com/problems/heaters/)
+ [L502](https://leetcode.com/problems/ipo/) -- two heap

# Backtracking
+ [L473](https://leetcode.com/problems/matchsticks-to-square/)
+ [L488](https://leetcode.com/problems/zuma-game/)
+ [L46](https://leetcode.com/problems/permutations/) -- list permutations, all distinct numbers

# Statistics
+ [L382](https://leetcode.com/problems/linked-list-random-node/) -- sampling, unknown size
+ [L398](https://leetcode.com/problems/random-pick-index/) -- sampling, unknown size

# Array
+ [L268](https://leetcode.com/problems/missing-number/) -- set negative to find, careful with corner case (=0)
+ [L119](https://leetcode.com/problems/pascals-triangle-ii/) -- save space
+ [L334](https://leetcode.com/problems/increasing-triplet-subsequence/) -- keep record of 2 smallest numbers
+ [L219](https://leetcode.com/problems/contains-duplicate-ii/) -- keep a set of K-sized window
+ [L300](https://leetcode.com/problems/longest-increasing-subsequence/) -- LIS problem
+ [L354](https://leetcode.com/problems/russian-doll-envelopes/) -- transform of LIS problem
+ [L264](https://leetcode.com/problems/ugly-number-ii/) -- ugly number 2
+ [L313](https://leetcode.com/problems/super-ugly-number/) -- super ugly number

# Matrix
+ [L498](https://leetcode.com/problems/diagonal-traverse/)

# String
+ [L205](https://leetcode.com/problems/isomorphic-strings/) -- need 2 maps to check
+ [L459](https://leetcode.com/problems/repeated-substring-pattern) -- variant of KMP

# Tree
+ [L94](https://leetcode.com/problems/binary-tree-inorder-traversal/) -- in order
+ [L145](https://leetcode.com/problems/binary-tree-postorder-traversal/) -- post order
+ [L337](https://leetcode.com/problems/house-robber-iii/) -- DP + Tree
+ [L501](https://leetcode.com/problems/find-mode-in-binary-search-tree/) -- double traversal
+ [L508](https://leetcode.com/problems/most-frequent-subtree-sum/) -- double traversal
+ [L513](https://leetcode.com/problems/find-bottom-left-tree-value/)

# Stack
+ [L394](https://leetcode.com/problems/decode-string/) -- push by chuck
+ [L341](https://leetcode.com/problems/flatten-nested-list-iterator/) -- stack to push iterators
+ [L496](https://leetcode.com/problems/next-greater-element-i/)
+ [L503](https://leetcode.com/problems/next-greater-element-ii/) -- pre-process

# Divide and Conquer
+ [L241](https://leetcode.com/problems/different-ways-to-add-parentheses/) -- calculate all possible values, divide by operators
+ [L493](https://leetcode.com/problems/reverse-pairs/) -- do it along with merge sort

# Number Process
+ [L9](https://leetcode.com/problems/palindrome-number/) -- reverse a number

# Heap
+ [L480](https://leetcode.com/problems/sliding-window-median/)

# Trie
+ [L472](https://leetcode.com/problems/concatenated-words/) -- similar to word break

# Math
+ [L492](https://leetcode.com/problems/construct-the-rectangle/)
+ [L483](https://leetcode.com/problems/smallest-good-base/) -- binary search
+ [L62](https://leetcode.com/problems/unique-paths/)

# Pure Interesting
+ [L423](https://leetcode.com/problems/reconstruct-original-digits-from-english/) -- different chars can indicate different numbers
+ [L386](https://leetcode.com/problems/lexicographical-numbers/) -- do it in order