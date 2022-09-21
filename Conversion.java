import java.util.*;
public class Conversion {
    
    public static void main(String args[]){
    Scanner scan = new Scanner(System.in);
    int input, choice,temp = 0,input2;
    boolean go = false;
    
    while(go != true){
        System.out.println("\n[1] Decimal to Binary\n[2] Binary to Decimal\n[3] Hex to Decimal\n" +
        "[4] Decimal to Hex\n" +
        "[5] Binary to Hex\n" + 
        "[6] Hex to Binary\n" +  
        "[7] Hamming Distance\n" +
        "[8] Quit\n" + 
        " Input: "
        
        
        
        );
        choice = scan.nextInt();
        switch(choice){
            case 1:                 
                System.out.print("Enter Decimal: ");
                input = scan.nextInt();
                System.out.println("Binary is: ");
                decToBinary(input);
                break;
            case 2:
                System.out.print("Enter Binary: ");
                input = scan.nextInt();
                binToDecimal(input);
                break;
            case 3:
                System.out.print("Enter Hex: ");
                input = scan.nextInt();
                hexToDecimal(input);
                break;
            case 4:
                System.out.print("Enter Decimal: ");
                input = scan.nextInt();
                System.out.println("Hexadecimal is: ");
                decToHex(input);
                break;
            case 5:
                System.out.print("Enter Binary: ");
                input = scan.nextInt();
                binToHex(input);
                break;
            case 6:
                System.out.print("Enter Hex: ");
                input = scan.nextInt();
                hexToBin(input);
                break;
            case 7: 
                System.out.print("Enter String 1: ");
                input = scan.nextInt();
                System.out.print("Enter String 2: ");
                input2 = scan.nextInt();
                hammingDistance(input, input2);
                break;
            case 8:
                go = true;
                break;
        }
        
    }
   

    
    }




    public static String decToBinary(int decimal){
        ArrayList<Integer> remainder = new ArrayList<>();
        if(decimal > 0){
            remainder.add(decimal % 2);
            decToBinary(decimal / 2);
        }
        for(int i = remainder.size() - 1; i >= 0; i--){
            System.out.print(remainder.get(i));
            
        }
            
        return remainder.toString();
    }
    
    public static void binToDecimal(int binary){
        int result = 0, count;
        String input = Integer.toString(binary);
        char chInput[] = new char[input.length()];
        count = chInput.length-1;
        for(int i = 0; i < input.length(); i++){
            chInput[i] = input.charAt(i);
        }
        for(int i = 0; i < chInput.length; i++){
            result = (int) (result + (Character.getNumericValue(chInput[i]) * Math.pow(2, count)));
            count--;
        }
        System.out.println("RESULT: " + result);
    }
    public static int hexToDecimal(int hex){
        int result = 0, count;
        String input = Integer.toString(hex);
        char chInput[] = new char[input.length()];
        count = chInput.length-1;
        for(int i = 0; i < input.length(); i++){
            chInput[i] = input.charAt(i);
        }
        for(int i = 0; i < chInput.length; i++){
            result = (int) (result + (Character.getNumericValue(chInput[i]) * Math.pow(16, count)));
            count--;
        }
        System.out.println("RESULT: " + result);
        return result;
    }
    public static ArrayList decToHex(int decimal){
        ArrayList<String> remainder = new ArrayList<>();
        if(decimal > 0){
            if(decimal % 16 >= 10 && decimal % 16 <= 15){
                switch(decimal % 16){
                    case 10:
                        remainder.add("A");
                        break;
                    case 11:
                        remainder.add("B");
                        break;
                    case 12:
                        remainder.add("C");
                        break;
                    case 13:
                        remainder.add("D");
                        break;
                    case 14:
                        remainder.add("E");
                        break;   
                    case 15:
                        remainder.add("F");
                        break;
                }
            }else
                remainder.add(Integer.toString(decimal % 16));
            decToHex(decimal / 16);
        }
       
        for(int i = remainder.size() - 1; i >= 0; i--)
            System.out.print(remainder.get(i));
        return remainder;
    }
    public static void binToHex(int binary){
        String cont = "";
        ArrayList<String> byFour = new ArrayList<>();
        ArrayList<String> result = new ArrayList<>();
        int counter = 0,index = 1,total = 0;
        String input = Integer.toString(binary);
        //char chInput[] = new char[input.length()];
        for(int i = input.length()-1; i >= 0; i--){ //separating by 4
            if(counter != 4){
                cont = cont + input.charAt(i);
                counter++;
                if(counter != 4 && i == 0){
                    byFour.add(cont);
                }
                if(counter == 4){
                    byFour.add(cont);
                    counter  = 0;
                    cont = "";
                }
               
            }
          

        }
        for(int i = 0; i < byFour.size(); i++){
            cont = byFour.get(i);
            for(int j = 0; j < cont.length(); j++){
                if(cont.charAt(j) == '1'){
                    total = total + index;
                }
                if(index == 1)
                    index = index + 1;
                else
                    index = index * 2;
               
            }
            index = 1;
            result.add(Integer.toString(total));
            total = 0;
           
        }
        System.out.print("Hex is: ");
        for(int i = result.size()-1; i >= 0; i--){
            if(result.get(i).equals("10")){
                System.out.print("A");
            }else if((result.get(i).equals("11"))){
                System.out.print("B");
            }else if((result.get(i).equals("12"))){
                System.out.print("C");
            }else if((result.get(i).equals("13"))){
                System.out.print("D");
            }else if((result.get(i).equals("14"))){
                System.out.print("E");
            }else if((result.get(i).equals("15"))){
                System.out.print("F");
            }else
                System.out.print(result.get(i));

        }
       
    
    }
    public static void hexToBin(int hex){
        String finalRes;
        int decimal = hexToDecimal(hex);
        finalRes = decToBinary(decimal);
        System.out.println(finalRes); // results not accurate
    }
    public static void hammingDistance(int binary, int binary2){
        int count = 0;
        ArrayList<String> finalRes = new ArrayList<>();
        String input = Integer.toString(binary);
        String input2 = Integer.toString(binary2);
        if(input.length() != input2.length()){
            System.out.println("Length Doesn't Match!");
        }else{
            for(int i = 0; i < input.length(); i++){
                ///XOR
                if(input.charAt(i) == input2.charAt(i)){
                    finalRes.add("0");
                }else{
                    count++;
                    finalRes.add("1");
                }
                }
            }
            System.out.println("Hamming Distance: " + count);
        }
        
    
}
