package test1;

import java.util.*;

public class MapHandler {

    private final char VALUE_SEPARATOR = '=';
    private final char ELEMENT_SEPARATOR = ';';
    private final char LINE_SEPARATOR  = '\n';

    public  String store(Map<String, String>[] maps) {
        StringBuffer result = new StringBuffer();

        for(Map<String, String> map : maps) {
            Iterator<String> iter = map.keySet().iterator();

            while (iter.hasNext()) {
                String key = iter.next();
                result.append(key);
                result.append(VALUE_SEPARATOR);
                result.append(map.get(key));

                // only append ELEMENT SEPARATOR if key-value pair is not the last one
                if(iter.hasNext()) {
                    result.append(ELEMENT_SEPARATOR);
                }
            }
            result.append(LINE_SEPARATOR);
        }

        return result.toString();
    }

    public Map[] load(String text) {
        List<Map<String,String>> result = new ArrayList<>();
        StringBuffer string = new StringBuffer();
        String key = null, value = null;
        Map<String,String> map = new HashMap<>();

        for(char c : text.toCharArray()) {
            switch (c) {
                case LINE_SEPARATOR:
                    value = string.toString();
                    map.put(key, value);
                    result.add(map);

                    map = new HashMap<>();
                    string = new StringBuffer();
                    break;

                case ELEMENT_SEPARATOR:
                    value = string.toString();
                    map.put(key, value);

                    string = new StringBuffer();
                    key = null;
                    value = null;
                    break;

                case VALUE_SEPARATOR:
                    key = string.toString();
                    string = new StringBuffer();
                    break;

                default:
                    string.append(c);

            }
        }

        return result.toArray(new Map[]{});
    }
}
