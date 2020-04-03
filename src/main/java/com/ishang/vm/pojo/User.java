package com.ishang.vm.pojo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.persistence.*;

import io.swagger.annotations.ApiModel;
//import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;

import java.util.List;


//@Getter:是一个Lombok注解,用来为POJO类生产getter方法,免除我们自己手动生成;
//@AllArgsConstructor:是一个Lombok注解,,用来为POJO类生成全参构造器;
//@ApiModel:是一个Swagger注解,用来为POJO类做注释;
//@ApiModelProperty:是一个Swagger注解,用来为POJO类的属性做注释。

@ApiModel(description = "用户模型")
@Data
@Entity
@Table(name = "user")
@ToString
@JsonIgnoreProperties({"handler","hibernateLazyInitializer"})

public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    /**
     * Username.
     */
    private String username;

    /**
     * Password.
     */
    private String password;

    /**
     * Salt for encoding.
     */
    private String salt;

    /**
     * Real name.
     */
    private String name;

    /**
     * Phone number.
     */
    private String phone;

    /**
     * Email address.
     */
    private String email;

    /**
     * User status.
     */
    private boolean enabled;

    /**
     * Transient property for storing role owned by current user.
     */
    @Transient
    private List<AdminRole> roles;


}
