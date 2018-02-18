package boost.auth;

import javax.persistence.*;

@Entity
public class Right {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @ManyToOne
    private Resourse resourse;
    @ManyToOne
    private Role role;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Resourse getResourse() {
        return resourse;
    }

    public void setResourse(Resourse resourse) {
        this.resourse = resourse;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
