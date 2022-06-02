package programmers.function_development;

import java.util.*;

// progresses	speeds	return
//[93, 30, 55]	[1, 30, 5]	[2, 1]
//[95, 90, 99, 99, 80, 99]	[1, 1, 1, 1, 1, 1]	[1, 3, 2]

public class Solution {
    Queue<Integer> functions;
    Queue<Integer> speed;

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(new int[]{95, 90, 99, 99, 80, 99}, new int[]{1, 1, 1, 1, 1, 1}));
    }

    public List<Integer> solution(int[] progresses, int[] speeds) {
        List<Integer> answer = new ArrayList<>();

        functions = getQueue(progresses);
        speed = getQueue(speeds);

        //int day = 1;
        int release;

        while (!functions.isEmpty()) {
            release = 0;
            // 작업할 기능의 진도율 100이 안될 경우,
            if (functions.peek() < 100) {
                // 작업 리스트 만큼 반복문 돌면서 작업을 한다.
                for (int function = 0; function < speed.size() ; function++) {
                    int item = functions.poll();
                    int workTime = speed.poll();
                    // 진도율이 100이 넘지 않을 경우에만 작업을 하고, 아닐 경우는 패스한다.
                    if (item < 100) {
                        item += workTime;
                    }
                    // 작업을 완료하곤 다시 큐에 넣어준다.
                    functions.add(item);
                    speed.add(workTime);
                }
            }
            // 하루 작업을 완료하고 기능 개발이 완료가 되었는지 확인한다.
            // 여기서 큐의 헤드만 검사하는 이유는 뒤에 기능이 완료 되어도 앞의 기능이 완료되지 않으면 배포할 수 없기 때문
            if (functions.peek() >= 100) {
                release = getReleaseFunctions();
            }

            if (release != 0) {
                answer.add(release);
            }

            //System.out.println(day + "일, 배포 개수 : " + release);
            //day++;
        }

        return answer;
    }

    private int getReleaseFunctions() {
        int progress = functions.peek();
        int release = 0;

        // 큐에서 진도율이 100 이상인 작업이 연속으로 있을 경우에도 배포할 수 있는 기능 개수를 구할 수 있다.
        while (progress >= 100 && !functions.isEmpty()) {
            release++;
            // 배포할 기능은 큐에서 제거해준다.
            functions.poll();
            speed.poll();
            if (functions.size() > 0) {
                progress = functions.peek();
            }
        }

        return release;
    }

    private Queue<Integer> getQueue(int[] items) {
        Queue<Integer> queue = new LinkedList<>();

        for (int item : items) {
            queue.add(item);
        }

        return queue;
    }
}
