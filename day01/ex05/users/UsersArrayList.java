package users;

import exceptions.UserNotFoundException;

public class UsersArrayList implements UsersList {
    private int arrLength = 10;
    private User[] arrayOfUsers = new User[10];
    private int num = 0;

    @Override
    public void addUser(User usr) {
        num++;
        if (num > arrLength) {
            int newlength = arrLength + (arrLength / 2);

            User[] tmp = new User[arrLength];
            for (int j = 0; j < arrLength; j++)
                tmp[j] = arrayOfUsers[j];

            arrayOfUsers = new User[newlength];

            for(int l = 0; l < arrLength; l++)
                arrayOfUsers[l] = tmp[l];

            arrLength = newlength;
        }
        for (int i = 0; i < arrLength; i++) {
            if (arrayOfUsers[i] == null) {
                arrayOfUsers[i] = usr;
                return;
            }
        }
    }

    @Override
    public User getUserById(Integer id) throws UserNotFoundException {
        for (int i = 0; i < num; i++)
            if (arrayOfUsers[i].getIdentifier().equals(id))
                return arrayOfUsers[i];
        throw new UserNotFoundException("WrongId");
    }

    @Override
    public User getUserByIndex(Integer index) throws UserNotFoundException {
        if (index >= num || index < 0)
            throw new UserNotFoundException("Wrong index");
        else
            return arrayOfUsers[index];
    }

    @Override
    public Integer getSizeOfArray() {
        return num;
    }
}