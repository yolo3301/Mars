public class Solution {
    public int thirdMax(int[] nums) {
        Integer m1 = null, m2 = null, m3 = null;
        for (int i : nums) {
            if (m1 == null || i >= m1) {
                if (m1 != null && i > m1) {
                    m3 = m2;
                    m2 = m1;
                }
                m1 = i;
            } else if (m2 == null || i >= m2) {
                if (m2 != null && i > m2) {
                    m3 = m2;
                }
                m2 = i;
            } else if (m3 == null || i >= m3) {
                m3 = i;
            }
        }

        if (m3 == null) return m1.intValue();

        return m3.intValue();
    }
}