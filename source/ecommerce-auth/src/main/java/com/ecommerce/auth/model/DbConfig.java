package com.ecommerce.auth.model;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "db_db_config")
@Data
public class DbConfig {
    @Id
    @GenericGenerator(name = "idGenerator", strategy = "com.ecommerce.auth.service.id.IdGenerator")
    @GeneratedValue(generator = "idGenerator")
    private Long id;
    private String name;
    private String url;
    private String username;
    private String password;
    @Column(name = "max_connection")
    private Integer maxConnection;

    @Column(name = "driver_class_name")
    private String driverClassName;
    private boolean initialize;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "service_id")
    private Service service;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "server_provider_id")
    private ServerProvider serverProvider;
}
