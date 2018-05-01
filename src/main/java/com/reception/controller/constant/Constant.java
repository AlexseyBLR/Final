package com.reception.controller.constant;

public class Constant {
    public static class RegistrationProperty {

        public final static String FIRST_NAME_PARAMETER = "first_name";
        public final static String LAST_NAME_PARAMETER = "last_sureName";
        public final static String PATRONYMIC_PARAMETER = "patronymic";
        public final static String EMAIL_PARAMETER = "email";
        public final static String PASSWORD_PARAMETER = "password";
        public final static String PHONE_PARAMETER = "phoneNumber";
        public final static String MATH_RESULT_PARAMETER = "mathResult";
        public final static String PHYS_RESULT_PARAMETER = "physResult";
        public final static String LANG_RESULT_PARAMETER = "langResult";
        public final static String SERT_RESULT_PARAMETER = "sertResult";

    }

    public static class WebProperty {

        public final static String PAGE_USER = "/home";
        public final static String PAGE_REGISTRATION = "/registration";
        public final static String PAGE_ERROR = "/error";
        public final static String PAGE_USER_REQUEST = "/userReq";
        public final static String PAGE_USER_RESULT = "/result";
        public final static String PAGE_USER_MAIN = "/userMain";
        public final static String PAGE_USER_UPDATE = "/userUpdate";

        public final static String PAGE_ADMIN = "/adminMain";
        public final static String PAGE_ADMIN_RESULT = "/adminResult";
        public final static String PAGE_ADMIN_REQUEST = "/adminRequests";
        public final static String PAGE_ADMIN_SHOW_USERS = "/showUsers";
        public final static String PAGE_LOGIN = "/login";
        public final static String HIDDEN_PARAMETER = "command";


    }

    public static class RequestProperty {

        public static final String ARCHITECTURE_BUILDING_FACULTY = "Faculty: ARCHITECTURE, speciality: BUILDING";
        public static final String ARCHITECTURE_DESIGN_FACULTY = "Faculty: ARCHITECTURE, speciality: DESIGN";
        public static final String MECHANICAL_EXPLOATATION_FACULTY = "Faculty: MECHANICAL, speciality: EXPLOATATION";
        public static final String MECHANICAL_REPAIR_FACULTY = "Faculty: MECHANICAL, speciality: REPAIR";
    }

    public static class ResultProperty {

        public static final String ARCHITECTURE_BUILDING_FACULTY = "'Faculty: ARCHITECTURE, speciality: BUILDING'";
        public static final String ARCHITECTURE_DESIGN_FACULTY = "'Faculty: ARCHITECTURE, speciality: DESIGN'";
        public static final String MECHANICAL_EXPLOATATION_FACULTY = "'Faculty: MECHANICAL, speciality: EXPLOATATION'";
        public static final String MECHANICAL_REPAIR_FACULTY = "'Faculty: MECHANICAL, speciality: REPAIR'";
    }
}

