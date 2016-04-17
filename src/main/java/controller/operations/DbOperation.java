package controller.operations;

/**
 * Created by Fedor on 16.04.2016.
 */
public interface DbOperation {
    String MESSAGE_CREATE = "Record added";
    String MESSAGE_DELETE = "Record deleted";
    String MESSAGE_UPDATE = "Record updated";

    String requestToDb(String name, String definition);
}
