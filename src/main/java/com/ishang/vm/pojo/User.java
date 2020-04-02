package com.ishang.vm.pojo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.persistence.*;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;

//@Getter:是一个Lombok注解,用来为POJO类生产getter方法,免除我们自己手动生成;
//@AllArgsConstructor:是一个Lombok注解,,用来为POJO类生成全参构造器;
//@ApiModel:是一个Swagger注解,用来为POJO类做注释;
//@ApiModelProperty:是一个Swagger注解,用来为POJO类的属性做注释。


@Entity
@Table(name = "user")
@JsonIgnoreProperties({"handler","hibernateLazyInitializer"})
@ApiModel(description = "用户模型")
@Getter
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")

    @ApiModelProperty("用户ID")
    int id;
    @ApiModelProperty("用户名")
    String username;
    @ApiModelProperty("用户密码")
    String password;
}
