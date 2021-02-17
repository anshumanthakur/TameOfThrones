import com.GeekTrust.InputMessage;
import com.GeekTrust.model.FunctionModel;
import com.GeekTrust.model.FunctionModelImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

/**
 * The type Function test.
 */
public class FunctionTest {
    private FunctionModel functionModel = new FunctionModelImpl();

    /**
     * Test Counting of char.
     */
    @Test
    @DisplayName("Positive case-check count of character")
    public void testCountChar(){
        String message = "aabcccdddd";
        HashMap<Character,Integer> countCharInString = functionModel.countCharInString(message);
        Integer countOfA = countCharInString.get('a');
        Integer countOfB = countCharInString.get('b');
        Integer countOfC = countCharInString.get('c');
        Integer countOfD = countCharInString.get('d');
        Assertions.assertEquals(Integer.valueOf(2),countOfA);
        Assertions.assertEquals(Integer.valueOf(1),countOfB);
        Assertions.assertEquals(Integer.valueOf(3),countOfC);
        Assertions.assertEquals(Integer.valueOf(4),countOfD);
    }

    /**
     * Check caeser cipher.
     */
    @Test
    @DisplayName("Positive case-check caeser cipher")
    public void checkCaeserCipher(){
        String message = "abcd";
        int cipherLength = message.length();
        Assertions.assertEquals("efgh",functionModel.CaeserCipherString(message,cipherLength).toString());
    }

    /**
     * Check get king name.
     */
    @Test
    @DisplayName("Positive case-check getting king name")
    public void checkGetKingName(){
        String Kingdom = "fire";
        HashMap<String,String> kingdomList = new HashMap<>();
        kingdomList.put("space","gorilla");
        kingdomList.put("land","panda");
        kingdomList.put("water","octupus");
        kingdomList.put("ice","mammoth");
        kingdomList.put("air","owl");
        kingdomList.put("fire","dragon");
        Assertions.assertEquals("dragon",functionModel.getKingName(Kingdom,kingdomList));
    }

    /**
     * Check winning.
     */
    @Test
    @DisplayName("Positive case-check if we won")
    public void checkWinning(){
        InputMessage inputMessage = new InputMessage("air","rozo");
        String KingName = "owl";
        Assertions.assertTrue(functionModel.checkIfWeWon(inputMessage, KingName));
    }

}
