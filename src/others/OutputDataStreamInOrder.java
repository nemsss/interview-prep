package others;

import java.util.List;
import java.util.PriorityQueue;

/**
 * Created by cenumah on 2020-01-15
 */
public class OutputDataStreamInOrder {

    public static void main(String[] args) {

    }

    static PriorityQueue<Data> pq = new PriorityQueue<>();
    static int min = 1;
    static int prev = -1;

    static void printInOrder(Data data) {
        if(data == null) {
            return;
        }

        if(data.id == min) {
            System.out.println(data);
            prev = min;
            return;
        }

        pq.add(data);

        if(pq.peek().id <= prev+1) {
            System.out.println(pq.poll());
        }
    }

    static class Data implements Comparable<Data>{
        private int id;
        private String value;

        @Override
        public int compareTo(Data o) {
            return Integer.compare(id, o.id);
        }

        @Override
        public String toString() {
            return String.format("{id->%d, value->%s}", id, value);
        }
    }
}
