package programmers.level_2.hotel_room;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

// {"15:00", "17:00"}, {"16:40", "18:20"}, {"14:20", "15:20"}, {"14:10", "19:20"}, {"18:20", "21:20"}
// {"13:00", "13:30"}, {"13:40", "14:30"}, {"13:40", "14:30"}, {"14:40", "15:30"}

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(new String[][]{{"15:00", "17:00"}, {"16:40", "18:20"}, {"14:20", "15:20"}, {"14:10", "19:20"}, {"18:20", "21:20"}}));
    }

    public int solution(String[][] book_time) {
        List<Book> bookList = new ArrayList<>();

        for (String[] time : book_time) {
            bookList.add(new Book(time[0], time[1]));
        }

        Collections.sort(bookList);

        List<Room> roomList = new ArrayList<>();

        for (Book book : bookList) {
            Room room = getRoom(roomList, book);

            if (room != null) {
                room.addBook(book);
            } else {
                roomList.add(new Room(book));
            }
        }

        return roomList.size();
    }

    // 13:00 - 13:30 -> room1
    // 13:40 - 14:30 -> room1
    // 13:40 - 14:30 -> room2
    // 14:50 - 15:50 -> room1

    // 방이 현재 사용할 수 있는 방인지 확인하기
    private Room getRoom(List<Room> roomList, Book book) {
        Room validRoom = null;

        for (Room room : roomList) {
            for (Book booked : room.books) {
                // book의 시작 시간보다 전에 끝나는 방이 있는지 확인하기
                if (booked.end.isBefore(book.start) || booked.end.equals(book.start)) {
                    validRoom = room;
                } else {
                    validRoom = null;
                }
            }

            if (validRoom != null) {
                return validRoom;
            }
        }

        return validRoom;
    }

    public static class Room {
        List<Book> books;

        public Room(Book book) {
            this.books = new ArrayList<>();
            books.add(book);
        }

        public void addBook(Book book) {
            books.add(book);
        }
    }

    public static class BookEndComparator implements Comparator<Book> {
        @Override
        public int compare(Book book, Book t1) {
            return book.end.compareTo(t1.end);
        }
    }

    public static class Book implements Comparable<Book> {
        LocalTime start;
        LocalTime end;

        public Book(String startTime, String endTime) {
            this.start = LocalTime.parse(startTime);
            this.end = LocalTime.parse(endTime).plusMinutes(10);
        }

        @Override
        public int compareTo(Book book) {
            return this.start.compareTo(book.start);
        }
    }
}
