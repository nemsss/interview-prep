package others;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cenumah on 2020-01-12
 */
public class BinaryWildCard {

    public static void main(String[] args) {

        System.out.println(generate("010?00?"));
        System.out.println(generate("???"));
        System.out.println(generate("00"));
    }

    private static List<String> generate(String s) {
        List<String> result = new ArrayList<>();
        generate(s, 0, new StringBuilder(), result);
        return result;
    }

    private static void generate(String s, int idx, StringBuilder sb, List<String> result) {

        if(idx == s.length()) {
            result.add(sb.toString());
            return;
        }

        if(s.charAt(idx) != '?') {
            sb.append(s.charAt(idx));
            generate(s, idx+1, sb, result);
        } else {
            sb.append('0');
            int len = sb.length();
            generate(s, idx+1, sb, result);

            sb.setLength(len-1);
            sb.append('1');
            generate(s, idx+1, sb, result);
        }
    }
}
