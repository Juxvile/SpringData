package app.springData.domain;

import app.springData.domain.enums.Priority;
import lombok.Data;

import javax.jws.soap.SOAPBinding;
import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@Table(name = "todo")
public class Todo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "comment")
    private String comment;

    @Column(name = "startDate")
    private Date startDate;

    @Column(name = "endDate")
    private Date endDate;

    @Column(name = "important")
    private Boolean important;

    @Column(name = "priority")
    @Enumerated(EnumType.STRING)
    private Priority priority;

    @ManyToMany
    @JoinTable(name = "todo_tag", joinColumns = @JoinColumn(name = "todo_id"), inverseJoinColumns = @JoinColumn(name = "tag_id"))
    private Set<Tag> tagList = new HashSet<>();

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    public void setUser(User user){
        setUser(user, false);
    }

    public void setUser(User user, Boolean otherSideHasBeenSet){
        this.user = user;
        if(otherSideHasBeenSet){
            return;
        }
        user.addTodo(this, true);
    }

    public void removeUser(User user, boolean otherSideHasBeenSet) {
        this.user = null;
        if(otherSideHasBeenSet){
            return;
        }
        user.removeTodo(this, true);
    }
}
