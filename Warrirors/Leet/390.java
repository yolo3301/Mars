// The sub problem is very subtle!!!
/*
Define L(N) is starting deleteing from left in the first round (L, R, L, R...)
Define R(N) is starting deleteing from right in the first round (R, L, R, L...)
Because they are a "mirroring" process, evetually they will end up in 2 numbers that are "mirror" for each other.
As a result, L(N) + R(N) = N + 1 (e.g. 1 & N, 2 & N-1, ...)
So we get R(N) = N + 1 - L(N) => R(N/2) = N/2 + 1 - L(N/2)

On the other side, for L(N), it will always leave EVEN numbers, so for the left ones, we can always divide by 2
So that we got L(N) = 2 * R(N/2) => L(N) = 2 * (N/2 + 1 - L(N/2))
*/

public class Solution {
    public int lastRemaining(int n) {
        return n == 1 ? 1 : 2 * (1 + n / 2 - lastRemaining(n / 2));
    }
}
