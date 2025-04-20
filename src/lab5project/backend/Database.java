package backend;

import java.io.*;
import java.util.ArrayList;

public abstract class Database {
    protected ArrayList<Member> records;
    protected String filename;

    public Database(String filename) {
        this.records = new ArrayList<>();
        this.filename = filename;
    }


    public  void readFromFile()
    {
       try (BufferedReader reader = new BufferedReader(new FileReader(filename)))
        {
            String line;
            while ((line = reader.readLine()) != null) {
                Member member = createRecordFrom(line);
                records.add(member);
            }
        } catch (IOException e)
       {
            e.printStackTrace();
       }
        /*try {
        File myObj = new File(filename);
        if (myObj.createNewFile()) {
            System.out.println("File created: " + myObj.getName());
        } else {
            System.out.println("File already exists.");
        }
    } catch (IOException e) {
        System.out.println("An error occurred.");
        e.printStackTrace();
    }

        try {
            File myObj = new File(filename);
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String line= myReader.nextLine();
               Member member = createRecordFrom(line);
               records.add(member);
            }
            myReader.close();
        } catch (FileNotFoundException e)
        {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }*/

    }
    public abstract Member createRecordFrom(String line);


    public ArrayList<Member> returnAllRecords() {
        return records;
    }

    public boolean contains(String key) {
        for (Member m : records) {
            if (m.getSearchKey().equals(key)) {
                return true;
            }
        }
        return false;
    }

    public Member getRecord(String key)
    {
        for (Member member : records) {
            if (member.getSearchKey().equals(key)) {
                return member;
            }
        }
        return null;
    }

    public void insertRecord(Member member) {
        records.add(member);
    }

    public void deleteRecord(String key) {
        Member memberToRemove = null;
        for (Member member : records) {
            if (member.getSearchKey().equals(key)) {
                memberToRemove = member;
                break;
            }
        }
        if (memberToRemove != null) {
            records.remove(memberToRemove);
        }
    }

    public abstract void saveToFile();
  /*  {    try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            for (Member member : records) {
                writer.write(member.lineRepresentation());
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }*/
}











