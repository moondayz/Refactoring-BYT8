public class Person {
	
	// Class Person has multiple clients, but all of the clients are in 
	// one file for convenience.  In the previous mode they were in separate 
	// client classes. 
	
	public String last;

	public String first;

	public String middle;

	public Person(String last, String first, String middle) {
		this.last = last;
		this.first = first;
		this.middle = middle;
	}
	
	
	@Override
	public String toString() {
		return (first == null ?  " " : first + " ") + (middle == null ?  "" : middle + " ")  + (last == null ?  " " : last);
	}
	
}
