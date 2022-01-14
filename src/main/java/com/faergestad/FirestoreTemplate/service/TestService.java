package com.faergestad.FirestoreTemplate.service;

import com.faergestad.FirestoreTemplate.annotation.EncryptedOperation;
import com.google.cloud.firestore.Firestore;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class TestService {

    private final Firestore firestore;

    @EncryptedOperation
    public TestObject test(TestObject testObject) {
        // Save something to firestore
        return testObject;
    }

}
