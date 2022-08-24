package com.hcu.accountservice.common;

public final class ApiPath {
    public static final class AccountCtrl {
        public static final String BASE = "account";
        public static final String GET = "/{id}";
        public static final String DELETE = "/{id}";

        private AccountCtrl() {
        }
    }
}
