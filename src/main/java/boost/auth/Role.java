package boost.auth;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class Role {

    @Id
    private String code;

    @OneToMany
    private List<Right> rights;

    @OneToMany
    private List<PersonRole>personRoles;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public List<Right> getRights() {
        return rights;
    }

    public void setRights(List<Right> rights) {
        this.rights = rights;
    }

    public List<PersonRole> getPersonRoles() {
        return personRoles;
    }

    public void setPersonRoles(List<PersonRole> personRoles) {
        this.personRoles = personRoles;
    }
}
