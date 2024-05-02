package FiturCRUD;

public final class Akun implements DetailAkun{
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

        @Override
        public void ubahPassword(String passBaru){
            this.password = passBaru;
            System.out.println("Password anda berhasil diubah !");
        }

        @Override
        public void ubahUsername(String usernameBaru){
            this.username = usernameBaru;
            System.out.println("Username anda berhasil diubah menjadi " + this.username + " !");
        }
}
