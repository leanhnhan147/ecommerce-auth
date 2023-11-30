package com.ecommerce.auth.dto.service;

import com.ecommerce.auth.dto.ABasicAdminDto;
import com.ecommerce.auth.dto.account.AccountDto;
import com.ecommerce.auth.dto.provider.ServerProviderDto;
import com.ecommerce.auth.model.Group;
import lombok.Data;

@Data
public class ServiceDto extends ABasicAdminDto {
    private String serviceName;
    private Group group;
    private String logoPath;
    private String bannerPath;
    private String hotline;
    private String settings;
    private String lang;
    private ServerProviderDto serverProviderDto;
    private Integer status;
    private AccountDto accountDto;

    private String tenantId;
    private String serviceTenantId;
}
