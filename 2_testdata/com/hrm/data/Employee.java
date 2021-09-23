package com.hrm.data;

import utilities.DataUtil;

public class Employee {
    public static Employee getEmployee(){
        return new Employee();
    }

    public class Role {
        public static final String ADMIN_USERNAME = "Admin";
        public static final String ADMIN_PASSWORD = "admin123";
    }
    public static class PersonalDetails {
        public static final String FIRSTNAME = "Harry";
        public static final String LASTNAME = "Kane";
        public static final String USERNAME = "harrykane";
        public static final String PASSWORD = "12345678";
        public static final String FULLNAME = FIRSTNAME + " " + LASTNAME;
    }

    public class ContactDetails {
        public static final String FIRSTNAME = "Jerry";
        public static final String LASTNAME = "Shaw";
        public static final String GENDER = "Male";
        public static final String MARITAL_STATUS = "Single";
        public static final String NATIONALITY = "Vietnamese";
    }

    public class Job {

    }

    public class Salary {

    }
}
