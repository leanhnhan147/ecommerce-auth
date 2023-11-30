package com.ecommerce.auth.form.employee;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@ApiModel
public class UpdateEmployeeAccountAdminForm {

    @NotNull(message = "id cant not be null")
    @ApiModelProperty(name = "id", required = true)
    private Long id;
    @ApiModelProperty(name = "email")
    private String email;
    @ApiModelProperty(name = "password")
    private String password;
    @NotEmpty(message = "fullName cant not be null")
    @ApiModelProperty(name = "fullName", required = true)
    private String fullName;
    @ApiModelProperty(name = "avatarPath")
    private String avatarPath ;
    @NotNull(message = "groupId cant not be null")
    @ApiModelProperty(name = "groupId", required = true)
    private Long groupId;
    @NotNull(message = "status cant not be null")
    @ApiModelProperty(name = "status", required = true)
    private Integer status;
    @NotNull(message = "parentId cant not be null")
    @ApiModelProperty(name = "parentId", required = true)
    private Long parentId;
}
