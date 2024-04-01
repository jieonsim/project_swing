package util;

public class SessionManager {
    private static Integer currentUserIDX = null; // 현재 사용자 IDX 저장

    public static void login(int userIDX) {
        currentUserIDX = userIDX; // 로그인 시 현재 사용자 IDX 설정
    }

    public static void logout() {
        currentUserIDX = null; // 로그아웃 시 사용자 IDX 지우기
    }

    public static Integer getCurrentUserIDX() {
        return currentUserIDX; // 현재 사용자의 IDX 검색
    }
}
