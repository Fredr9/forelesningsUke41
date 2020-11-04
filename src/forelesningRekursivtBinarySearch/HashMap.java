package forelesningRekursivtBinarySearch;

import java.util.ArrayList;
import java.util.LinkedList;

public class HashMap {

    public static void main(String[] args) {
        System.out.println("Hashmap test");

        int hash_map_size = 7;
        ArrayList<LinkedList<String>> hash_map = new ArrayList<>(hash_map_size);

        hash_map.ensureCapacity(hash_map_size);
        for (int i = 0; i < hash_map_size; ++i) {
            hash_map.add(i, new LinkedList<>());
        }

        // Lager test.-strenger
        String[] strings = new String[5];
        strings[0] = "Hei";
        strings[1] = "På deg din gamle sjokolade";
        strings[2] = "Peder";
        strings[3] = "Test";
        strings[4] = "Hallo";


        for (int i = 0; i < strings.length; ++i) {
            int hash = hash(strings[i]);
            int hash_map_index = compute_hashmap_index(hash, hash_map_size);
            System.out.println("Legger inn " + strings[i] + " med hash " + hash + " på plass " + hash_map_index);
            hash_map.get(hash_map_index).addFirst(strings[i]);
        }

        int hash = hash("Test2");
        int hash_map_index = compute_hashmap_index(hash, hash_map_size);
        System.out.println( hash_map.get(hash_map_index).toString());
    }

    static int compute_hashmap_index(int hash, int hash_map_size) {
        return hash % hash_map_size;
    }

    static int hash(String data) {
        int hash = 0;

        // sum av alle bokstavene ( ikke optimalt siden bokstavene ikke blir "sortert"  f
        // eks hei er det samme som eih eller ihe)
        // for(int i = 0; i < data.length(); ++i){
        //    hash = hash + (int) data.charAt(i);
        // }
        // return hash;

        for (int i = data.length() - 1; i >= 0; --i) {
            char c = data.charAt(i);
            hash = (hash + c) * 31;
        }
        if (hash < 0) {
            hash = -hash;
        }
        return hash;
    }
}
