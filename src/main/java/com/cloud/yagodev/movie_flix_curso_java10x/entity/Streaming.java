package com.cloud.yagodev.movie_flix_curso_java10x.entity;

import jakarta.persistence.*;
import lombok.*;

@Builder
@Entity
@Table(name = "tb_streaming")
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Streaming {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Setter
    @Column(length = 100, nullable = false)
    private String name;
}
