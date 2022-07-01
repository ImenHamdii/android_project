package isetb.tp6.gestionbiblio;

import javax.security.auth.callback.PasswordCallback;

public class NewUser {
        private int id;
        private String name;
        private String pwd;

        public NewUser() {
        }

        public NewUser(String name, String pwd) {
            this.name = name;
            this.pwd = pwd;
        }

        public NewUser(int id, String name, String pwd) {
            this.id = id;
            this.name = name;
            this.pwd = pwd;
        }

        public int getId() { return id; }
        public void setId(int id) { this.id = id; }
        public String getName() { return name; }
        public void setName(String name) { this.name = name; }
        public String getPwd() { return String.valueOf(pwd);}
        public void setPwd(String pwd) { this.pwd = pwd; }
}

