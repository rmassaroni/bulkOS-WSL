package deckPackage;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.EmptyStackException;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Vector;
import java.util.function.Consumer;
import java.util.function.Function;

public class Deck<E> extends Vector<E> {	
	public static void main(String[] args) {

	}
	
	private static final long serialVersionUID = 1L;
	
	public boolean autoClean;
	public boolean noDupes;
	
	private int min;
	private int max;
	
	public ArrayList<Object> nodes; //will be private
	
	public Deck() {
		this(false);
	}
	
	public Deck(boolean noDupes) {
		super();
		this.noDupes = noDupes;
		nodes = new ArrayList<>();
	}
	
	public Deck(String str, String punctuation) {
		super();
		
	}
	
	public Deck(E[] arr) {
		this();
		for(E element : arr) add(element);
	}
	
	public Deck(Collection<E> c) {
		this();
		if(c != null)
			this.addAll(c);
	}
	
	public Deck(File f, Function<String, E> factory) {
		 this();
		 try {
			 Scanner reader = new Scanner(f);
			 while(reader.hasNextLine())
				 add(factory.apply(reader.nextLine()));
			 reader.close();
		 } catch (FileNotFoundException e) {
			 e.printStackTrace();
		 }
	}
	
	public void addNode(String attribute) {
		for(E element : this) {
			
		}
	}
	
	public boolean checkAdd(E element) {
		if(!(noDupes && contains(element))) {
			add(element);
			return true;
		}
		return false;
	}
	
	public void checkAddAll(Collection<E> c) {
		for(E element : c)
			checkAdd(element);
	}
	
	//peek, top
	public E head() {
		if(size() == 0) 
			throw new EmptyStackException();
		return elementAt(size() - 1);
	}
	
	//pop, chop, punch
	public E cut() {
		E head = head();
		removeElementAt(size() - 1);
		return head;
	}
	
	//push, stretch
	public E bulk(E item) {
		addElement(item);
		return item;
	}
	
	//shoe, toe
	public E foot() {
		return get(0);
	}
	
	//pull
	public E kick() {
		return remove(0);
	}
	
	public E jump(E item) {
		add(0, item);
		return item;
	}
	
	public E first() {
		return foot();
	}
	
	public Function<E, E> next = element -> {return get(indexOf(element) + 1);};
	
	public Function<E, E> last = element -> {return get(indexOf(element) - 1);};
	
	public boolean empty() {
		return size() == 0;
	}
	
	public HashMap<E, Integer> occurrances() {
		HashMap<E, Integer> map = new HashMap<E, Integer>();
		for(E item : removeDuplicates())
			map.put(item, frequency(item));
		return map;
	}
	
	public Deck<E> removeDuplicates() {
		return new Deck<E>(new LinkedHashSet<E>(this)); //not working for subclasses
	}
	
	public int frequency(E item) {
		return Collections.frequency(this, item);
	}
	
	//flip
	public Deck<E> reverse() {
		for(int i = 0; i < size(); i++)
			jump(remove(i));
		return this;
	}
	
	public Deck<E> subDeck(int first) {
		return subDeck(first, size());
	}
	
	public Deck<E> subDeck(int first, int last) {
		for(int i = 0; i < first; i++)
			kick();
		for(int i = last; i < size(); i++)
			cut();
		return this;
	}
	
	public void setMin(int min) {
		this.min = min;
	}
	
	public int getMin() {
		return min;
	}
	
	public void setMax(int max) {
		this.max = max;
	}
	
	public int getMax() {
		return max;
	}
	
	public E getType() {
		return null;
	}
	
	public void clean() {
		if(autoClean) {
			
		}
	}
	
	public int count(String str, String c) {
		int counter = 0;
		for(int i = 0; i < str.length() - c.length(); i++)
			if(str.substring(i, i + c.length()).equals(c))
				counter++;
		return counter;
	}
	
	public void split(E str, String punctuation) {
		if(count(str.toString(), punctuation) == 0) {
			add(str);
		}
		else if(count(str.toString(), punctuation) == 1) {
//			add(str.toString().substring(0, str.toString().indexOf(punctuation)));
		}
	}
	
	public void function(Function<? super E, ? super E> fun, Consumer<? super E> action) {
		stream().map(fun).forEach(System.out::println);
	}
	
	public boolean addAll(Collection<? extends E> c) {
		if(c != null)
			return super.addAll(c);
		return false;
	}
	
	
	//ADD METHOD THAT ACCEPTS MULTIPLE PARAMETERS IN ADD
	//SORTING OPTIONS. method for each sort. general sorting method that finds fastest sorting method.
	//CUSTOM SIZES
	//FOREACH METHODS
	//ALTERNATE SETTING FOR REMOVING DUPES.  REORGANIZES COLLECTION INTO A SET AND ELEMENTS APPEARING N TIMES WILL HAVE TAG N.  SIMILAR TO DICTIONARY.
	//simplify with exponents
	//ENUMERATION METHOD? CHECK VECTOR CLASS
	//METHOD THAT LETS USER CREATE MORE ARRAYS HOLDING ADDITIONAL DATA.  DATA CAN BE FILLED WITH FUNCTIONS AND METHODS
	//MULTIDIMENTIONAL ARRAY CONTAINING ROWS OF ALL ELEMENTS
	//randomize method
}
