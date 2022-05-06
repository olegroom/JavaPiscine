public interface UsersList {
    void addUser(User usr);
    User getUserById(Integer id)  throws UserNotFoundException;
    User getUserByIndex(Integer index) throws UserNotFoundException;
    Integer getSizeOfArray();
}
