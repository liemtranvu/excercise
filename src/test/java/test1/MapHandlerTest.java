package test1;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

public class MapHandlerTest {

    @Test
    @SuppressWarnings("unchecked")
    public void shouldLoadArrayOfMapFromString() {
        MapHandler underTest = new MapHandler();
        String text = "key1=value1;key2=value2\nkeyA=valueA\n";
        HashMap<String, String>[] expected = new HashMap[]{
                new HashMap(){
                    {
                        put("key1", "value1");
                        put("key2", "value2");
                    }
                },
                new HashMap(){
                    {
                        put("keyA", "valueA");
                    }
                }
        };

        Map<String,String>[] result = underTest.load(text);

        assertArrayEquals(expected, result);
    }

    @Test
    public void shouldStoreArrayOfMapIntoString() {
        MapHandler underTest = new MapHandler();
        String expected = "key1=value1;key2=value2\nkeyA=valueA\n";
        HashMap<String, String>[] maps = new HashMap[]{
                new HashMap(){
                    {
                        put("key1", "value1");
                        put("key2", "value2");
                    }
                },
                new HashMap(){
                    {
                        put("keyA", "valueA");
                    }
                }
        };

        String result = underTest.store(maps);

        assertEquals(expected, result);
    }
}