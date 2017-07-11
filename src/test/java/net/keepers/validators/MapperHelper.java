package net.keepers.validators;

/*
  Created object structure
 */

import net.keepers.dto.DtoUser;
import net.keepers.model.Contact;
import net.keepers.model.User;

import java.util.ArrayList;
import java.util.List;

public class MapperHelper {

    public static final Long TEST_ID = 1L;
    public static final Long TEST_NEGATIVE_ID = -1L;
    public static final String TEST_USER_NAME = "Test";
    public static final String TEST_PHONE = "+38 044 123 45 67";
    public static final String TEST_USER_LAST_NAME = "User";
    public static final String TEST_PATRONYMIC = "Patronymic";
    public static final String TEST_TYPE = "MOBILE";
    public static final String TEST_COMMENT = "This is test comment";


    public static User getUserTest() {
        User user = new User();
        user.setId(TEST_ID);
        user.setFirstName(TEST_USER_NAME);
        user.setLastName(TEST_USER_LAST_NAME);
        user.setPatronymic(TEST_PATRONYMIC);
        user.setContact(getTestContact());
        return user;
    }

    public static Contact getTestContact() {
        Contact contact = new Contact();
        contact.setComment(TEST_COMMENT);
        contact.setPhoneNumber(TEST_PHONE);
        contact.setType(TEST_TYPE);
        return contact;
    }

    public static List<Contact> getTestListOfContacts() {
        Contact contact = getTestContact();
        List<Contact> contacts = new ArrayList<>();
        contacts.add(contact);
        contacts.add(contact);
        return contacts;
    }

    public static DtoUser getTestDtoUser() {
        DtoUser dtoUser = new DtoUser();
        dtoUser.setFirstName(TEST_USER_NAME);
        dtoUser.setLastName(TEST_USER_LAST_NAME);
        dtoUser.setPatronymic(TEST_PATRONYMIC);
        dtoUser.setContact(getTestContact());
        return dtoUser;
    }


    public static List<DtoUser> getTestListOfDtoUsers() {
        DtoUser dtoUserOne = getTestDtoUser();
        List<DtoUser> dtoUsers = new ArrayList<>();
        dtoUsers.add(dtoUserOne);
        dtoUsers.add(dtoUserOne);
        return dtoUsers;
    }

    public static List<User> getTestListOfUsers() {
        User user = getUserTest();
        List<User> users = new ArrayList<>();
        users.add(user);
        users.add(user);
        return users;
    }
}