package others;

import java.util.Arrays;

/**
 * Created by cenumah on 2019-11-29
 */
public class ChatRoomTrim {

    public static void main(String[] args) {
        System.out.println(new ChatRoomTrim().solution("codility we test coders", 14));
        System.out.println(new ChatRoomTrim().solution("i am a girl", "i am a girl".length()));
    }

    public String solution(String message, int k) {
        // write your code in Java SE 8
        if(k == 0 || message == null || message.equals("")) {
            return "";
        }

        //I am a girl, 6
        int count = 0;
        int idx = -1;
        String[] words = message.split(" ");
        for(int i=0; i<words.length; i++) {
            String word = words[i];
            if(count + word.length() > k) {
                break;
            }

            count+= word.length() + 1; //for space
            idx = i;
        }

        String[] res = Arrays.copyOf(words, idx+1);
        return String.join(" ", res);
    }
}
