public class Codec {

    private List<String> idToLongUrl = new ArrayList<>();
    private Map<String, Integer> index = new HashMap<>();
    private String chs = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        if (index.containsKey(longUrl))
            return base62Encode(index.get(longUrl));

        idToLongUrl.add(longUrl);
        index.put(longUrl, idToLongUrl.size() - 1);
        return "http://tinyurl.com/" + base62Encode(idToLongUrl.size() - 1);
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        String url = shortUrl.substring(19);
        int id = base62Decode(url);
        return idToLongUrl.get(id);
    }

    private String base62Encode(int id) {
        StringBuilder sb = new StringBuilder();
        while (id != 0) {
            int curr = id % 62;
            sb.insert(0, chs.charAt(curr));
            id /= 62;
        }

        return sb.toString();
    }

    private int base62Decode(String url) {
        int id = 0;
        for (char ch : url.toCharArray()) {
            int curr = chs.indexOf(ch);
            id *= 62;
            id += curr;
        }

        return id;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(url));