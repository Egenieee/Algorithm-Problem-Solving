package programmers.level_2.hotel_room;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

// {"15:00", "17:00"}, {"16:40", "18:20"}, {"14:20", "15:20"}, {"14:10", "19:20"}, {"18:20", "21:20"}
// {"13:00", "13:30"}, {"13:40", "14:30"}, {"13:40", "14:30"}, {"14:40", "15:30"}
// {"09:10", "10:10"}, {"10:20", "12:20"}

public class Solution {
    public static int roomNumberCount = 1;

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(new String[][]{{"09:10", "10:10"}, {"10:20", "12:20"}}));
    }

    public int solution(String[][] book_time) {
        List<Book> bookList = new ArrayList<>();

        for (String[] time : book_time) {
            bookList.add(new Book(time[0], time[1]));
        }

        Collections.sort(bookList);

        List<Room> roomList = new ArrayList<>();

        for (Book book : bookList) {
            roomList.sort(new RoomBookTimeComparator());
            Room room = getRoom(roomList, book);

            if (room != null) {
                room.setBook(book);
                System.out.println("book time " + book.start + " ~ " + book.end + " is assigned room number " + room.roomNumber);
            } else {
                roomList.add(new Room(book));
                System.out.println("book time " + book.start + " ~ " + book.end + " is assigned room number " + roomList.get(roomList.size() - 1).roomNumber);
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
            validRoom = room.getValidRoom(book);

            if (validRoom != null) {
                return validRoom;
            }
        }

        return validRoom;
    }

    public static class Room {
        Book book;

        int roomNumber;

        public Room(Book book) {
            this.book = book;
            this.roomNumber = Solution.roomNumberCount++;
        }

        public void setBook(Book book) {
            this.book = book;
        }

        public Room getValidRoom(Book book) {
            if (this.book.end.isBefore(book.start) || this.book.end.equals(book.start)) {
                return this;
            }

            return null;
        }
    }

    public static class RoomBookTimeComparator implements Comparator<Room> {
        @Override
        public int compare(Room roomOne, Room roomTwo) {
            return roomOne.book.end.compareTo(roomTwo.book.end);
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
