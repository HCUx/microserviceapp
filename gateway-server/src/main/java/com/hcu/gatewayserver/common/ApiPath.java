package com.hcu.gatewayserver.common;

public final class ApiPath {
    private ApiPath() {
    }

    public static final class HystrixCtrl {
        public static final String BASE = "fb";
        public static final String ACCOUNT = "/account";
        public static final String TICKET = "/ticket";

        private HystrixCtrl() {
        }
    }
}
