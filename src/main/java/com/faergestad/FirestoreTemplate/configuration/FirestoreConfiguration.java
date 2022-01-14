package com.faergestad.FirestoreTemplate.configuration;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.FirestoreOptions;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.FileInputStream;
import java.io.IOException;

@Configuration
public class FirestoreConfiguration {

    @Bean
    public Firestore configureFirestore() throws IOException {
        FileInputStream serviceAccount =
                new FileInputStream("sandbox-fedb8-b1673504d687.json");

        FirestoreOptions options = FirestoreOptions.newBuilder()
                .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                .setProjectId("sandbox-fedb8")
                .build();

        return options.getService();
    }
}
