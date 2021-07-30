package test.BannerCategory.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "Request")
public class Request extends BaseModelEntity {
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "banner_id")
//    private Banner banner;

    @Getter
    @Setter
    private String user_agent;

    @Getter
    @Setter
    private String ip_address;

    @Getter
    @Setter
    private String date;

    public Request() {

    }
}
