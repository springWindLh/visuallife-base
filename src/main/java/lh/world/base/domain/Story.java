package lh.world.base.domain;

import lh.world.base.domain.support.CanLogicDelDomain;

import javax.persistence.*;

/**
 * Created by lh on 2016/8/12.
 */
@Entity
@Table(name = "story")
public class Story extends CanLogicDelDomain {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "picture")
    private String picture;
    @Column(name = "description")
    private String description;
    @Column(name = "vote")
    private Integer vote = 0;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public Story() {
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Integer getVote() {
        return vote;
    }

    public void setVote(Integer vote) {
        this.vote = vote;
    }
}
