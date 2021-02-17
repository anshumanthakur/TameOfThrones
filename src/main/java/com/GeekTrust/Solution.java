package com.GeekTrust;

import com.GeekTrust.model.FunctionModel;
import com.GeekTrust.model.FunctionModelImpl;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 * The type Solution.
 */
public class Solution{
    private static final FunctionModel functionModel = new FunctionModelImpl();

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String... args) {
        HashMap<String,String> kingdomList = new HashMap<>();
        setKingdomList(kingdomList);

        int countWin = 0;
        ArrayList<String> conqueredKingdomsList= new ArrayList<>();
        StringBuilder conqueredKingdoms = new StringBuilder();
        String inputFile = args[0];
        try{
            FileInputStream fileInputStream = new FileInputStream(inputFile);
            Scanner sc=new Scanner(fileInputStream);
            while (sc.hasNextLine()){
                String secretMessage = sc.nextLine().toLowerCase();
                String[] arr = secretMessage.split(" ");
                StringBuilder secretString= new StringBuilder();
                for(int i=1;i<arr.length;i++)
                    secretString.append(arr[i]);
                InputMessage inputMessage = new InputMessage(arr[0], secretString.toString());
                //getKingName from secret Message
                String KingName = functionModel.getKingName(inputMessage.getKingdom(),kingdomList);
                if(functionModel.checkIfWeWon(inputMessage, KingName)){
                    if(!conqueredKingdomsList.contains(arr[0])){
                        countWin++;
                        conqueredKingdoms.append(arr[0]).append(" ");
                        conqueredKingdomsList.add(arr[0]);
                    }

                }
            }
            sc.close();
        }catch (FileNotFoundException e) {
            System.out.println("file not found");
        }
        if(countWin>=3)
            System.out.println("SPACE "+ conqueredKingdoms.toString().toUpperCase());
        else
            System.out.println("NONE");
    }


    /**
     * Set kingdom list.
     *
     * @param kingdomList the kingdom list
     */
    public static void setKingdomList(HashMap<String,String> kingdomList){
        kingdomList.put("space","gorilla");
        kingdomList.put("land","panda");
        kingdomList.put("water","octopus");
        kingdomList.put("ice","mammoth");
        kingdomList.put("air","owl");
        kingdomList.put("fire","dragon");
    }

}
