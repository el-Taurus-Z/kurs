package by.bsuir.domain.entity;

public enum UserStatus {

    ADMIN(1),

    USER(2),

    VALUER(3);

    private int id;
    private static final long serialVersionUID = 1L;

    UserStatus(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
}
