package FiturCRUD;

public interface DetailAkun {
    String getUsername();
    String getPassword();
    boolean isAdmin();
    void ubahPassword(String passBaru);
    void ubahUsername(String usernameBaru);
}