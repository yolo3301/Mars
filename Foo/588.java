public class FileSystem {

    public class FolderNode {
        public Map<String, FolderNode> subfolders;
        public Map<String, String> files;
        public FolderNode() {
            subfolders = new HashMap<>();
            files = new HashMap<>();
        }
    }

    private FolderNode root;

    public FileSystem() {
        root = new FolderNode();
    }
    
    public List<String> ls(String path) {
        List<String> list = new ArrayList<>();
        if (path.equals("/")) {
            list.addAll(root.subfolders.keySet());
            list.addAll(root.files.keySet());
        } else {
            String[] p = path.split("/");
            FolderNode q = root;
            for (int i = 1; i < p.length-1; i++) {
                if (!q.subfolders.containsKey(p[i]))
                    return list;
                q = q.subfolders.get(p[i]);
            }

            if (q.subfolders.containsKey(p[p.length-1])) {
                q = q.subfolders.get(p[p.length-1]);
                list.addAll(q.subfolders.keySet());
                list.addAll(q.files.keySet());
            } else if (q.files.containsKey(p[p.length-1])) {
                list.add(p[p.length-1]);
            }
        }

        Collections.sort(list);
        return list;
    }
    
    public void mkdir(String path) {
        String[] p = path.split("/");
        FolderNode q = root;
        for (int i = 1; i < p.length; i++) {
            if (!q.subfolders.containsKey(p[i]))
                q.subfolders.put(p[i], new FolderNode());
            q = q.subfolders.get(p[i]);
        }
    }
    
    public void addContentToFile(String filePath, String content) {
        String[] p = filePath.split("/");
        FolderNode q = root;
        for (int i = 1; i < p.length-1; i++) {
            if (!q.subfolders.containsKey(p[i]))
                q.subfolders.put(p[i], new FolderNode());
            q = q.subfolders.get(p[i]);
        }

        String old = "";
        if (q.files.containsKey(p[p.length-1]))
            old = q.files.get(p[p.length-1]);

        q.files.put(p[p.length-1], old + content);
    }
    
    public String readContentFromFile(String filePath) {
        String res = "";
        String[] p = filePath.split("/");
        FolderNode q = root;
        for (int i = 1; i < p.length-1; i++) {
            if (!q.subfolders.containsKey(p[i]))
                return res;
            q = q.subfolders.get(p[i]);
        }

        if (q.files.containsKey(p[p.length-1]))
            res = q.files.get(p[p.length-1]);

        return res;
    }
}

/**
 * Your FileSystem object will be instantiated and called as such:
 * FileSystem obj = new FileSystem();
 * List<String> param_1 = obj.ls(path);
 * obj.mkdir(path);
 * obj.addContentToFile(filePath,content);
 * String param_4 = obj.readContentFromFile(filePath);
 */