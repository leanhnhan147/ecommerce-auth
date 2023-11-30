package com.ecommerce.auth.mapper;

import com.ecommerce.auth.dto.db.config.DbConfigDto;
import com.ecommerce.auth.form.db.config.CreateDbConfigForm;
import com.ecommerce.auth.form.db.config.UpdateDbConfigForm;
import com.ecommerce.auth.model.DbConfig;
import org.mapstruct.*;

import java.util.List;


@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE,
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        uses = {ServerProviderMapper.class})
public interface DbConfigMapper {
    @Mapping(source = "driverClassName", target = "driverClassName")
    @Mapping(source = "url", target = "url")
    @Mapping(source = "username", target = "username")
    @Mapping(source = "password", target = "password")
    @Mapping(source = "initialize", target = "initialize")
    @Mapping(source = "serviceId", target = "service.id")
    @Mapping(source = "maxConnection", target = "maxConnection")
    @BeanMapping(ignoreByDefault = true)
    @Named("adminCreateMapping")
    DbConfig fromCreateFormToEntity(CreateDbConfigForm createDbConfigForm);

    @Mapping(source = "initialize", target = "initialize")
    @Mapping(source = "maxConnection", target = "maxConnection")
    @BeanMapping(ignoreByDefault = true)
    @Named("adminUpdateMapping")
    void fromUpdateFormToEntity(UpdateDbConfigForm updateDbConfigForm, @MappingTarget DbConfig dbConfig);

    @Mapping(source = "id", target = "id")
    @Mapping(source = "name", target = "name")
    @Mapping(source = "driverClassName", target = "driverClassName")
    @Mapping(source = "url", target = "url")
    @Mapping(source = "username", target = "username")
    @Mapping(source = "password", target = "password")
    @Mapping(source = "initialize", target = "initialize")
    @Mapping(source = "maxConnection", target = "maxConnection")
    @Mapping(source = "serverProvider", target = "serverProviderDto",qualifiedByName = "adminGetServerProviderDto")
    @BeanMapping(ignoreByDefault = true)
    @Named("adminGetMapping")
    DbConfigDto fromEntityToDto(DbConfig dbConfig);

    @IterableMapping(elementTargetType = DbConfigDto.class, qualifiedByName = "adminGetMapping")
    List<DbConfigDto> fromEntityListToDtoList(List<DbConfig> dbConfigList);

    @Mapping(source = "id", target = "id")
    @Mapping(source = "name", target = "name")
    @Mapping(source = "initialize", target = "initialize")
    @Mapping(source = "serverProvider", target = "serverProviderDto",qualifiedByName = "fromEntityToPublicServerProviderDto")
    @BeanMapping(ignoreByDefault = true)
    @Named("fromEntityToDetailDto")
    DbConfigDto fromEntityToDetailDto(DbConfig dbConfig);
}
