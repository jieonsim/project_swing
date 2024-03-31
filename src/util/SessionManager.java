package util;

public class SessionManager {
    private static Integer currentUserIDX = null; // Store the current user's ID

    public static void login(int userIDX) {
        currentUserIDX = userIDX; // Set the current user's ID upon login
    }

    public static void logout() {
        currentUserIDX = null; // Clear the user ID upon logout
    }

    public static Integer getCurrentUserIDX() {
        return currentUserIDX; // Retrieve the current user's ID
    }
}
