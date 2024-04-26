package FiturCRUD;

public final class Akun {
        private String username;
        private String password;
        private final boolean isAdmin;
    
        public Akun(String username, String password, final boolean isAdmin) {
            this.username = username;
            this.password = password;
            this.isAdmin = isAdmin;
        }
    
        public String getUsername() {
            return username;
        }
    
        public String getPassword() {
            return password;
        }
    
        public boolean isAdmin() {
            return isAdmin;
        }
}
