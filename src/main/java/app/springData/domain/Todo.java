package app.springData.domain;

import app.springData.domain.enums.Priority;
import lombok.Data;

import javax.jws.soap.SOAPBinding;
import javax.persistence.*;
import java.util.Date;

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
    private Priority priority;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = true)
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
