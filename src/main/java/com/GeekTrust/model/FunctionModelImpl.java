package com.GeekTrust.model;

import com.GeekTrust.InputMessage;

import java.util.HashMap;
import java.util.Map;

/**
 * The type Function model.
 */
public class FunctionModelImpl implements FunctionModel {

    /**
     * Count char in string hash map.
     *
     * @param message the message
     * @return the hash map
     */
    static final int MAX_CHAR = 256;
    public HashMap<Character,Integer> countCharInString(String message){
        int[] count = new int[MAX_CHAR];
        HashMap<Character,Integer> countChar = new HashMap<>();
        int len = message.length();
        for (int i = 0; i < len; i++)
            count[message.charAt(i)]++;
        char[] ch = new char[message.length()];
        for (int i = 0; i < len; i++) {
            ch[i] = message.charAt(i);
            int find = 0;
            for (int j = 0; j <= i; j++) {

                // If any matches found
                if (message.charAt(i) == ch[j])
                    find++;
            }

            if (find == 1)
                countChar.put(message.charAt(i),count[message.charAt(i)]);
        }
        return countChar;
    }

    /**
     * Check if we won boolean.
     *
     * @param inputMessage the input message
     * @param KingName     the king name
     * @return the boolean
     */
    public boolean checkIfWeWon(InputMessage inputMessage, String KingName){
        int cipher_shift = KingName.length();
        HashMap<Character,Integer> countCharInSecretMsg;
        HashMap<Character,Integer> ShiftedCharDict;
        StringBuffer ShiftedCharString = CaeserCipherString(KingName,cipher_shift);
        countCharInSecretMsg= countCharInString(inputMessage.getSecretMessage());
        ShiftedCharDict = countCharInString(ShiftedCharString.toString());
        int Flag =1;
        for (Map.Entry<Character,Integer> charCount : ShiftedCharDict.entrySet()){
            Integer countCharInSecret = 0;
            if(countCharInSecretMsg.get(charCount.getKey()) != null)
                countCharInSecret = countCharInSecretMsg.get(charCount.getKey());
            if(countCharInSecret < charCount.getValue()){
                Flag =0;
            }
        }
        return Flag == 1;
    }

    /**
     * Caeser cipher string string buffer.
     *
     * @param message      the message
     * @param cipher_shift the cipher shift
     * @return the string buffer
     */
    public StringBuffer CaeserCipherString(String message, int cipher_shift){
        StringBuffer result= new StringBuffer();

        for (int i=0; i<message.length(); i++)
        {
            if (Character.isUpperCase(message.charAt(i)))
            {
                char ch = (char)(((int)message.charAt(i) +
                        cipher_shift - 65) % 26 + 65);
                result.append(ch);
            }
            else
            {
                char ch = (char)(((int)message.charAt(i) +
                        cipher_shift - 97) % 26 + 97);
                result.append(ch);
            }
        }
        return result;
    }

    /**
     * Gets king name.
     *
     * @param Kingdom     the kingdom
     * @param kingdomList the kingdom list
     * @return the king name
     */
    public String getKingName(String Kingdom,HashMap<String,String> kingdomList){
        return kingdomList.get(Kingdom);
    }
}

