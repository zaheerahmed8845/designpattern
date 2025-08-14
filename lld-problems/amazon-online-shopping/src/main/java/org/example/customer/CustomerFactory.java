package org.example.customer;

public class CustomerFactory {
    private CustomerFactory() {
    }

    public static Customer createGuest() {
        return new Guest();
    }

    public static Customer createAuthenticatedUser(String username) {
        // username parameter kept for future use; diagram does not mandate fields here
        return new AuthenticatedUser();
    }
}
