package shop;

import java.util.Arrays;

public class UsersList {

    private User[] usersList;
    private final int usersListSize = 10;
    private int lastIndex = -1;

    public UsersList() {

        this.usersList = new User[usersListSize];
    }

    public UsersList(User[] usersList) {
        this.usersList = usersList;
    }

    public void addUser(User user) {

        if (lastIndex == -1) {
            this.usersList = new User[usersListSize];
        } else if (lastIndex == usersList.length - 1) {
            usersList = Arrays.copyOf(usersList, usersList.length * 2);
        }

        lastIndex++;
        usersList[lastIndex] = user;

    }

    public int getNewID() {
        return lastIndex + 2;
    }

    public void DisplayUsersList() {

        for (int i = 0; i < usersList.length; i++) {
            if (usersList[i] != null) {
                System.out.println(usersList[i].toString());
            }

        }
    }

    public void DeleteUser(int id) {

        for (int i = 0; i < usersList.length; i++) {
            if (id == usersList[i].getId()) {
                usersList[i] = null;
            }

        }

    }

    public User GetUserById(int id) {

        User user = null;
        for (int i = 0; i < usersList.length; i++) {
            if (id == usersList[i].getId()) {
                user = usersList[i];
            }
        }

        return user;
    }
}
