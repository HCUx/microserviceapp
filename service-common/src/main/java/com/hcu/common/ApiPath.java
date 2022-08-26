package com.hcu.common;

public final class ApiPath {
    private ApiPath() {
    }

    public static final class AccountCtrl {
        public static final String BASE = "account";
        public static final String GET = "/{id}";
        public static final String GET_COMBINE = BASE + "/{id}";

        private AccountCtrl() {
        }
    }

    public static final class TicketCtrl {
        public static final String BASE = "ticket";
        public static final String GET = "/{id}";
        public static final String DELETE = "/{id}";

        private TicketCtrl() {
        }
    }
}
