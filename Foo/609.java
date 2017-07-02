public class Solution {
    public List<List<String>> findDuplicate(String[] paths) {
        List<List<String>> res = new ArrayList<>();
        Map<String, List<String>> contentToFile = new HashMap<>();
        for (String path : paths) {
            String[] parts = path.split(" ");
            String dir = parts[0];
            for (int j = 1; j < parts.length; j++) {
                String[] fileParts = parts[j].split("\\(");
                String fileName = fileParts[0];
                String content = fileParts[1].substring(0, fileParts[1].length()-1);
                if (!contentToFile.containsKey(content))
                    contentToFile.put(content, new ArrayList<>());
                contentToFile.get(content).add(dir + "/" + fileName);
            }
        }

        for (String k : contentToFile.keySet()) {
            if (contentToFile.get(k).size() > 1)
                res.add(contentToFile.get(k));
        }

        return res;
    }
}