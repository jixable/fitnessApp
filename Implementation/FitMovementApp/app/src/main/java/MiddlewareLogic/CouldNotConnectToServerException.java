package MiddlewareLogic;

public class CouldNotConnectToServerException extends Exception {
    public CouldNotConnectToServerException() {
        super("Could not connect to the server. Please try again later.");
    }
}
