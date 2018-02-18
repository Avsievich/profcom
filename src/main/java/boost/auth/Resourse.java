package boost.auth;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class Resourse {

    @Id
    private String id;

    @OneToMany
    private List<Right> rights;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<Right> getRights() {
        return rights;
    }

    public void setRights(List<Right> rights) {
        this.rights = rights;
    }
}
