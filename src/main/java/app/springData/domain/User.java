package app.springData.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@Table(name = "_user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "email", unique = true, nullable = false)
    private String email;

    @Column(name = "password", nullable = true )
    private String password;

    @OneToMany(mappedBy = "_user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Todo> todoList = new HashSet<>();

    public void addTodo (Todo todo){
        addTodo(todo, false);
    }

    public void removeTodo (Todo todo){
        removeTodo(todo, false);
    }

    public void addTodo (Todo todo, Boolean otherSideHasBeenSet){
        this.getTodoList().add(todo);
        if(otherSideHasBeenSet){
            return;
        }
        todo.setUser(this, true);
    }

    public void removeTodo (Todo todo, Boolean otherSideHasBeenSet){
        this.getTodoList().remove(todo);
        if(otherSideHasBeenSet){
            return;
        }
        todo.removeUser(this, true);
    }
}
