package leetcode.easy.find_common_characters;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.commonChars(new String[]{"bella","label","roller"});
    }
    public List<String> commonChars(String[] words) {
        int[] result = new int[26]; //중복되는 문자 찾기위한 hash table
        int[] temp = new int[26]; //각 단어마다 들어있는 문자 체크하기 위한 hash table

        Arrays.fill(result, Integer.MAX_VALUE); //최소값 찾기위해 result를 세팅해준다.

        for(String word : words) { //단어 하나하나 처리해준다
            Arrays.fill(temp, 0); //각 단어마다 계산할 hash table 이기 때문에 연산전에 0으로 초기화해준다.
            for(int i = 0 ; i < word.length() ; i++) {
                temp[word.charAt(i) - 'a'] += 1; //a는 0번 z는 26번으로, 각 단어에 나오는 알파벳에 따라 1씩 더해서 표기한다.
            }
            for(int j = 0 ; j < result.length ; j++) { //result와 비교해서 최소값들로 result를 세팅한다. 공통된 알파벳들을 찾기위함.
                result[j] = Math.min(result[j], temp[j]);
            }
        }

        List<String> commonCharacters = new ArrayList<>();

        for(int i = 0 ; i < result.length ; i++) { //result를 돌면서 개수만큼 중복된 알파벳을 리스트에 추가한다.
            if(result[i] > 0) { //0보다 크면 공통된 알파벳이라는 것!
                for(int j = 0 ; j < result[i] ; j++) { //result에 저장된 개수만큼 중복되었다는 것이다.
                    commonCharacters.add(String.valueOf((char) (i + 'a'))); //'a'를 더해주면 해당 알파벳의 int형 수가 나옴. char형으로 캐스팅해서 String변수로 바꿔 add해준다.
                }
            }
        }

        //System.out.println(commonCharacters);

        return commonCharacters;
    }
}

