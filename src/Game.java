import java.util.InputMismatchException;
import java.util.Scanner;

public class Game {
    /**
     * Spouští všechny metody ze třídy Flashcards
     */
    public static void game(){
        Flashcards flashcards = new Flashcards();
        try{
            Scanner sc = new Scanner(System.in);
            Flashcards.filesToArrayList(flashcards.AnimalsEN, flashcards.AnimalsCZ, flashcards.HousingEN, flashcards.HousingCZ,
                    flashcards.FoodEN, flashcards.FoodCZ, flashcards.ClothesEN, flashcards.ClothesCZ);
            String answer;
            flashcards.themeSelection();
            flashcards.languageSelection();
            for(int i = 0; i < 5; i++){
                System.out.println(flashcards.randomWordGenerator());
                answer = sc.next();
                System.out.println(flashcards.correctnessOfAnswer(answer));
            }
            System.out.println(flashcards.evaluation());
        }catch (InputMismatchException e){
            System.out.println("You can't write letters in this! Write numbers!");
        }catch (Exception e){
            System.out.println("Error");
        }
    }
}
