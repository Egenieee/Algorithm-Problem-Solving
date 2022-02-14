package leetcode.long_pressed_name;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.isLongPressedName("aleeex", "aaaalex");
    }
    public boolean isLongPressedName(String name, String typed) {
        if(name.length() == 0 || typed.length() == 0) return false;
        if(name.charAt(0) != typed.charAt(0)) return false;
        if(name.length() > typed.length()) return false;
        if(name.charAt(name.length() - 1) != typed.charAt(typed.length() - 1)) return false;
        if(name.length() == typed.length()) {
            return name.equals(typed);
        }

        int namePointer = 0;
        int typedPointer = 0;

        while(namePointer != name.length() && typedPointer != typed.length()) { //투 포인터로 앞에서부터 비교한다
            if(name.charAt(namePointer) == typed.charAt(typedPointer)) { //같으면 namePointer 한칸 옮긴다
                namePointer++;
            } else {
                if(name.charAt(namePointer - 1) != typed.charAt(typedPointer)) { //다르면 namePointer가 전에 가르켰던 알파벳과 비교한다.
                    return false; //다르면 바로 return false. 같으면 그냥 넘어간다
                }
            }
            typedPointer++;
        }

        while(typedPointer < typed.length()) { //name이 모두 다 끝난 뒤에 typed가 더 남았을 경우에 도는 반복문이다
            if(name.charAt(namePointer - 1) == typed.charAt(typedPointer)) {//위의 반복문을 무사히 돌고 이 반복문에 들어왔을 경우, namePointer는 name의 길이일 것이다.
                typedPointer++;                                             //따라서 포인터 값에서 하나뺀 포인터 값이 마지막 name을 가르키고 있다. name의 마지막 알파벳과 비교한다.
            } else {
                return false;               //다르면 return false
            }
        }

        return true; //모든 반복문을 무사히 끝내고 나오면 return true
    }
}
