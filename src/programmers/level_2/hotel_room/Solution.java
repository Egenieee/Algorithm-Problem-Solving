package programmers.level_2.hotel_room;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(new String[][]{{"13:00", "13:30"}, {"13:40", "14:30"}, {"13:40", "14:30"}, {"14:50", "15:30"}}));
    }

    public int solution(String[][] book_time) {
        List<Book> bookList = new ArrayList<>();

        for (String[] time : book_time) {
            bookList.add(new Book(time[0], time[1]));
        }

        Collections.sort(bookList);

        List<Room> roomList = new ArrayList<>();

        for (Book book : bookList) {
            if (isValidReuseRoom(book, roomList)) {
                Room room = getRoom(roomList, book);
                room.addBook(book);
            } else {
                roomList.add(new Room(book));
            }
        }

        return roomList.size();
    }

    private boolean isValidReuseRoom(Book book, List<Room> roomList) {
        for (Room room : roomList) {
            room.books.sort(new BookEndComparator());
            for (Book booked : room.books) {
                // book의 시작 시간보다 전에 끝나는 방이 있는지 확인하기
                if (booked.end.isBefore(book.start) || booked.end.equals(book.start)) {
                    return true;
                }
            }
        }

        return false;
    }

    // 방이 현재 사용할 수 있는 방인지 확인하기
    private Room getRoom(List<Room> roomList, Book book) {
        for (Room room : roomList) {
            for (Book booked : room.books) {
                // book의 시작 시간보다 전에 끝나는 방이 있는지 확인하기
                if (booked.end.isBefore(book.start) || booked.end.equals(book.start)) {
                    return room;
                }
            }
        }

        return null;
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
