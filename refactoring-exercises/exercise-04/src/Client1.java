
import java.io.*;

public class Client1 {

	public static void printPerson(Writer out, Person person) throws IOException {
		out.write(person.first);
		out.write(" ");
		if (person.middle != null) {
			out.write(person.middle);
			out.write(" ");
		}
		out.write(person.last);
	}

}
