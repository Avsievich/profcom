package boost.auth;

import javax.persistence.*;

@Entity
public class PersonRole {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
@ManyToOne
    private Role role;
@ManyToOne
    private Person person;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
}
