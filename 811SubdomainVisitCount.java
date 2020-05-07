import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    public static List<String> subdomainVisits(String[] cpdomains) {
        Map<String, Integer> counts = new HashMap<>();
        for(String segments: cpdomains) {
            String[] temp = segments.split("\\s+");
            int count = Integer.valueOf(temp[0]);
            String[] segment = temp[1].split("\\.");
            String domain = "";
            for(int i = segment.length - 1; i >= 0; i--) {
                domain = segment[i] + (i < segment.length - 1 ? "." : "") + domain;
                counts.put(domain, counts.getOrDefault(domain, 0) + count);
            }
        }
        ArrayList<String> domains = new ArrayList<>();
        for(String dom: counts.keySet()) {
            domains.add(counts.get(dom) + " " + dom);
        }
        return domains;
    }

    public static void main(String[] args) {
        String[] cpdomains = {"900 google.mail.com", "50 yahoo.com", "1 intel.mail.com", "5 wiki.org"};
        System.out.println(subdomainVisits(cpdomains));
    }
}
