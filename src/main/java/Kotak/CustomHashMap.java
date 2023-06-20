package Kotak;

//{"gautham":"sd",}

import com.sun.org.apache.xpath.internal.operations.String;

public class CustomHashMap {

    int iterator;

    HashMapComponent[] listOfEntries;

    public CustomHashMap(Integer length) {
        listOfEntries = new HashMapComponent[length];
    }

    public static void main(String[] args) {
        CustomHashMap customHashMap = new CustomHashMap(2);
//        customHashMap.putInHAshMap();

    }

    public void putInHAshMap(String key, String value){
        HashMapComponent hashMapComponent = new HashMapComponent(key,value);
//        this.listOfEntries
    }

    public java.lang.String getValue(String key){
        return "kss";
    }

    public int hashCodeOfKey(String key){
        return key.hashCode();
    }
}

class HashMapComponent {
    String key;
    String value;

    public HashMapComponent(String key, String value) {
        this.key = key;
        this.value = value;
    }


}
