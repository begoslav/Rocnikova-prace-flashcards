import java.io.*;
import java.util.ArrayList;
import java.util.Random;
import java.util.*;

public class Flashcards {

    private int theme;
    private int randomIndex;
    private String randomWord;
    private int language;

    //region Arraylists
    ArrayList<String> AnimalsEN = new ArrayList<>();
    ArrayList<String> AnimalsCZ = new ArrayList<>();
    ArrayList<String> HousingEN = new ArrayList<>();
    ArrayList<String> HousingCZ = new ArrayList<>();
    ArrayList<String> FoodEN = new ArrayList<>();
    ArrayList<String> FoodCZ = new ArrayList<>();
    ArrayList<String> ClothesEN = new ArrayList<>();
    ArrayList<String> ClothesCZ = new ArrayList<>();
    ArrayList<String> WrongAnswers = new ArrayList<>();
    ArrayList<String> RightAnswers = new ArrayList<>();
    Random rd = new Random();
    Scanner sc = new Scanner(System.in);
    //endregion

    //region set&get
    public int getTheme() {
        return theme;
    }

    public void setTheme(int theme) {
        if(theme > 0 && theme < 5){
            this.theme = theme;
        }else {
            themeSelection();
        }
    }

    public int getLanguage() {
        return language;
    }

    public void setLanguage(int language) {
        if(language > 0 && language < 3){
            this.language = language;
        }else {
            languageSelection();
        }
    }

    //endregion

    /**
     * Načítá všechny slova ze souborů do Arraylistů
     */
    public static void filesToArrayList(ArrayList<String> AnimalsEN, ArrayList<String> AnimalsCZ, ArrayList<String> HousingEN,
                                        ArrayList<String> HousingCZ, ArrayList<String> FoodEN, ArrayList<String> FoodCZ,
                                        ArrayList<String> ClothesEN, ArrayList<String> ClothesCZ){
        try{
            BufferedReader br = new BufferedReader(new FileReader("AnimalsEN.txt"));
            String line = br.readLine();
            while(line != null){
                AnimalsEN.add(line);
                line = br.readLine();
            }
            br.close();
            BufferedReader br2 = new BufferedReader(new FileReader("HousingEN.txt"));
            String line2 = br2.readLine();
            while(line2 != null){
                HousingEN.add(line2);
                line2 = br2.readLine();
            }
            br2.close();
            BufferedReader br3 = new BufferedReader(new FileReader("FoodEN.txt"));
            String line3 = br3.readLine();
            while(line3 != null){
                FoodEN.add(line3);
                line3 = br3.readLine();
            }
            br3.close();
            BufferedReader br4 = new BufferedReader(new FileReader("AnimalsCZ.txt"));
            String line4 = br4.readLine();
            while(line4 != null){
                AnimalsCZ.add(line4);
                line4 = br4.readLine();
            }
            br4.close();
            BufferedReader br5 = new BufferedReader(new FileReader("HousingCZ.txt"));
            String line5 = br5.readLine();
            while(line5 != null){
                HousingCZ.add(line5);
                line5 = br5.readLine();
            }
            br5.close();
            BufferedReader br6 = new BufferedReader(new FileReader("FoodCZ.txt"));
            String line6 = br6.readLine();
            while(line6 != null){
                FoodCZ.add(line6);
                line6 = br6.readLine();
            }
            br6.close();
            BufferedReader br7 = new BufferedReader(new FileReader("ClothesEN.txt"));
            String line7 = br7.readLine();
            while(line7 != null){
                ClothesEN.add(line7);
                line7 = br7.readLine();
            }
            br.close();
            BufferedReader br8 = new BufferedReader(new FileReader("ClothesCZ.txt"));
            String line8 = br8.readLine();
            while(line8 != null){
                ClothesCZ.add(line8);
                line8 = br8.readLine();
            }
            br.close();
        }catch (IOException e){
            System.out.println("Error");
        }
    }

    /**
     * Náhodně vygeneruje slovo na překlad na základě  vybraného téma a jazyku
     * @return Slovo k překladu ve vybraném jazyce
     */
    public String randomWordGenerator(){
        if(getLanguage() == 1){
            if(getTheme() == 1){
                randomIndex = rd.nextInt(AnimalsEN.size());
                randomWord = AnimalsEN.get(randomIndex);
            } else if (getTheme() == 2) {
                randomIndex = rd.nextInt(HousingEN.size());
                randomWord = HousingEN.get(randomIndex);
            } else if (getTheme() == 3) {
                randomIndex = rd.nextInt(FoodEN.size());
                randomWord = FoodEN.get(randomIndex);
            } else if (getTheme() == 4) {
                randomIndex = rd.nextInt(ClothesEN.size());
                randomWord = ClothesEN.get(randomIndex);
            }
        } else if (getLanguage() == 2) {
            if(getTheme() == 1){
                randomIndex = rd.nextInt(AnimalsCZ.size());
                randomWord = AnimalsCZ.get(randomIndex);
            } else if (getTheme() == 2) {
                randomIndex = rd.nextInt(HousingCZ.size());
                randomWord = HousingCZ.get(randomIndex);
            } else if (getTheme() == 3) {
                randomIndex = rd.nextInt(FoodCZ.size());
                randomWord = FoodCZ.get(randomIndex);
            } else if (getTheme() == 4) {
                randomIndex = rd.nextInt(ClothesCZ.size());
                randomWord = ClothesCZ.get(randomIndex);
            }
        }
        return "Translate this word (pište háčky a čárky): " + randomWord;
    }

