package graphs;

public class Test {

	public static void main(String[] args) {
		Graph<String> countries = new Graph<>();
		countries.addNode("A", "Ajo");
		countries.addNode("B", "Bordo");
		countries.addNode("C", "Colina");
		countries.addNode("D", "Danza");
		countries.addNode("E", "Erizo");
		System.out.println(countries);
	}
}
