package com.GeekTrust.model;

import com.GeekTrust.InputMessage;

import java.util.HashMap;

/**
 * The interface Function model.
 */
public interface FunctionModel {
    /**
     * Count char in string hash map.
     *
     * @param message the message
     * @return the hash map
     */
    public HashMap<Character,Integer> countCharInString(String message);

    /**
     * Check if we won boolean.
     *
     * @param inputMessage the input message
     * @param KingName     the king name
     * @return the boolean
     */
    public boolean checkIfWeWon(InputMessage inputMessage, String KingName);

    /**
     * Caeser cipher string string buffer.
     *
     * @param message      the message
     * @param cipher_shift the cipher shift
     * @return the string buffer
     */
    public StringBuffer CaeserCipherString(String message, int cipher_shift);

    /**
     * Gets king name.
     *
     * @param Kingdom     the kingdom
     * @param kingdomList the kingdom list
     * @return the king name
     */
    public String getKingName(String Kingdom,HashMap<String,String> kingdomList);
}
