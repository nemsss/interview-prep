package friends;

import java.util.ArrayList;

/**
 * Created by cenumah on 2019-12-22
 */
public class IPV4Addresses {

    static public void main( String args[] ) {
        System.out.println(generateIPAddrs("1001"));
        System.out.println(generateIPAddrs("100"));
        System.out.println(generateIPAddrs(""));
        System.out.println(generateIPAddrs("1010"));
        System.out.println(generateIPAddrs("25525511132"));
        System.out.println(generateIPAddrs("225125211135"));
    }

    public static ArrayList<String> generateIPAddrs(String s) {
        ArrayList<String> result = new ArrayList<>();
        helper(1, 0, "", s, result);
        return result;
    }

    private static void helper(int currBlock, int pos, String prefix, String given, ArrayList<String> result) {

        if(given == null || given.length()==0) {
            return;
        }

        if(prefix.length() == given.length()+3) {
            result.add(prefix);
            return;
        }

        if(currBlock > 4) {
            return;
        }

        //1 digit, 2 digit, 3 digit

        prefix = "".equals(prefix) ? "" : prefix.concat(".");
        int charsLeft = given.length() - pos;
        int maxSuffix = 12 - (3*currBlock);

        if(charsLeft -1 <= maxSuffix && pos+1 <= given.length()) {
            helper(currBlock+1, pos+1, prefix + given.charAt(pos), given, result);
        }

        if(charsLeft -2 <= maxSuffix && pos+2 <= given.length()) {
            helper(currBlock+1, pos+2, prefix + given.substring(pos, pos+2), given, result);
        }

        if(charsLeft -3 <= maxSuffix && pos+3 <= given.length() && Integer.parseInt(given.substring(pos,pos+3)) < 256) {
            helper(currBlock+1, pos+3, prefix + given.substring(pos, pos+3), given, result);
        }

    }
}
