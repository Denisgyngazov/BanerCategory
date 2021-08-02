package test.BannerCategory.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.util.Date;

@Entity
public class Request extends BaseModelEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "banner_id")
    private Banner banner;

    @Getter
    @Setter
    @NotBlank(message = "User_agent should not be empty")
    private String user_agent;

    @Getter
    @Setter
    @NotBlank(message = "Ip address should not be empty")
    @Pattern(regexp = "^[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}$")
    private String ip_address;

    @Getter
    @Setter
    @FutureOrPresent(message = "Date should be future or present")
    private Date date;
}
