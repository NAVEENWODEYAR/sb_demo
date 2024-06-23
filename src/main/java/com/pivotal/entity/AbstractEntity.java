package com.pivotal.entity;

import java.time.LocalDateTime;
import jakarta.persistence.*;
import lombok.Data;

@Data
@MappedSuperclass
public class AbstractEntity {
    
    @Column(name = "CREATED_BY")
    private String createdBy;
    
    @Column(name = "CREATED_DATE")
    private LocalDateTime createdDate;
    
    @Column(name = "MODIFIED_BY")
    private String modifiedBy;
    
    @Column(name = "MODIFIED_DATE")
    private LocalDateTime modifiedDate;
    
    @PrePersist
    protected void created() {createdDate = LocalDateTime.now();}
    
    @PreUpdate
    protected void updated() { modifiedDate = LocalDateTime.now();}
    
}
