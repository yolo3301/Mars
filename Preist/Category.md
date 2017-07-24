# Bit operation
+ [L260](https://leetcode.com/problems/single-number-iii/) -- ^ and divide
+ [L477](https://leetcode.com/problems/total-hamming-distance/)
+ [L318](https://leetcode.com/problems/maximum-product-of-word-lengths/) -- use bit as hash set
+ [L421](https://leetcode.com/problems/maximum-xor-of-two-numbers-in-an-array/) -- narrowing down the candidates by looking MSB each round
+ [L201](https://leetcode.com/problems/bitwise-and-of-numbers-range/) -- consider the essense of AND operation
+ [L187](https://leetcode.com/problems/repeated-dna-sequences/) -- application of bit
+ [L397](https://leetcode.com/problems/integer-replacement) -- 3 is a special case
+ [L411](https://leetcode.com/problems/minimum-unique-word-abbreviation)

# Sort
+ [L406](https://leetcode.com/problems/queue-reconstruction-by-height/) -- like insertion sort
+ [L324](https://leetcode.com/problems/wiggle-sort-ii/) -- virtual index, 3-way partition
+ [L164](https://leetcode.com/problems/maximum-gap) -- bucket sort
+ [L253](https://leetcode.com/problems/meeting-rooms-ii)
+ [L252](https://leetcode.com/problems/meeting-rooms)

# Search
+ [L81](https://leetcode.com/problems/search-in-rotated-sorted-array-ii/) -- binary search in rotated array
+ [L410](https://leetcode.com/problems/split-array-largest-sum) -- binary search which value space? max and sum
+ [L4](https://leetcode.com/problems/median-of-two-sorted-arrays)
+ [L302](https://leetcode.com/problems/smallest-rectangle-enclosing-black-pixels)
+ [L644](https://leetcode.com/problems/maximum-average-subarray-ii/) -- binary search value space, max and min

# Dynamic Programming
+ [L418](https://leetcode.com/problems/sentence-screen-fitting/) -- pre cal next index and reps
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
+ [L464](https://leetcode.com/problems/can-i-win/) -- if other part lose for sure, then I win for sure, memo
+ [L312](https://leetcode.com/problems/burst-balloons) -- O(n^3), think in the reverse order, which one burst last
+ [L115](https://leetcode.com/problems/distinct-subsequences) - M(i,j) = M(i-1, j) (+ M(i-1, j-1))
+ [L403](https://leetcode.com/problems/frog-jump) -- unusual DP
+ [L44](https://leetcode.com/problems/wildcard-matching) -- initialization
+ [L474](https://leetcode.com/problems/ones-and-zeroes) -- 2d pack problem but 2d array is sufficient, use previous results
+ [L494](https://leetcode.com/problems/target-sum/) -- a variant, 2*S(P) = target + S(P) + S(N)
+ [L514](https://leetcode.com/problems/freedom-trail/) -- move from multiple previous index
+ [L552](https://leetcode.com/problems/student-attendance-record-ii) -- don't think about A first
+ [L542](https://leetcode.com/problems/01-matrix/)
+ [L296](https://leetcode.com/problems/best-meeting-point)
+ [L361](https://leetcode.com/problems/bomb-enemy/) -- upper left, then bottom right
+ [L161](https://leetcode.com/problems/one-edit-distance/)
+ [L265](https://leetcode.com/problems/paint-house-ii/) -- keep min and 2nd min
+ [L471](https://leetcode.com/problems/encode-string-with-shortest-length)
+ [L294](https://leetcode.com/problems/flip-game-ii/)
+ [L276](https://leetcode.com/problems/paint-fence)
+ [L583](https://leetcode.com/problems/delete-operation-for-two-strings) -- longest common subseq
+ [L562](https://leetcode.com/problems/longest-line-of-consecutive-one-in-matrix)
+ [L568](https://leetcode.com/problems/maximum-vacation-days)
+ [L576](https://leetcode.com/problems/out-of-boundary-paths/)
+ [L256](https://leetcode.com/problems/paint-house)
+ [L600](https://leetcode.com/problems/non-negative-integers-without-consecutive-ones)
+ [L629](https://leetcode.com/problems/k-inverse-pairs-array/)
+ [L634](https://leetcode.com/problems/find-the-derangement-of-an-array/)
+ [L638](https://leetcode.com/problems/shopping-offers/)
+ [L639](https://leetcode.com/problems/decode-ways-ii/)

# Sub-structure
+ [L390](https://leetcode.com/problems/elimination-game) -- sub-problem L(n) = 2 R(n/2) = 2 (1 + n/2 - L(n/2))
+ [L60](https://leetcode.com/problems/permutation-sequence) -- complexity, need to count the number correctly

# Greedy
+ [L406](https://leetcode.com/problems/queue-reconstruction-by-height/) -- like insertion sort
+ [L452](https://leetcode.com/problems/minimum-number-of-arrows-to-burst-balloons/)
+ [L475](https://leetcode.com/problems/heaters/)
+ [L502](https://leetcode.com/problems/ipo/) -- two heap
+ [L330](https://leetcode.com/problems/patching-array) -- extend missing board, some sub structure, if we can have 1-x, how to extend
+ [L358](https://leetcode.com/problems/rearrange-string-k-distance-apart)
+ [L605](https://leetcode.com/problems/can-place-flowers/)
+ [L621](https://leetcode.com/problems/task-scheduler)
+ [L630](https://leetcode.com/problems/course-schedule-iii)

# Backtracking
+ [L473](https://leetcode.com/problems/matchsticks-to-square/)
+ [L488](https://leetcode.com/problems/zuma-game/)
+ [L46](https://leetcode.com/problems/permutations/) -- list permutations, all distinct numbers
+ [L306](https://leetcode.com/problems/additive-number/) -- can improve performance by cutting off some cases
+ [L301](https://leetcode.com/problems/remove-invalid-parentheses) -- need to do it in reverse order again
+ [L282](https://leetcode.com/problems/expression-add-operators/) -- handle * is the key, can carry along the path
+ [L473](https://leetcode.com/problems/matchsticks-to-square) -- because the size is small
+ [L491](https://leetcode.com/problems/increasing-subsequences/) -- can also be solved iteratively
+ [L488](https://leetcode.com/problems/zuma-game) -- hard BT, think about to remove one kind a time
+ [L553](https://leetcode.com/problems/optimal-division) -- divide by /
+ [L247](https://leetcode.com/problems/strobogrammatic-number-ii)
+ [L320](https://leetcode.com/problems/generalized-abbreviation)
+ [L411](https://leetcode.com/problems/minimum-unique-word-abbreviation)
+ [L544](https://leetcode.com/problems/output-contest-matches)
+ [L254](https://leetcode.com/problems/factor-combinations)
+ [L140](https://leetcode.com/problems/word-break-ii)
+ [L248](https://leetcode.com/problems/strobogrammatic-number-iii)
+ [L267](https://leetcode.com/problems/palindrome-permutation-ii/)
+ [L291](https://leetcode.com/problems/word-pattern-ii)

# Statistics
+ [L382](https://leetcode.com/problems/linked-list-random-node/) -- sampling, unknown size
+ [L398](https://leetcode.com/problems/random-pick-index/) -- sampling, unknown size
+ [L381](https://leetcode.com/problems/insert-delete-getrandom-o1-duplicates-allowed) -- use list and index

# Linked list
+ [L369](https://leetcode.com/problems/plus-one-linked-list/)

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
+ [L54](https://leetcode.com/problems/spiral-matrix/) -- corner cases
+ [L128](https://leetcode.com/problems/longest-consecutive-sequence) -- use of hash map, extend edges
+ [L42](https://leetcode.com/problems/trapping-rain-water) -- trapping water
+ [L45](https://leetcode.com/problems/jump-game-ii) -- keep a previous boarder and the current boarder
+ [L41](https://leetcode.com/problems/first-missing-positive) -- partition first
+ [L321](https://leetcode.com/problems/create-maximum-number/) -- choose i & k-i from both array, how to cal combine max?
+ [L163](https://leetcode.com/problems/missing-ranges)
+ [L259](https://leetcode.com/problems/3sum-smaller/)
+ [L325](https://leetcode.com/problems/maximum-size-subarray-sum-equals-k)
+ [L158](https://leetcode.com/problems/read-n-characters-given-read4-ii-call-multiple-times)
+ [L157](https://leetcode.com/problems/read-n-characters-given-read4)
+ [L581](https://leetcode.com/problems/shortest-unsorted-continuous-subarray)
+ [L560](https://leetcode.com/problems/subarray-sum-equals-k/)
+ [L565](https://leetcode.com/problems/array-nesting/)
+ [L370](https://leetcode.com/problems/range-addition)
+ [L487](https://leetcode.com/problems/max-consecutive-ones-ii)
+ [L548](https://leetcode.com/problems/split-array-with-equal-sum)
+ [L243](https://leetcode.com/problems/shortest-word-distance)
+ [L244](https://leetcode.com/problems/shortest-word-distance-ii)
+ [L245](https://leetcode.com/problems/shortest-word-distance-iii)
+ [L599](https://leetcode.com/problems/minimum-index-sum-of-two-lists)
+ [L611](https://leetcode.com/problems/valid-triangle-number/) -- direction is important
+ [L624](https://leetcode.com/problems/maximum-distance-in-arrays)
+ [L628](https://leetcode.com/problems/maximum-product-of-three-numbers)
+ [L643](https://leetcode.com/problems/maximum-average-subarray-i)
+ [L645](https://leetcode.com/problems/set-mismatch)

# Matrix
+ [L498](https://leetcode.com/problems/diagonal-traverse/)
+ [L311](https://leetcode.com/problems/sparse-matrix-multiplication)
+ [L422](https://leetcode.com/problems/valid-word-square)
+ [L348](https://leetcode.com/problems/design-tic-tac-toe)
+ [L566](https://leetcode.com/problems/reshape-the-matrix/)
+ [L531](https://leetcode.com/problems/lonely-pixel-i/)
+ [L533](https://leetcode.com/problems/lonely-pixel-ii)
+ [L573](https://leetcode.com/problems/squirrel-simulation/)

# String
+ [L205](https://leetcode.com/problems/isomorphic-strings/) -- need 2 maps to check
+ [L459](https://leetcode.com/problems/repeated-substring-pattern) -- variant of KMP
+ [L424](https://leetcode.com/problems/longest-repeating-character-replacement) -- moving window, how to make code short is subtle
+ [L224](https://leetcode.com/problems/basic-calculator/) -- recursive
+ [L466](https://leetcode.com/problems/count-the-repetitions) -- remain & loop
+ [L76](https://leetcode.com/problems/minimum-window-substring/) -- moving window
+ [L214](https://leetcode.com/problems/shortest-palindrome) -- use KMP, think about how to it's used
+ [L30](https://leetcode.com/problems/substring-with-concatenation-of-all-words) -- moving window
+ [L68](https://leetcode.com/problems/text-justification/)
+ [L65](https://leetcode.com/problems/valid-number/) -- iterate one by one, record what have seen
+ [L495](https://leetcode.com/problems/repeated-substring-pattern/) -- think about what's the pattern of such strings
+ [L340](https://leetcode.com/problems/longest-substring-with-at-most-k-distinct-characters) -- sliding window
+ [L271](https://leetcode.com/problems/encode-and-decode-strings)
+ [L159](https://leetcode.com/problems/longest-substring-with-at-most-two-distinct-characters) -- sliding window
+ [L484](https://leetcode.com/problems/find-permutation)
+ [L408](https://leetcode.com/problems/valid-word-abbreviation/)
+ [L567](https://leetcode.com/problems/permutation-in-string)
+ [L527](https://leetcode.com/problems/word-abbreviation)
+ [L555](https://leetcode.com/problems/split-concatenated-strings) -- brute force
+ [L186](https://leetcode.com/problems/reverse-words-in-a-string-ii/)
+ [L591](https://leetcode.com/problems/tag-validator) -- state machine
+ [L604](https://leetcode.com/problems/design-compressed-string-iterator)
+ [L609](https://leetcode.com/problems/find-duplicate-file-in-system)
+ [L616](https://leetcode.com/problems/add-bold-tag-in-string/)
+ [L640](https://leetcode.com/problems/solve-the-equation/)

# Tree
+ [L298](https://leetcode.com/problems/binary-tree-longest-consecutive-sequence)
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
+ [L307](https://leetcode.com/problems/range-sum-query-mutable) -- binary tree as a segment tree
+ [L117](https://leetcode.com/problems/populating-next-right-pointers-in-each-node-ii/) -- O(1) space to populate next pointer, use last level
+ [L99](https://leetcode.com/problems/recover-binary-search-tree) -- morris traversal
+ [L449](https://leetcode.com/problems/serialize-and-deserialize-bst/) -- use min and max
+ [L501](https://leetcode.com/problems/find-mode-in-binary-search-tree/) -- double traversal
+ [L314](https://leetcode.com/problems/binary-tree-vertical-order-traversal/)
+ [L572](https://leetcode.com/problems/subtree-of-another-tree) -- serialization
+ [L549](https://leetcode.com/problems/binary-tree-longest-consecutive-sequence-ii)
+ [L545](https://leetcode.com/problems/boundary-of-binary-tree/)
+ [L582](https://leetcode.com/problems/kill-process)
+ [L156](https://leetcode.com/problems/binary-tree-upside-down)
+ [L250](https://leetcode.com/problems/count-univalue-subtrees)
+ [L366](https://leetcode.com/problems/find-leaves-of-binary-tree)
+ [L606](https://leetcode.com/problems/construct-string-from-binary-tree)
+ [L617](https://leetcode.com/problems/merge-two-binary-trees)
+ [L623](https://leetcode.com/problems/add-one-row-to-tree)

# BST
+ [L436](https://leetcode.com/problems/find-right-interval) -- use tree map
+ [L220](https://leetcode.com/problems/contains-duplicate-iii/) -- better solution with bucket idea
+ [L218](https://leetcode.com/problems/the-skyline-problem) -- sort, left have to come before right, use BST to find max height
+ [L315](https://leetcode.com/problems/count-of-smaller-numbers-after-self/) -- use a modified BST, stack won't work
+ [L363](https://leetcode.com/problems/max-sum-of-sub-matrix-no-larger-than-k/) -- can be applied to 1D or 2D
+ [L327](https://leetcode.com/problems/count-of-range-sum) -- a modified BST will be more efficient
+ [L285](https://leetcode.com/problems/inorder-successor-in-bst)
+ [L270](https://leetcode.com/problems/closest-binary-search-tree-value)
+ [L272](https://leetcode.com/problems/closest-binary-search-tree-value-ii)
+ [L255](https://leetcode.com/problems/verify-preorder-sequence-in-binary-search-tree)
+ [L536](https://leetcode.com/problems/construct-binary-tree-from-string)
+ [L333](https://leetcode.com/problems/largest-bst-subtree/)
+ [L632](https://leetcode.com/problems/smallest-range/)
+ [L635](https://leetcode.com/problems/design-log-storage-system/)

# BIT (binary indexed tree)
+ [L307](https://leetcode.com/problems/range-sum-query-mutable)
+ [L308](https://leetcode.com/problems/range-sum-query-2d-mutable)

# Graph
+ [L399](https://leetcode.com/problems/evaluate-division/) -- construct map and search
+ [L207](https://leetcode.com/problems/course-schedule/) -- application of DFS, loop detection
+ [L310](https://leetcode.com/problems/minimum-height-trees) -- find furthest nodes and choose middle ones
+ [L332](https://leetcode.com/problems/reconstruct-itinerary/) -- DFS, traverse edges
+ [L210](https://leetcode.com/problems/course-schedule-ii/) -- topology sort
+ [L130](https://leetcode.com/problems/surrounded-regions) -- be careful with BFS
+ [L126](https://leetcode.com/problems/word-ladder-ii) -- a lot of corner cases
+ [L317](https://leetcode.com/problems/shortest-distance-from-all-buildings) -- BFS
+ [L351](https://leetcode.com/problems/android-unlock-patterns) -- DFS
+ [L305](https://leetcode.com/problems/number-of-islands-ii) -- union find
+ [L286](https://leetcode.com/problems/walls-and-gates) -- BFS
+ [L277](https://leetcode.com/problems/find-the-celebrity)
+ [L505](https://leetcode.com/problems/the-maze-ii/) -- shortest path
+ [L269](https://leetcode.com/problems/alien-dictionary)
+ [L261](https://leetcode.com/problems/graph-valid-tree) -- union find
+ [L490](https://leetcode.com/problems/the-maze)
+ [L444](https://leetcode.com/problems/sequence-reconstruction) -- topology sort
+ [L323](https://leetcode.com/problems/number-of-connected-components-in-an-undirected-graph)
+ [L364](https://leetcode.com/problems/nested-list-weight-sum-ii) -- level order traverse, unweighted added multiple times
+ [L499](https://leetcode.com/problems/the-maze-iii)

# Stack/Deque
+ [L394](https://leetcode.com/problems/decode-string/) -- push by chuck
+ [L341](https://leetcode.com/problems/flatten-nested-list-iterator/) -- stack to push iterators
+ [L496](https://leetcode.com/problems/next-greater-element-i/)
+ [L503](https://leetcode.com/problems/next-greater-element-ii/) -- pre-process
+ [L388](https://leetcode.com/problems/longest-absolute-file-path/)
+ [L385](https://leetcode.com/problems/mini-parser) -- parse char by char
+ [L227](https://leetcode.com/problems/basic-calculator-ii) -- use deque will be easier
+ [L402](https://leetcode.com/problems/remove-k-digits/) -- a lot of corner cases
+ [L316](https://leetcode.com/problems/remove-duplicate-letters/) -- when meet a smaller number, remove bigger removables
+ [L85](https://leetcode.com/problems/maximal-rectangle) -- need to use the stack in the right way
+ [L32](https://leetcode.com/problems/longest-valid-parentheses/)
+ [L346](https://leetcode.com/problems/moving-average-from-data-stream)
+ [L465](https://leetcode.com/problems/optimal-account-balancing) -- DFS
+ [L353](https://leetcode.com/problems/design-snake-game/)
+ [L439](https://leetcode.com/problems/ternary-expression-parser)
+ [L339](https://leetcode.com/problems/nested-list-weight-sum)
+ [L636](https://leetcode.com/problems/exclusive-time-of-functions)

# HashMap
+ [L128](https://leetcode.com/problems/longest-consecutive-sequence) -- use of hash map, extend edges
+ [L274](https://leetcode.com/problems/h-index) -- how to do reversed index using an array (with assumption)
+ [L336](https://leetcode.com/problems/palindrome-pairs) -- better than O(n^2) using hashmap
+ [L446](https://leetcode.com/problems/arithmetic-slices-ii-subsequence)
+ [L149](https://leetcode.com/problems/max-points-on-a-line/) -- count overlap points
+ [L288](https://leetcode.com/problems/unique-word-abbreviation)
+ [L249](https://leetcode.com/problems/group-shifted-strings)
+ [L266](https://leetcode.com/problems/palindrome-permutation)
+ [L356](https://leetcode.com/problems/line-reflection)
+ [L594](https://leetcode.com/problems/longest-harmonious-subsequence)

# Divide and Conquer
+ [L241](https://leetcode.com/problems/different-ways-to-add-parentheses/) -- calculate all possible values, divide by operators
+ [L493](https://leetcode.com/problems/reverse-pairs/) -- do it along with merge sort
+ [L395](https://leetcode.com/problems/longest-substring-with-at-least-k-repeating-characters/) -- not binary devide, so devide based on what?
+ [L493](https://leetcode.com/problems/reverse-pairs/) -- why add on the run won't work? 

# Number Process
+ [L9](https://leetcode.com/problems/palindrome-number/) -- reverse a number

# Heap
+ [L480](https://leetcode.com/problems/sliding-window-median/)
+ [L407](https://leetcode.com/problems/trapping-rain-water-ii) -- why is it different from 1D trapping water? why heap is useful?
+ [L295](https://leetcode.com/problems/find-median-from-data-stream) -- careful when resizing
+ [L502](https://leetcode.com/problems/ipo/) -- 2 heap

# Trie
+ [L472](https://leetcode.com/problems/concatenated-words/) -- similar to word break
+ [L212](https://leetcode.com/problems/word-search-ii/)
+ [L425](https://leetcode.com/problems/word-squares)
+ [L642](https://leetcode.com/problems/design-search-autocomplete-system)

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
+ [L360](https://leetcode.com/problems/sort-transformed-array)
+ [L593](https://leetcode.com/problems/valid-square)
+ [L335](https://leetcode.com/problems/self-crossing)
+ [L507](https://leetcode.com/problems/perfect-number)
+ [L592](https://leetcode.com/problems/fraction-addition-and-subtraction)
+ [L625](https://leetcode.com/problems/minimum-factorization)
+ [L633](https://leetcode.com/problems/sum-of-square-numbers/)

# Data Structure Design
+ [L432](https://leetcode.com/problems/all-oone-data-structure/) -- use hashmap and linked list
+ [L460](https://leetcode.com/problems/lfu-cache/) -- use hashmap and linked list
+ [L362](https://leetcode.com/problems/design-hit-counter)
+ [L359](https://leetcode.com/problems/logger-rate-limiter)
+ [L379](https://leetcode.com/problems/design-phone-directory)
+ [L588](https://leetcode.com/problems/design-in-memory-file-system)

# Special Data Structure
+ [L57](https://leetcode.com/problems/insert-interval)

# Pure Interesting
+ [L423](https://leetcode.com/problems/reconstruct-original-digits-from-english/) -- different chars can indicate different numbers
+ [L386](https://leetcode.com/problems/lexicographical-numbers/) -- do it in order
+ [L287](https://leetcode.com/problems/find-the-duplicate-number) -- looks like a array problem, but it's a linked list problem
+ [L233](https://leetcode.com/problems/number-of-digit-one) -- count by ten, hundred, thousand...
+ [L391](https://leetcode.com/problems/perfect-rectangle) -- 1. area size, 2. only 4 corner left
+ [L440](https://leetcode.com/problems/k-th-smallest-in-lexicographical-order) -- calculate steps
+ [L273](https://leetcode.com/problems/integer-to-english-words/) -- trim answer
+ [L453](https://leetcode.com/problems/minimum-moves-to-equal-array-elements) -- reverse idea
+ [L462](https://leetcode.com/problems/minimum-moves-to-equal-array-elements-ii/) -- meet in the middle, why it works?

# Iterator
+ [L281](https://leetcode.com/problems/zigzag-iterator)
+ [L251](https://leetcode.com/problems/flatten-2d-vector/)