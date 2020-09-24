package com.he.addressBook;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class AddressBook {
	HashMap<String,Contact> map;
    public AddressBook() {
    	 map=new HashMap<String,Contact>();
    }

    public void addContact(Contact contact) {
       map.put(contact.getName(), contact);
    }

    public void deleteContact(String name) {
    	if(!map.containsKey(name)){
    		throw new RuntimeException();
    	}
    	else{
    		map.remove(name);
    	}
    }

    public void updateContact(String name, Contact contact) {
    	if(!map.containsKey(name)){
    		throw new RuntimeException();
    	}
    	else if(contact==map.get(name)){
    		for(String name1: map.keySet()){
    			Contact contact2=map.get(name1);
    			if(contact2.getName().equals(contact.getName())|| 
						contact2.getOrganisation().equals(contact.getOrganisation())
						|| contact2.getPhoneNumbers().equals(contact.getPhoneNumbers())
						|| contact2.getAddresses().equals(contact.getAddresses())) {
    				throw new RuntimeException();
    			}
    		}
    	}
    	else{
    		Contact contact2=map.get(name);
    		contact2.setName(contact.getName());
    		contact2.setOrganisation(contact.getOrganisation());
    		contact2.setAddresses(contact.getAddresses());
    		contact2.setPhoneNumbers(contact.getPhoneNumbers());
    	}
    }

    public List<Contact> searchByName(String name) {
    	List<Contact> list=(List<Contact>) map.values();
    	if(name.isEmpty()){
    		return list;
    	}
    	Iterator<Contact> itr=list.iterator();
    	while(itr.hasNext()){
    		if(!itr.next().getName().startsWith(name)){
    			list.remove(itr.next());
    		}
    	}
        return list;
    }

    public List<Contact> searchByOrganisation(String organisation) {
    	List<Contact> list=(List<Contact>) map.values();
    	if(organisation.isEmpty()){
    		return list;
    	}
    	Iterator<Contact> itr=list.iterator();
    	while(itr.hasNext()){
    		if(!itr.next().getOrganisation().startsWith(organisation)){
    			list.remove(itr.next());
    		}
    	}
        return list;
    }

}