    /**
     * Přečte a zkontroluje odpověd uživatele a vyhodnotí, jestli je dobře nebo špatně
     * @param answer Odpověd uživatele
     * @return vyhodnocení odpovědi - Špatně nebo dobře
     */
    public String correctnessOfAnswer(String answer){
        String answer2 = "Nothing";
        if(getLanguage() == 1){
            if(getTheme() == 1){
                    if(answer.equalsIgnoreCase(AnimalsCZ.get(randomIndex))) {
                        RightAnswers.add(answer);
                        answer2 = "Correct!";
                    }else {
                        WrongAnswers.add(randomWord);
                        answer2 = "Wrong!";
                    }
            } else if (getTheme() == 2) {
                    if(answer.equalsIgnoreCase(HousingCZ.get(randomIndex))) {
                        RightAnswers.add(answer);
                        answer2 = "Correct!";
                    }else {
                        WrongAnswers.add(randomWord);
                        answer2 = "Wrong!";
                    }
            } else if (getTheme() == 3) {
                    if(answer.equalsIgnoreCase(FoodCZ.get(randomIndex))) {
                        RightAnswers.add(answer);
                        answer2 = "Correct!";
                    }else {
                        WrongAnswers.add(randomWord);
                        answer2 = "Wrong!";
                }
            } else if (getTheme() == 4) {
                if(answer.equalsIgnoreCase(ClothesCZ.get(randomIndex))) {
                    RightAnswers.add(answer);
                    answer2 = "Correct!";
                }else {
                    WrongAnswers.add(randomWord);
                    answer2 = "Wrong!";
                }
        } else if (getLanguage() == 2) {
            if(getTheme() == 1){
                    if(answer.equalsIgnoreCase(AnimalsEN.get(randomIndex))) {
                        RightAnswers.add(answer);
                        answer2 = "Correct!";
                    }else {
                        WrongAnswers.add(randomWord);
                        answer2 = "Wrong!";
                    }
            } else if (getTheme() == 2) {
                    if(answer.equalsIgnoreCase(HousingEN.get(randomIndex))) {
                        RightAnswers.add(answer);
                        answer2 = "Correct!";
                    }else {
                        WrongAnswers.add(randomWord);
                        answer2 = "Wrong!";
                    }
            } else if (getTheme() == 3) {
                    if(answer.equalsIgnoreCase(FoodEN.get(randomIndex))) {
                        RightAnswers.add(answer);
                        answer2 = "Correct!";
                    }else {
                        WrongAnswers.add(randomWord);
                        answer2 = "Wrong!";
                    }
            }else if (getTheme() == 4) {
                if(answer.equalsIgnoreCase(ClothesEN.get(randomIndex))) {
                    RightAnswers.add(answer);
                    answer2 = "Correct!";
                }else {
                    WrongAnswers.add(randomWord);
                    answer2 = "Wrong!";
                    }
                }
            }
        }
        return answer2;
    }

    /**
     * Zeptá se uživatele, aby si vybral téma slovíček, které chce procvičovat
     */
    public void themeSelection(){
        System.out.println("Pick a topic: Press: 1 - Animals, 2 - Housing, 3 - Food, 4 - Clothes");
        setTheme(sc.nextInt());
    }

    /**
     * Zeptá se uživatele, aby si vybral jazyk, do kterého chce slovíčka překládat
     */
    public void languageSelection(){
        System.out.println("Select the language you want to translate into: Press: 1 - Czech, 2 - English");
        setLanguage(sc.nextInt());
    }

    /**
     * Vyhodnotí celkový uživatelův výkon a vypíše mu zpětnou vazbu
     * @return Vyhodnocení výsledku včetně počet správných odpovědí a špatných
     */
    public String evaluation(){
        try(BufferedWriter bw = new BufferedWriter(new FileWriter("WrongAnswers.txt"))){
                for (String s : WrongAnswers){
                    bw.write(s);
                    bw.newLine();
                }
        }catch (Exception e){
            System.out.println("Error");
        }
        return "\n" + "You have correct " + RightAnswers.size() + "/5 words!" + "\n" +
                "Words you didn't know will be found in the file 'WrongAnswers'";
    }
}