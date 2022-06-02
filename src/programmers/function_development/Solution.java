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
            if (functions.peek() < 100) {
                for (int function = 0; function < speed.size() ; function++) {
                    int item = functions.poll();
                    int workTime = speed.poll();
                    if (item < 100) {
                        item += workTime;
                    }
                    functions.add(item);
                    speed.add(workTime);
                }
            }
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

        while (progress >= 100 && !functions.isEmpty()) {
            release++;
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
