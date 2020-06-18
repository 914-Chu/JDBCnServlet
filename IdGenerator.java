package tw.com.phctw.utils;
import java.util.HashMap;
import java.util.Random;

public class IdGenerator {
	private HashMap<Character, Integer> letters = new HashMap<>();
    private int[] validation = {1,9,8,7,6,5,4,3,2,1,1};
    
    public IdGenerator() {
    	letters.put('A', 10);
    	letters.put('B', 11);
    	letters.put('C', 12);
    	letters.put('D', 13);
    	letters.put('E', 14);
    	letters.put('F', 15);
    	letters.put('G', 16);
    	letters.put('H', 17);
    	letters.put('I', 34);
    	letters.put('J', 18);
    	letters.put('K', 19);
    	letters.put('L', 20);
    	letters.put('M', 21);
    	letters.put('N', 22);
    	letters.put('O', 35);
    	letters.put('P', 23);
    	letters.put('Q', 24);
    	letters.put('R', 25);
    	letters.put('S', 26);
    	letters.put('T', 27);
    	letters.put('U', 28);
    	letters.put('V', 29);
    	letters.put('W', 32);
    	letters.put('X', 30);
    	letters.put('Y', 31);
    	letters.put('Z', 33);
    }
    
    public String getId() {
  	  String id = "";
  	  do {
  		  id = idCardProduce();
  	  }while(!validId(id));
  	  return id;
    }
  
  public boolean validId(String id){
      char[] arr = id.toCharArray();
      if(arr[1] != '1' && arr[1] != '2') return false;
      
      int sum = letters.get(arr[0])/10 * validation[0]
              + letters.get(arr[0])%10 * validation[1];

      for(int i = 1; i < 10; i++){
          sum += (arr[i] - '0') * validation[i+1];
      }
      return sum%10 == 0;
  }

  private String idCardProduce(){
      String id = "";
      Random rand = new Random();
      char letter = (char)(rand.nextInt(26) + 'A');
      int gender = rand.nextInt(2)+1;
      int num = rand.nextInt(10000000);
      int check = letters.get(letter)/10 * validation[0] 
      		  + letters.get(letter)%10 * validation[1]
      	      + gender * validation[2];
              
      for(int i = 7; i >= 1; i--){
      	check += ((num / (int)Math.pow(10, i-1)) % 10)% 10 * i;
      }
      check = 10 - (check % 10);
      
      return letter + Integer.toString(gender) + String.format("%07d", num) + check;
  }
}
