package com.zipcodewilmington.phonebook;

import java.util.*;
//import java.util.HashMap;


/**
 * Created by leon on 1/23/18.
 * Made WAY better by kristofer 6/16/20
 *
 */

public class PhoneBook {

    private final Map<String, List<String>> phonebook;

    public PhoneBook(Map<String, List<String>> map) {
        this.phonebook = map;
    }

    public PhoneBook() {
        this(new LinkedHashMap<>());
    }

    public void add(String name, String phoneNumber) {
        if(phonebook.containsKey(name)){
            List<String> phoneNums = phonebook.get(name);
            phoneNums.add(phoneNumber);
            phonebook.put(name, phoneNums);
        } else {
            phonebook.put(name, new ArrayList<String>(List.of(phoneNumber)));
        }
    }

    public void addAll(String name, String... phoneNumbers) {
        if(phonebook.containsKey(name)){
            List<String> phoneNums = phonebook.get(name);
            phoneNums.addAll(Arrays.asList(phoneNumbers));
            phonebook.put(name, phoneNums);
        } else {
            phonebook.put(name, new ArrayList<String>(List.of(phoneNumbers)));
        }

    }

    public void remove(String name) {
        phonebook.remove(name);
    }

    public Boolean hasEntry(String name) {
        return phonebook.containsKey(name);
    }

    public Boolean hasEntry(String name, String phoneNumber) {
        return phonebook.get(name).contains(phoneNumber);
    }

    public List<String> lookup(String name) {
        return phonebook.get(name);
    }

    public String reverseLookup(String phoneNumber)  {

        for(Map.Entry<String, List<String>> entry: phonebook.entrySet()){
            String key = entry.getKey();
            List<String> value = entry.getValue();
            if(value.contains(phoneNumber)){
                return key;
            }
        }
        return "";

    }

    public List<String> getAllContactNames() {
        ArrayList<String> keys = new ArrayList<>(List.of(phonebook.keySet().stream().toArray(String[]::new)));
        return keys;
    }

    public Map<String, List<String>> getMap() {
        return phonebook;
    }
}
