package programmers.phone_num_list;

import java.util.HashMap;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(new String[] {"119", "97674223", "1195524421"}));
    }
    public boolean solution(String[] phone_book) {

        HashMap<String, Integer> phoneBook = new HashMap<>();

        for(int i = 0 ; i < phone_book.length; i++) {
            phoneBook.put(phone_book[i],i);
        }

        for(int i = 0 ; i < phone_book.length ; i++) {
            for(int j = 0 ; j < phone_book[i].length() ; j++) {
                if(phoneBook.containsKey(phone_book[i].substring(0,j))){ //모든 전화번호를 가능한 조합의 서브스트링으로 만들어서 맵의 키로 존재하고 있는지 확인
                    return false;
                }
            }
        }

        return true;
    }
}
