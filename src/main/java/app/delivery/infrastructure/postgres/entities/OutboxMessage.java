package app.delivery.infrastructure.postgres.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;
import java.util.UUID;

@Getter
@Setter
@Entity
@DynamicUpdate
@Table(name = "outbox_message")
public class OutboxMessage {

    @Id
    @GeneratedValue
    private UUID id;

    private String type;

    private String content;

    @CreationTimestamp
    @Column(nullable = false, updatable = false)
    private Date createDate;

    @UpdateTimestamp
    private Date publishDate;
}
