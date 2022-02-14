package leetcode.peak_index_in_a_mountain_array;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.peakIndexInMountainArray(new int[] {24,69,100,99,79,78,67,36,26,19}));
    }
    public int peakIndexInMountainArray(int[] arr) {
        if(arr.length < 3) return -1;

        int left = 0; //투 포인터를 선언한다
        int right = arr.length - 1;

        int count = 0;

        while (count < arr.length) { //count가 arr의 길이보다 커지면 반복문 탈출 후 return false
            if(left == right) { //left와 right이 만나는 경우
                if(left != 0 && right != arr.length - 1) { //left나 right가 한칸이라도 움직였어야 한다.
                    return left; //가장 큰 값인 인덱스 번호 반환
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

        return -1;
    }
}
