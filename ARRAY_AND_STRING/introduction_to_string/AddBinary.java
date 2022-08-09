import java.util.ArrayList;
import java.util.List;

/**
 * ADD BINARY
 * Given two binary strings `a` and `b` return *their sum as a binary string*
 * 
 * **Example 1:**
 * ```
 * **Input:** a = "11", b = "1"
 * **Output:** "100"
 * ```
 * **Example 2:**
 * ```
 * **Input:** a = "1010", b = "1011"
 * **Output*:* "10101"
 * ```
 * constraints
 * - `1 <= a.length, b.length <= 10^4`
 * `a` n `b` consist only of `'0'` or `'1'` chars
 * each string does not contain leading zeroes except for zero itself
 */
public class AddBinary {
  
  public static void main(String[] args) {
    
    List<String[]> examples = new ArrayList<>();
    examples.add(new String[]{  "11",    "1"}); 
    examples.add(new String[]{"1010", "1011"});
    List<String> outputs = new ArrayList<>();
    outputs.add(  "100"); 
    outputs.add("10101");
    // test
    for (int i = 0; i < examples.size(); i++) {
      String[] example = examples.get(i);
      String output = outputs.get(i);
      String result = addBinary(example[0], example[1]);
      boolean testcase = output.equals(result);
      System.out.println("Ex"+(i+1)+": " + testcase + " " + result + " " + (testcase ? "==" : "!=") + " " + output);
      assert(testcase);
    }
  }

  public static String addBinary(String a, String b) {

    int aLen = a.length(); int bLen = b.length();
    int longerLen = aLen > bLen ? aLen : bLen;
    int shorterLen = longerLen == aLen ? bLen : aLen;
    String longer = longerLen == aLen ? a : b;
    String shorter = longer == a ? b : a;
    int longerI = longerLen-1;
    int shorterI = shorterLen-1;
    boolean carryOne = false;
    StringBuilder sb = new StringBuilder();
    while (shorterI >= 0 && longerI >= shorterI) {
      int shorterDigit = Integer.parseInt(shorter.charAt(shorterI)+"");
      int longerDigit = Integer.parseInt((longer.charAt(longerI))+"");
      int digitSum = shorterDigit + longerDigit;
      if (carryOne) digitSum++;
      carryOne = digitSum > 1 ? true : false;
      if (carryOne)
        sb.insert(0, digitSum-2);
      else
        sb.insert(0, digitSum);
      shorterI--;
      longerI--;
    }
    while (longerI >= 0) {
      int digitSum = Integer.parseInt(longer.charAt(longerI)+"");
      if (carryOne)
        digitSum++;
      carryOne = digitSum > 1 ? true : false;
      if (carryOne)
        sb.insert(0, '0');
      else
        sb.insert(0, digitSum);
      longerI--;
    }
    if (carryOne)
      sb.insert(0, '1');

    return sb.toString();
  }
  
}
