package leetcode.easy.valid_mountain_array;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.validMountainArray(new int[] {0,1,2,3,4,5});
    }
    public boolean validMountainArray(int[] arr) {
        if(arr.length < 3) return false;

        int left = 0; //투 포인터를 선언한다
        int right = arr.length - 1;

        int count = 0;

        while (count < arr.length) { //count가 arr의 길이보다 커지면 반복문 탈출 후 return false
            if(left == right) { //left와 right이 만나는 경우
               if(left != 0 && right != arr.length - 1) { //left나 right가 한칸이라도 움직였어야 한다.
                   return true;
               } else { // 0,1,2,3,4,5와 같은 경우는 left는 움직였지만, right는 움직이지 않았으므로 산 모양이 아니다.
                   return false;
               }
            }
            if(arr[left] < arr[left + 1]) { //왼쪽부터 오는 포인터로 해당 수와 다음 수 비교하고 다음수가 더 크면 left포인터 한칸 옮김
                left++;
            } else { //아니라면 반복문 카운트 증가. 포인터 홀드하기 위함
                count++;
            }
            if(arr[right] < arr[right - 1]) { //오른쪽부터 오는 포인터로 해당 수와 다음 수 비교하고 다음수가 더 크면 right포인터 한칸 옮김
                right--;
            } else { //아니라면 반복문 카운트 증가. 포인터 홀드하기 위함
                count++;
            }
        }

        return false; //left와 right가 만나지 않고 반복문을 탈출하면 return false
    }
}
