package boost.auth;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class Person {

   @Id
    private String login;
   private String password;
   private String name;
   @OneToMany
    private List<PersonRole>personRoles;


    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<PersonRole> getPersonRoles() {
        return personRoles;
    }

    public void setPersonRoles(List<PersonRole> personRoles) {
        this.personRoles = personRoles;
    }
}
