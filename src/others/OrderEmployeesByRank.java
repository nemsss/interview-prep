package others;

import java.util.*;

/**
 * Created by cenumah on 2020-01-15
 */
public class OrderEmployeesByRank {

    /*
        Consider a vector of employees with a name and their title:
        [<John, Manager>, <Sally, CTO>, <Sam, CEO>, <Drax, Engineer>, <Bob, CFO>, <Daniel, Engineer>]

        And a dictionary where the keys report to the values:
        {[CTO, CEO], [Manager, CTO], [Engineer, Manager], [CFO, CEO]}

        Re-order the vector of employees according to the dictionary mappings. The vector of employees can be extremely big, however the dictionary only contains the title orderings.

        Sample output:
        [<Drax, Engineer>, <Daniel, Engineer>, <John, Manager>, <Sally, CTO>, <Bob, CFO>, <Sam, CEO>]
     */
    public static void main(String[] args) {

        List<String[]> employees = new ArrayList<>();
        employees.add(new String[]{"John", "Manager"});
        employees.add(new String[]{"Sally", "CTO"});
        employees.add(new String[]{"Sam", "CEO"});
        employees.add(new String[]{"Drax", "Engineer"});
        employees.add(new String[]{"Bob", "CFO"});
        employees.add(new String[]{"Daniel", "Engineer"});

        Map<String, String> heirarchy = new HashMap<>();
        heirarchy.put("CTO", "CEO");
        heirarchy.put("Manager", "CTO");
        heirarchy.put("Engineer", "Manager");
        heirarchy.put("CFO", "CEO");

        List<String[]> res = new OrderEmployeesByRank().reorderList(employees, heirarchy);
        for(String[] e : res) {
            System.out.println(Arrays.toString(e));
        }
    }

    private List<String[]> reorderList (List<String[]> employees, Map<String, String> heirarchy) {

        if(employees == null || employees.isEmpty() || heirarchy == null || heirarchy.isEmpty()) {
            return employees;
        }

        Map<String, Integer> lookUp = new HashMap<>();
        //lookUp.put("CEO", 1);
        Map<String, List<String>> reportingStructure = new HashMap<>();
        for(String report : heirarchy.keySet()) {
            reportingStructure.putIfAbsent(report, new ArrayList<>());
            reportingStructure.putIfAbsent(heirarchy.get(report), new ArrayList<>());
            reportingStructure.get(heirarchy.get(report)).add(report);
        }

        buildLookUpMap(lookUp, "CEO", 1, reportingStructure);

        employees.sort(((o1, o2) -> Integer.compare(lookUp.get(o2[1]), lookUp.get(o1[1]))));

        return employees;
    }

    private void buildLookUpMap(Map<String, Integer> lookUp, String curr, int rank, Map<String, List<String>> structure) {

        if(!structure.containsKey(curr)) {
            return;
        }

        lookUp.put(curr, rank);
        for(String report : structure.get(curr)) {
            buildLookUpMap(lookUp, report, rank+1, structure);
        }
    }
}
