public class Solution {
    public int getMaxRepetitions(String s1, int n1, String s2, int n2) {
        if (!ableToObtain(s1, s2)) return 0; // check if [s1. ∞] obtains s2
        int cnt=0, k=-1;
        String s=s1;
        StringBuilder remainBuilder; // record `remain string`
        ArrayList<String> stringList=new ArrayList<>(); // record all the `remain string`
        ArrayList<Integer> countList=new ArrayList<>(); // record matching count from start to the current remain string
        stringList.add(""); // record empty string
        countList.add(0);
        for (int i=0;i<=n1;i++) {
            remainBuilder=new StringBuilder();
            cnt+=getRemain(s, s2, remainBuilder); // get the next remain string, returns the count of matching
            String remain=remainBuilder.toString();
            if ((k=stringList.indexOf(remain))!=-1) break; // if there is a loop, break
            stringList.add(remain); // record the remain string into arraylist
            countList.add(cnt);
            s=remain+s1; // append s1 to make a new string
        }
        // here, k is the beginning of the loop
        if (k==-1) return cnt/n2; // if there is no loop
        int countOfLoop=cnt-countList.get(k), loopLength=stringList.size()-k; // get matching count in the loop, and loop length
        cnt=countList.get(k);
        n1-=k;
        cnt+=countOfLoop*(n1/loopLength);
        n1%=loopLength;
        cnt+=countList.get(k+n1)-countList.get(k);
        return cnt/n2;
    }

    // check if [s1. ∞] obtains s2
    private boolean ableToObtain(String s1, String s2) {
        boolean[] cnt=new boolean[26];
        for (char c: s1.toCharArray()) cnt[c-'a']=true;
        for (char c: s2.toCharArray()) {
            if (!cnt[c-'a']) return false;
        }
        return true;
    }

    // get remain string after s1 obtains s2, return the matching count
    private int getRemain(String s1, String s2, StringBuilder remain) {
        int cnt=0, lastMatch=-1, p2=0;
        for (int p1=0;p1<s1.length();p1++) {
            if (s1.charAt(p1)==s2.charAt(p2)) {
                if (++p2==s2.length()) {
                    p2=0;
                    cnt++;
                    lastMatch=p1;
                }
            }
        }
        remain.append(s1.substring(lastMatch+1));
        return cnt;
    }
}
