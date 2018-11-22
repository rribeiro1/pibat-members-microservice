package members.model;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Getter
@Builder
@ToString
@EqualsAndHashCode
@Table(name = "member")
public class Member {

    @Id
    @Column(name = "id")
    private Integer id;

    @NotNull
    @Column(name = "name")
    private String name;

}
