package com.alterra.submission.domain.model;

import com.alterra.submission.domain.common.BaseDao;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Where;

import javax.persistence.*;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table(name = "student")
@NoArgsConstructor
@Where(clause = "is_deleted = false")
public class StudentModel extends BaseDao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "nim", nullable = false)
    private String nim;

    @Column(name = "address", nullable = false)
    private String address;
}
