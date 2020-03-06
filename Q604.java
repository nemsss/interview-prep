package leetcode.easy;

/**
 * Created by cenumah on 2020-01-11
 */
public class Q604 {

    public static void main(String[] args) {

        StringIterator si = new StringIterator("s12o1l1u1t1i1o1n1");
        System.out.println(si.hasNext());
        System.out.println(si.next());
        System.out.println(si.next());
        System.out.println(si.next());
        System.out.println(si.next());
        System.out.println(si.next());
        System.out.println(si.next());
        System.out.println(si.next());
        System.out.println(si.next());
        System.out.println(si.next());
        System.out.println(si.next());
        System.out.println(si.next());
        System.out.println(si.next());
        System.out.println(si.next());
        System.out.println(si.hasNext());
    }

    static class StringIterator {

        int idx;
        int charIdx;
        int currCount;
        String s;

        public StringIterator(String s) {
            this.s = s;
            this.idx = 0;
            this.charIdx = 0;
            this.currCount = getNextCount();
        }

        public char next() {
            if(hasNext()){
                if(currCount == 0){
                    charIdx = idx;
                    currCount = getNextCount();
                }
                char c = s.charAt(this.charIdx);
                this.currCount--;
                return c;
            }
            return ' ';
        }

        private int getNextCount() {
            StringBuilder sb = new StringBuilder();

            int idx = this.idx+1;
            while (idx<s.length() && Character.isDigit(s.charAt(idx))) {
                sb.append(s.charAt(idx));
                idx++;
            }

            this.idx = idx;
            return Integer.parseInt(sb.toString());
        }

        public boolean hasNext() {
            return currCount > 0 || idx < s.length();
        }
    }
}
