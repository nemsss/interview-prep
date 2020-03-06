package others;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by cenumah on 2020-01-12
 */
public class AvgTransitTime {

    public static void main(String[] args) {

    }

    class TrainSystem {

        private Map<Integer, Passenger> passengers = new HashMap<>();
        private Map<Integer, Map<Integer, Transits>> transitTimes = new HashMap<>();

        public void tapIn(int passenger, int station, Timestamp time) {
            passengers.put(passenger, new Passenger(passenger, station, time));
        }

        public void tapOut(int passengerId, int station, Timestamp time) {
            if(!passengers.containsKey(passengerId)) {
                throw new IllegalArgumentException("Passenger did not swipe in");
            }

            Passenger passenger = passengers.get(passengerId);
            transitTimes.putIfAbsent(passenger.enteredAt, new HashMap<>());

            Map<Integer, Transits> map = transitTimes.get(passenger.enteredAt);
            map.putIfAbsent(station, new Transits());
            Transits transitRecord = map.get(station);
            transitRecord.totalTime+= (time.getTime() - passenger.time.getTime());
            transitRecord.totalPassengers++;

            passengers.remove(passengerId);
        }

        public double getAverageTimeBetween(int station1, int station2) {
            if(transitTimes.containsKey(station1)) {
                Map<Integer, Transits> transitsMap = transitTimes.get(station1);
                if(transitsMap.containsKey(station2)) {
                    return transitTimes.get(station1).get(station2).getAverage();
                }
            }

            return 0.0;
        }
    }

    class Transits {
        private long totalTime;
        private int totalPassengers;

        double getAverage() {
            return totalTime / totalPassengers;
        }
    }

    class Passenger {
        private int id;
        private int enteredAt;
        private Timestamp time;

        Passenger(int id, int station, Timestamp time) {
            this.id = id;
            this.enteredAt = station;
            this.time = time;
        }
    }
}
