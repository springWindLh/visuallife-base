package lh.world.base.form;

import lh.world.base.domain.Story;
import lh.world.base.form.support.BaseForm;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import java.util.Date;

/**
 * Created by lh on 2016/8/31.
 */
public class StoryForm extends BaseForm {
    @NotBlank(message = "{story.picture.notBlank}")
    private String picture;

    @NotBlank(message = "{story.description.notBlank}")
    @Length(message = "{story.description.length}", max = 240)
    private String description;

    private Integer vote;

    public StoryForm() {
    }

    public StoryForm(Story story) {
        this.setId(story.getId());
        this.setPicture(story.getPicture());
        this.setDescription(story.getDescription());
        this.setVote(story.getVote());
    }

    public Story asStory() {
        Story story = new Story();
        if (this.getId() != null) {
            story.setId(this.getId());
            story.setUpdatedTime(new Date());
        }
        story.setPicture(this.getPicture());
        story.setDescription(this.getDescription());
        story.setVote(this.getVote());
        return story;
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

    public Integer getVote() {
        return vote;
    }

    public void setVote(Integer vote) {
        this.vote = vote;
    }
}
