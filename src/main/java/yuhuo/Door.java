package yuhuo;

public interface Door {

    void openDoor();

    void closeDoor();

    default void theftProof() {

    }
    default void waterProof() {

    }
    default void fireProof() {

    }
}
