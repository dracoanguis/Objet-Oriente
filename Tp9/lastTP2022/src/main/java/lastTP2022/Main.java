package lastTP2022;
import java.util.*;
import java.io.*;
import java.util.stream.*;
import java.nio.file.Files;
import java.nio.file.Paths;

interface Animal{}
interface Cat extends Animal{}
interface ReadFileInterf<T>{
	public void readFile(String fileName);
	public ArrayList<T> getFileContents();
}
interface Bitch{
	public Stream<String> readFile(String pathname);
}


public class Main{


	/////////////////////////////////////////
	
	public static void main(String[] args){
		Animal a = new Animal(){};
		Cat c = new Cat(){};
			
		ArrayList<Animal> animalList = new ArrayList<>();
		animalList.add(a);
			
		ArrayList<Cat> catList = new ArrayList<>();
		catList.add(c);
			
		//animalList = catList;//incompatible types: ArrayList<Cat> cannot be converted to ArrayList<Animal>
			
		//to do that we can make the co-variant:
		ArrayList<? extends Animal> animalList2 = new ArrayList<>();
		animalList2 = catList;
		//animalList2 = animalList;//of course also possible
		
		
		//try:
		//catList = animalList;// incompatible types: ArrayList<Animal> cannot be converted to ArrayList<Cat>
		
		//---> to do this, use contra-variance:
	
		
		ArrayList<? super Cat> catList2 = new ArrayList<>();
		catList2 = animalList;
		//catList2 = catList;//also possible of course


		///////////////////////////////////// exo 2
	
		//afr: anonymous file reader
		ReadFileInterf <String> afr =  new ReadFileInterf<>(){	    
			//variable d instance
			private ArrayList<String> fileContents = new ArrayList<>();
	
			public ArrayList<String> getFileContents(){ return fileContents; };
				
			public void readFile(String fileName){
				try( var in = new BufferedReader(new FileReader(fileName))) {
					String line = "";
					int i = 1;
					while ((line = in.readLine()) != null) {
						System.out.println(i + ": " + line );
						fileContents.add(line);
						i++;
					}
				} catch( IOException e ) {
					System.err.println("Couldn't read, because:");
					System.err.println(e.getMessage());
				}
			}
		};
	
		afr.readFile("./src/main/resources/petNames.txt");

		System.out.println("file contents:"+afr.getFileContents());


		//var petNamesWithL = afr.getFileContents().stream().map(s -> s.toLowerCase()).filter(s -> s.contains("l")).collect(Collectors.toList());
		var petNamesWithL = afr.getFileContents().stream().filter(s -> s.toLowerCase().contains("l")).collect(Collectors.toList());
	
		System.out.println("petNamesWithL : "+petNamesWithL);


		var petNamesWith5ch = afr.getFileContents().stream().filter(s -> s.length() == 5).collect(Collectors.toList());
		System.out.println("petNamesWith5ch : "+petNamesWith5ch);

		var uniquePetNames = afr.getFileContents().stream().collect(Collectors.toSet());
		System.out.println("uniquePetNames : "+uniquePetNames);
	
		var uniquePetNamesWith5ch = afr.getFileContents().stream().collect(Collectors.toSet()).stream().filter(s -> s.length() == 5).collect(Collectors.toList());
		System.out.println("uniquePetNamesWith5ch : "+uniquePetNamesWith5ch);

		/////////////////////////////////////////////////////////////////////// Custom

		var otherUniquePetNamesWith5ch = afr.getFileContents().stream().filter(s -> s.length()==5).collect(Collectors.toSet());
		System.out.println("otherUniquePetNamesWith5ch : "+otherUniquePetNamesWith5ch);
	
		Bitch ofr = new Bitch(){

			public Stream<String> readFile(String pathname) {
				try(Stream<String> fLine = Files.lines(Paths.get(pathname))) {
					return fLine;
				}
				catch(IOException e) {
					System.err.println("Failure Couldn't read because: "+e.getMessage());
					return Stream.of("Fail");
				}
			}
		};

		ofr.readFile("./src/main/resources/petNames.txt").forEach(System.out::println);

	}

}
