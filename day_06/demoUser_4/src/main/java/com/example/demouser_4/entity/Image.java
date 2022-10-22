package com.example.demouser_4.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "image")
public class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Integer id;

   @Column(name ="uploaded_at")
    private LocalDateTime uploadedAt;

   @Lob //Large object
   @Column(name = "data")
    private byte[] data;

   @ManyToOne
   @JoinColumn(name ="user_id")
   private User user;
}