package programmers.best_album;

// input : ["classic", "pop", "classic", "classic", "pop"]	[500, 600, 150, 800, 2500] return:	[4, 1, 3, 0]

// 맵1 - key : 고유번호, value : 장르
// 맵2 - key : 고유번호, value : 재생횟수
// 장르 당 플레이 된 횟수 총합 구해서 어떤 장르부터 수록할 지 구하기?
// 한 장르 내에서 어떤 노래가 가장 많이 수록 됐는 지 순서 알기 --> 정렬
// 위에서 구한 장르 순위 별 두개씩 노래 뽑아서 저장.

import java.util.*;

public class Solution {
    private static final int BEST_ALBUM_SONG_COUNT = 2;
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(new String[]{"classic", "pop", "classic", "classic", "pop"}, new int[] {150, 600, 150, 100, 2500}));
    }
    public List<Integer> solution(String[] genres, int[] plays) {
        // 장르 종류
        Set<String> genreTypes = getGenreTypes(genres);
        // 장르 - 플레이 된 총 수
        Map<String, Integer> playCountSum = getPlayCountSum(genres, plays, genreTypes);

        // 이 리스트에서 두개 씩 뽑으면 됨. --> 장르에 노래가 하나면 하나만 뽑자.
        List<String> rankOfSum = getRankOfSum(playCountSum);

        // 그 장르 내에서 어떤 노래가 가장 많이 플레이 됐는 지 구하기 --> 이중 맵 사용
        Map<String, Map<Integer, Integer>> playCountPerGenre = initPlayCountPerGenre(genreTypes);

        // 장르 당 노래 플레이 횟수 저장
        for (int i = 0 ; i < genres.length ; i++) {
            String genre = genres[i];
            int playCount = plays[i];
            setPlayCountPerGenre(i, genre, playCount, playCountPerGenre);
        }

        // 각 장르에 해당되는 맵 내림차순으로 정렬 후 두 개 뽑아서 리스트에 저장, 각 장르대로 뽑을 때, 위에서 구한 rank 순서대로 뽑기
        List<Integer> answer = new ArrayList<>();

        for (String genre : rankOfSum) {
            sortAndGetTwoSongs(genre, playCountPerGenre, answer);
        }

        return answer;
    }

    private Set<String> getGenreTypes(String[] genres) {
        return new HashSet<>(Arrays.asList(genres));
    }

    // 장르 별 총 노래 플레이 횟수 구해서 맵에 저장
    private Map<String, Integer> getPlayCountSum(String[] genres, int[] plays, Set<String> genreTypes) {
        Map<String, Integer> playCountSum = initPlayCountSum(genreTypes);

        for (int i = 0 ; i < genres.length ; i++) {
            playCountSum.put(genres[i], playCountSum.getOrDefault(genres[i], 0) + plays[i]);
        }

        return playCountSum;
    }

    private Map<String, Integer> initPlayCountSum(Set<String> genreTypes) {
        Map<String, Integer> playCountPerGenre = new HashMap<>();
        for (String genre : genreTypes) {
            playCountPerGenre.put(genre, 0);
        }
        return playCountPerGenre;
    }

    // 장르 별 총 노래 플레이 횟수로 내림차순 정렬 뒤, 순서 리스트 반환
    private List<String> getRankOfSum(Map<String, Integer> playCountSum) {
        List<String> rankOfSum = new ArrayList<>();

        // 어떤 장르가 먼저 수록될 건지 value에 따라서 순서 정렬 --> 장르당 2개 노래씩 뽑을거임
        List<Map.Entry<String, Integer>> sortedWords = new ArrayList<Map.Entry<String, Integer>>(playCountSum.entrySet());
        sortGenre(sortedWords);

        for(Map.Entry<String, Integer> entry : sortedWords) {
            rankOfSum.add(entry.getKey());
        }

        return rankOfSum;
    }

    // 비교 함수 -> 장르 별 노래 총 횟수 비교해서 내림차순으로 정렬
    private void sortGenre(List<Map.Entry<String, Integer>> genres) {
        // 비교함수 Comparator를 사용하여 내림차순으로 정렬
        genres.sort(new Comparator<>() {
            // compare로 값을 비교
            public int compare(Map.Entry<String, Integer> obj1, Map.Entry<String, Integer> obj2) {
                // 만약 value 값이 같을 경우 key 값으로 비교해서 정렬
                if (obj1.getValue().equals(obj2.getValue())) {
                    return obj2.getKey().compareTo(obj1.getKey());
                }
                return obj2.getValue().compareTo(obj1.getValue());
            }
        });
    }

    // 장르 별 맵 하나씩 초기화해서 저장하기
    private Map<String, Map<Integer, Integer>> initPlayCountPerGenre(Set<String> genreType) {
        Map<String, Map<Integer, Integer>> playCountPerGenre = new HashMap<>();

        for (String genre : genreType) {
            playCountPerGenre.put(genre, new HashMap<>());
        }

        return playCountPerGenre;
    }

    // 해당 장르 맵 꺼내와서 고유번호 - 재생 횟수 맵으로 저장 후 다시 본 맵으로 넣기
    private void setPlayCountPerGenre(int i, String genre, int playCount, Map<String, Map<Integer, Integer>> playCountPerGenreMap) {
        Map<Integer, Integer> playCountPerGenre = playCountPerGenreMap.get(genre);
        playCountPerGenre.put(i, playCount);
        playCountPerGenreMap.put(genre,playCountPerGenre);
    }

    // 장르 별 노래 횟수 내림차순으로 2개 뽑기
    private void sortAndGetTwoSongs(String genre, Map<String, Map<Integer, Integer>> playCountPerGenre, List<Integer> answer) {
        Map<Integer, Integer> eachGenre = playCountPerGenre.get(genre);
        List<Map.Entry<Integer, Integer>> sortedWords = new ArrayList<Map.Entry<Integer, Integer>>(eachGenre.entrySet());
        sortPlayCount(sortedWords);

        int count = 0;
        for(Map.Entry<Integer, Integer> entry : sortedWords) {
            if (count == BEST_ALBUM_SONG_COUNT) {
                break;
            }
            answer.add(entry.getKey());
            count++;
        }
    }

    // 비교 함수 -> 노래 플레이 횟수 기준으로 내림차순으로 정렬
    private void sortPlayCount(List<Map.Entry<Integer, Integer>> playCount) {
        // 비교함수 Comparator를 사용하여 내림차순으로 정렬
        playCount.sort(new Comparator<>() {
            // compare로 값을 비교
            public int compare(Map.Entry<Integer, Integer> obj1, Map.Entry<Integer, Integer> obj2) {
                // 만약 value 값이 같을 경우 key 값으로 비교해서 오름차순 정렬 --> 고유번호가 앞선 노래부터 수록
                if (obj2.getValue().equals(obj1.getValue())) {
                    return obj1.getKey().compareTo(obj2.getKey());
                }
                return obj2.getValue().compareTo(obj1.getValue());
            }
        });
    }
}
