# Bit operation
+ [L260](https://leetcode.com/problems/single-number-iii/) -- ^ and divide
+ [L477](https://leetcode.com/problems/total-hamming-distance/)
+ [L318](https://leetcode.com/problems/maximum-product-of-word-lengths/) -- use bit as hash set
+ [L421](https://leetcode.com/problems/maximum-xor-of-two-numbers-in-an-array/) -- narrowing down the candidates by looking MSB each round
+ [L201](https://leetcode.com/problems/bitwise-and-of-numbers-range/) -- consider the essense of AND operation
+ [L187](https://leetcode.com/problems/repeated-dna-sequences/) -- application of bit
+ [L397](https://leetcode.com/problems/integer-replacement) -- 3 is a special case

# Sort
+ [L406](https://leetcode.com/problems/queue-reconstruction-by-height/) -- like insertion sort

# Search
+ [L81](https://leetcode.com/problems/search-in-rotated-sorted-array-ii/) -- binary search in rotated array

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
+ [L279](https://leetcode.com/problems/perfect-squares/) -- calculate squares first then use it later
+ [L376](https://leetcode.com/problems/wiggle-subsequence/) -- carry value along the way, O(n)
+ [L375](https://leetcode.com/problems/guess-number-higher-or-lower-ii) -- like dropping egg problem
+ [L368](https://leetcode.com/problems/largest-divisible-subset/) -- sort first
+ [L131](https://leetcode.com/problems/palindrome-partitioning) -- M(i, j) = s[i] == s[j] && M(i+1, j-1)
+ [L139](https://leetcode.com/problems/word-break/)
+ [L221](https://leetcode.com/problems/maximal-square/) -- related with (i-1, j) (i, j-1) (i-1, j-1)

# Sub-structure
+ [L390](https://leetcode.com/problems/elimination-game) -- sub-problem L(n) = 2 R(n/2) = 2 (1 + n/2 - L(n/2))
+ [L60](https://leetcode.com/problems/permutation-sequence) -- complexity, need to count the number correctly

# Greedy
+ [L406](https://leetcode.com/problems/queue-reconstruction-by-height/) -- like insertion sort
+ [L452](https://leetcode.com/problems/minimum-number-of-arrows-to-burst-balloons/)
+ [L475](https://leetcode.com/problems/heaters/)
+ [L502](https://leetcode.com/problems/ipo/) -- two heap

# Backtracking
+ [L473](https://leetcode.com/problems/matchsticks-to-square/)
+ [L488](https://leetcode.com/problems/zuma-game/)
+ [L46](https://leetcode.com/problems/permutations/) -- list permutations, all distinct numbers
+ [L306](https://leetcode.com/problems/additive-number/) -- can improve performance by cutting off some cases

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
+ [L413](https://leetcode.com/problems/arithmetic-slices/) -- one pass, accumulate on the go
+ [L414](https://leetcode.com/problems/third-maximum-number) -- promote numbers, careful corner case
+ [L209](https://leetcode.com/problems/minimum-size-subarray-sum) -- moving window
+ [L229](https://leetcode.com/problems/majority-element-ii) -- majority problem
+ [L456](https://leetcode.com/problems/132-pattern) -- from right to left, use stack, find the max less than the current
+ [L15](https://leetcode.com/problems/3sum/)

# Matrix
+ [L498](https://leetcode.com/problems/diagonal-traverse/)

# String
+ [L205](https://leetcode.com/problems/isomorphic-strings/) -- need 2 maps to check
+ [L459](https://leetcode.com/problems/repeated-substring-pattern) -- variant of KMP
+ [L424](https://leetcode.com/problems/longest-repeating-character-replacement) -- moving window, how to make code short is subtle

# Tree
+ [L94](https://leetcode.com/problems/binary-tree-inorder-traversal/) -- in order
+ [L145](https://leetcode.com/problems/binary-tree-postorder-traversal/) -- post order
+ [L337](https://leetcode.com/problems/house-robber-iii/) -- DP + Tree
+ [L501](https://leetcode.com/problems/find-mode-in-binary-search-tree/) -- double traversal
+ [L508](https://leetcode.com/problems/most-frequent-subtree-sum/) -- double traversal
+ [L513](https://leetcode.com/problems/find-bottom-left-tree-value/)
+ [L437](https://leetcode.com/problems/path-sum-iii/) -- 2-sum like idea, count prefix sum
+ [L331](https://leetcode.com/problems/verify-preorder-serialization-of-a-binary-tree/) -- extra nodes, missing nodes?
+ [L109](https://leetcode.com/problems/convert-sorted-list-to-binary-search-tree/) -- use size
+ [L222](https://leetcode.com/problems/count-complete-tree-nodes) -- consider the heights of sub trees

# Graph
+ [L399](https://leetcode.com/problems/evaluate-division/) -- construct map and search
+ [L207](https://leetcode.com/problems/course-schedule/) -- application of DFS, loop detection
+ [L310](https://leetcode.com/problems/minimum-height-trees) -- find furthest nodes and choose middle ones
+ [L332](https://leetcode.com/problems/reconstruct-itinerary/) -- DFS, traverse edges

# Stack/Deque
+ [L394](https://leetcode.com/problems/decode-string/) -- push by chuck
+ [L341](https://leetcode.com/problems/flatten-nested-list-iterator/) -- stack to push iterators
+ [L496](https://leetcode.com/problems/next-greater-element-i/)
+ [L503](https://leetcode.com/problems/next-greater-element-ii/) -- pre-process
+ [L388](https://leetcode.com/problems/longest-absolute-file-path/)
+ [L385](https://leetcode.com/problems/mini-parser) -- parse char by char
+ [L227](https://leetcode.com/problems/basic-calculator-ii) -- use deque will be easier
+ [L402](https://leetcode.com/problems/remove-k-digits/) -- a lot of corner cases

# HashMap/TreeMap
+ [L274](https://leetcode.com/problems/h-index) -- how to do reversed index using an array (with assumption)
+ [L436](https://leetcode.com/problems/find-right-interval) -- use tree map

# Divide and Conquer
+ [L241](https://leetcode.com/problems/different-ways-to-add-parentheses/) -- calculate all possible values, divide by operators
+ [L493](https://leetcode.com/problems/reverse-pairs/) -- do it along with merge sort
+ [L395](https://leetcode.com/problems/longest-substring-with-at-least-k-repeating-characters/) -- not binary devide, so devide based on what?

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
+ [L441](https://leetcode.com/problems/arranging-coins/)
+ [L396](https://leetcode.com/problems/rotate-function)
+ [L50](https://leetcode.com/problems/powx-n)
+ [L69](https://leetcode.com/problems/sqrtx)
+ [L168](https://leetcode.com/problems/excel-sheet-column-title/)
+ [L365](https://leetcode.com/problems/water-and-jug-problem) -- greatest common divisor
+ [L43](https://leetcode.com/problems/multiply-strings/) -- need to know the other way to calculate mutiply

# Pure Interesting
+ [L423](https://leetcode.com/problems/reconstruct-original-digits-from-english/) -- different chars can indicate different numbers
+ [L386](https://leetcode.com/problems/lexicographical-numbers/) -- do it in order