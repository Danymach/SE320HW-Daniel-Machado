import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.TreeSet;

public class question2 {
  public static void main(String args[]) {

    File fileToRead = getName();
    System.out.println(fileToRead);
    TreeSet<String> set = readFile(fileToRead);
    System.out.println("All the non-duplicate words: ");
    System.out.println(set);

  }

  
  public static File getName() {
    Scanner sc = new Scanner(System.in);
    System.out.println("Input file name, leave blank for default: ");
    String name = sc.nextLine();

    if (name.equals("")) {
      File file = new File("randomFile.txt");
      sc.close();
      return file;
    } else {
      File fileDefault = new File(name);
      sc.close();
      return fileDefault;
    }

    
  }

  public static TreeSet<String> readFile(File file) {

    TreeSet<String> set = new TreeSet<>();

    try {
      FileReader fr = new FileReader(file);
      BufferedReader br = new BufferedReader(fr);
      String line;

      while ((line = br.readLine()) != null) {
        String[] words = line.split(" ");
        for (String word : words) {
          set.add(word);
        }
        br.close();
      }

    } catch (FileNotFoundException e) {
      System.out.println("File not found");
    } catch (IOException e) {
      System.out.println(e);
    }

    
    return set;
  }
}
