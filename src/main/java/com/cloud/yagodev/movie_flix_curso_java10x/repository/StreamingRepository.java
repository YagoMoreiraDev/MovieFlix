package com.cloud.yagodev.movie_flix_curso_java10x.repository;

import com.cloud.yagodev.movie_flix_curso_java10x.entity.Streaming;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StreamingRepository extends JpaRepository<Streaming, Long> {
}
