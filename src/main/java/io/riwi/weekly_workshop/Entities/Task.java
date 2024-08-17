package io.riwi.weekly_workshop.Entities;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalTime;



@Entity
@Table(name = "task")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "tit" +
            "le", length = 100 ,nullable = false)
    private String title;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "creation_date", nullable = false)
    private LocalDate creationDate;

    @Column(name = "creation_time", nullable = false)
    private LocalTime timeCreation;

    @Column(name = "state", nullable = false)
    private TaskState state;

    @PrePersist
    protected void onCreate(){
        this.creationDate = LocalDate.now();
        if (this.state == null){
            this.state = TaskState.PENDING;
        }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }

    public LocalTime getTimeCreation() {
        return timeCreation;
    }

    public void setTimeCreation(LocalTime timeCreation) {
        this.timeCreation = timeCreation;
    }

    public TaskState getState() {
        return state;
    }

    public void setState(TaskState state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", creationDate=" + creationDate +
                ", timeCreation=" + timeCreation +
                ", state=" + state +
                '}';
    }
}


