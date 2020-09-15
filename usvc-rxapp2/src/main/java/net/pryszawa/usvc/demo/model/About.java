package net.pryszawa.usvc.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Data
@ToString
@Table("abouts")
@AllArgsConstructor
@NoArgsConstructor
public class About {

    @Id
    @Column("id")
    private Long id;

    @Column("description")
    private String desc;

}
