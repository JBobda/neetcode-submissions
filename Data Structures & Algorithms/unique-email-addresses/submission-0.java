class Solution {
    public int numUniqueEmails(String[] emails) {
        HashMap<String, Integer> map = new HashMap<>();
        int count = 0;
        for(String email : emails) {
            String[] components = email.split("@");
            String local = components[0];
            String domain = components[1];

            local = local.replace(".", "");
            if(local.contains("+"))
                local = local.substring(0, local.indexOf('+'));

            String sanitized = local + "@" + domain;
            if(map.getOrDefault(sanitized, 0) == 0) {
                count++;
                map.put(sanitized, 1);
            }
        }

        return count;
    }
}